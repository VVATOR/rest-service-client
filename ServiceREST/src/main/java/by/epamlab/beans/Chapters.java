package by.epamlab.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Chapters")
public class Chapters {
    private List<Chapter> chapters = new ArrayList<>();

    public Chapters() {
        super();
    }

    public Chapters(ArrayList<Chapter> list) {
        this.chapters = list;
    }

    @XmlElement(name = "Chapter")
    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Chapters [chapters=");
        builder.append(chapters);
        builder.append("]");
        return builder.toString();
    }

}
