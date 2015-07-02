package test_03.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductList implements Serializable {

    private List<Product> productList = new ArrayList<>();

    public ProductList() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProductList(Product product) {
        this.productList.add(product);
    }

    public void printProduct() {
        for (Product iter : productList) {
            System.out.println();
            System.out.println("***************************");
            System.out.println(iter);
            System.out.println("***************************");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "productList=" + productList +
                '}';
    }
}
