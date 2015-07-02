package test_03.entity;

import java.io.Serializable;


public class Product implements Serializable {
    private String image;
    private String title;
    private float price;
    private String stok;
    private int amount;

    public Product() {
    }

    public Product(String image, String title, float price, String stok, int amount) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.stok = stok;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

        Product product = (Product) o;

        if (Float.compare(product.price, price) != 0) return false;
        if (amount != product.amount) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        return !(stok != null ? !stok.equals(product.stok) : product.stok != null);

    }

    @Override
    public int hashCode() {
        int result = image != null ? image.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (stok != null ? stok.hashCode() : 0);
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stok='" + stok + '\'' +
                ", amount=" + amount +
                '}';
    }
}
