package controller;


import services.FillingProductServices;

public class TestMain {

    public static void main(String[] args) {
        FillingProductServices productServices = new FillingProductServices();
        productServices.init();
    }

}
