package servise;

import org.jsoup.Jsoup;


/**
 * Данный класс осущестляет подключение к ресурсу
 */
public class Service extends AbstractService {


    public void init(String uri) {
        try {
            /** Open connection. */
            reqDoc = Jsoup.connect(uri).get();
            System.out.println();
            System.out.println(uri);
            System.out.println("isProduct(str); -> "+isProduct(str));
            System.out.println("isCatalog(str); -> " + isCatalog(str));
            System.out.println("isDesCatalog(str) -> "+isDesCatalog(str));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


}
