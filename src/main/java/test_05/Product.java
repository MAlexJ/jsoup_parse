package test_05;

public class Product {
    private String id;
    private String name;
    private int img;

    public Product() {
    }

    public Product(String name, int img) {
        this.name = name;
        this.img = img;
        this.id = generationId();
    }

    private String generationId() {
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append("_" + getName().length());
        sb.append("_" + getImg() + "_");
        String str = this.getName();
        sb.append(str.replace(' ', '_'));
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (img != product.img) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        return !(name != null ? !name.equals(product.name) : product.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + img;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", img=" + img +
                '}';
    }
}
