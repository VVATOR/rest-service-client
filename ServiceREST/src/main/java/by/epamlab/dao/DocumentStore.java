package by.epamlab.dao;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import by.epamlab.beans.Chapter;
import by.epamlab.beans.Chapters;
import by.epamlab.beans.Document;
import by.epamlab.beans.Documents;
import by.epamlab.exception.ElementNotFoundException;

public class DocumentStore implements IDaoCRUID<Document> {
    private static final Logger LOG = Logger.getLogger(DocumentStore.class);
    private static AtomicInteger idAtomicInteger = new AtomicInteger();
    private static Map<Integer, Document> store = new ConcurrentHashMap<Integer, Document>();

    static {
        DocumentStore ds = new DocumentStore();

        Chapters chapters = new Chapters();
        chapters.getChapters().add(new Chapter(1, 22, 21));
        chapters.getChapters().add(new Chapter(2, 12, 12));
        chapters.getChapters().add(new Chapter(3, 23, 12));
        chapters.getChapters().add(new Chapter(4, 34, 12));
        chapters.getChapters().add(new Chapter(5, 54, 322));
        chapters.getChapters().add(new Chapter(6, 45, 122));
        ds.create(new Document(1, "aaa", chapters));

        chapters = new Chapters();
        chapters.getChapters().add(new Chapter(1, 65, 656));
        chapters.getChapters().add(new Chapter(2, 44, 457));
        chapters.getChapters().add(new Chapter(3, 55, 132));
        ds.create(new Document(2, "bbb", chapters));

        chapters = new Chapters();
        chapters.getChapters().add(new Chapter(1, 5, 345));
        chapters.getChapters().add(new Chapter(2, 4, 33));
        chapters.getChapters().add(new Chapter(3, 3, 444));
        ds.create(new Document(3, "ccc", chapters));

        chapters = new Chapters();
        chapters.getChapters().add(new Chapter(1, 5, 32));
        chapters.getChapters().add(new Chapter(2, 4, 3443));
        chapters.getChapters().add(new Chapter(3, 3, 123));
        chapters.getChapters().add(new Chapter(4, 4, 332));
        chapters.getChapters().add(new Chapter(5, 3, 4424));
        ds.create(new Document(4, "ddd", chapters));

        chapters = new Chapters();
        chapters.getChapters().add(new Chapter(1, 123, 345));
        chapters.getChapters().add(new Chapter(2, 12, 33));
        ds.create(new Document(5, "eee", chapters));
    }

    @Override
    public int create(Document element) {
        int num = idAtomicInteger.addAndGet(1);
        Document newDoc = element;
        newDoc.setId(num);
        store.put(num, newDoc);
        LOG.debug("document is created with ID: " + num);
        return num;
    }

    @Override
    public Document getById(int id) throws ElementNotFoundException {
        for (Entry<Integer, Document> es : store.entrySet()) {
            if (id == es.getValue().getId()) {
                LOG.debug("document is not be found by ID: " + id);
                return es.getValue();
            }
        }
        LOG.error("document is not be found by ID: " + id);
        throw new ElementNotFoundException();
    }

    public Documents list() {
        Documents documents = new Documents(new ArrayList<>(store.values()));
        System.out.println(documents);
        LOG.debug("document list getting from store: \n" + documents);
        return documents;
    }

    @Override
    public Document update(Document element) throws ElementNotFoundException {
        Document doc = getById(element.getId());
        store.put(element.getId(), element);
        LOG.debug("document is updated;");
        return doc;
    }

    @Override
    public void delete(int id) {
        store.remove(id);
        LOG.debug(store.values());
    }

    public Documents getChapterShortest() {
        Documents documents = new Documents(new ArrayList<>(store.values()));
        int minChapters = documents.getDocument().get(0).getChapters().getChapters().get(0).getNumberOfPage();
        for (Document doc : documents.getDocument()) {
            minChapters = doc.getChapters().getChapters().get(0).getNumberOfPage();
            for (Chapter chapter : doc.getChapters().getChapters()) {
                if (minChapters < chapter.getNumberOfPage()) {
                    minChapters = chapter.getChapterNumber();
                }
            }
        }

        Documents findDocuments = new Documents();
        for (Document doc : documents.getDocument()) {
            for (Chapter chapter : doc.getChapters().getChapters()) {
                if (minChapters == chapter.getNumberOfPage()) {
                    findDocuments.getDocument().add(doc);
                }
            }
        }
        LOG.debug(findDocuments);
        return findDocuments;
    }

}
