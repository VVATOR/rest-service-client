package by.epamlab.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Document")
public class Document {

    private int id;

    private String name;

    private Chapters chapters;

    public Document() {

    }

    public Document(int id, String name, Chapters chapters) {
        super();
        this.id = id;
        this.name = name;
        this.chapters = chapters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chapters getChapters() {
        return chapters;
    }

    public void setChapters(Chapters chapter) {
        this.chapters = chapter;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Document [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", chapter=");
        builder.append(chapters);
        builder.append("]");
        return builder.toString();
    }

}
