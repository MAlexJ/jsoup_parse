package test_02;

public class Catalog {
    private String id;
    private String name;
    private String image;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catalog catalog = (Catalog) o;

        if (id != null ? !id.equals(catalog.id) : catalog.id != null) return false;
        if (name != null ? !name.equals(catalog.name) : catalog.name != null) return false;
        return !(image != null ? !image.equals(catalog.image) : catalog.image != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
