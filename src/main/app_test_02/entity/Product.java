package entity;


import java.util.ArrayList;
import java.util.List;

public class Product {
    //The main members
    private String id;
    private String name;
    private String link;
    private List<Product> productList;

    //The others members
    private String image;
    private String title;
    private float price;
    private String stok;
    private int amount;

    public Product() {
        productList = new ArrayList<>();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public boolean addList(Product product) {
        return productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void generationID() {
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(this.getName().length());
        sb.append(this.getLink().length());
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", productList=" + productList +
                '}';
    }
}
