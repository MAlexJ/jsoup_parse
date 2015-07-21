package controller;


import constants.Constants;
import servise.Service;

public class MainContoller implements Constants {
    public static void main(String[] args) {

        Service service = new Service();
        service.init(WEBSITE);
        service.init("http://kingsmoke.com.ua/delivery_info");

        //  .b-title_type_product
        service.init("http://kingsmoke.com.ua/product_list");
        service.init("http://kingsmoke.com.ua/g5379027-elektronnye-sigarety");
        service.init("http://kingsmoke.com.ua/p75414836-elektronnaya-sigareta-ego.html");
        service.init("http://kingsmoke.com.ua/g5436510-komplektuyuschie");
        service.init("http://kingsmoke.com.ua/g5445406-zaryadnye-ustrojstva");

    }
}
