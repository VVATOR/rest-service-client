package by.epamlab.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Documents")
public class Documents {

    private List<Document> documents = new ArrayList<>();

    public Documents() {
        super();
    }

    public Documents(ArrayList<Document> list) {
        this.documents = list;
    }

    @XmlElement(name = "Document")
    public List<Document> getDocument() {
        return documents;
    }

    public void setDocument(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Documents [documents=");
        builder.append(documents);
        builder.append("]");
        return builder.toString();
    }

}
