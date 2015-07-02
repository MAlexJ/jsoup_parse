package test_03.entity;

import java.io.Serializable;


public class Product implements Serializable {
    private String id;
    private String image;
    private String title;
    private float price;
    private String stok;
    private int amount;
    private String link;

    public Product() {
    }

    public Product(String id, String image, String title, float price, String stok, int amount, String link) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.price = price;
        this.stok = stok;
        this.amount = amount;
        this.link = link;
    }

    public void generationID() {
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(this.getTitle().length());
        sb.append(this.getImage().length());
        sb.append("_");
        String str = this.getTitle();
        sb.append(str.replace(' ', '_'));
        setId(sb.toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Float.compare(product.price, price) != 0) return false;
        if (amount != product.amount) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (stok != null ? !stok.equals(product.stok) : product.stok != null) return false;
        return !(link != null ? !link.equals(product.link) : product.link != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (stok != null ? stok.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stok='" + stok + '\'' +
                ", amount=" + amount +
                ", link='" + link + '\'' +
                '}';
    }
}
