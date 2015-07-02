package test_03.controller;

import test_03.servise.JsoupCatalogService;


public class MainContoller {
    public static void main(String[] args) {

        JsoupCatalogService catalogService = new JsoupCatalogService();
        catalogService.init(100);


    }
}
