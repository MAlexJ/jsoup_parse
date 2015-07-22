package controller;


import entity.Product;
import services.AbstractServices;
import services.FillingProductServices;

public class TestMain extends AbstractServices{

    public static void main(String[] args) {
        FillingProductServices productServices = new FillingProductServices();
        productServices.init();

        for (Product iter : product.getProductList()) {
            System.out.println(iter);
        }
    }

}
