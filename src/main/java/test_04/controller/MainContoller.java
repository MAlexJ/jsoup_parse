package test_04.controller;

import test_04.servise.JsoupCatalogService;
import test_04.servise.JsoupDestinationCatalogService;
import test_04.servise.JsoupProductService;


public class MainContoller {
    public static void main(String[] args) {

        /** Catalog */
        JsoupCatalogService catalogService = new JsoupCatalogService();
        catalogService.init(100);
//
//        System.out.println();
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        /**  SubCatalog */
//        JsoupDestinationCatalogService jsoupDestinationCatalogService = new JsoupDestinationCatalogService();
//        jsoupDestinationCatalogService.init(100, "http://kingsmoke.com.ua/g5379027-elektronnye-sigarety");
//
//        System.out.println();
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        /** Product */

//        JsoupProductService jsoupProductService = new JsoupProductService();
//        jsoupProductService.init(100);
    }
}
