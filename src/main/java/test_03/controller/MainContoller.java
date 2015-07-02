package test_03.controller;

import test_03.servise.JsoupCatalogService;
import test_03.servise.JsoupDestinationCatalogService;


public class MainContoller {
    public static void main(String[] args) {

        JsoupCatalogService catalogService = new JsoupCatalogService();
        catalogService.init(100);

        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        JsoupDestinationCatalogService jsoupDestinationCatalogService = new JsoupDestinationCatalogService();
        jsoupDestinationCatalogService.init(100, "http://kingsmoke.com.ua/g5379027-elektronnye-sigarety");


    }
}
