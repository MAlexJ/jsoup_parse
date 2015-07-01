package test_02;

import java.io.Serializable;

public class Catalog implements Serializable {
    private String id;
    private String name;
    private String image;
    private String link;

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    public Catalog(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public void generationID() {
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(this.getName().length());
        sb.append(this.getImage().length());
        sb.append("_");
        String str = this.getName();
        sb.append(str.replace(' ', '_'));
        setId(sb.toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
