package test_02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;


/**
 * Created by Alex on 14.06.2015.
 */
public class Selector_01 {

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("http://kingsmoke.com.ua/product_list").get();
            //List<Element> elms = doc.select(".b-content__body b-content__body_hor-padding_none");
            //System.out.println(elms);
            String str = doc.select(".b-product-groups_view_list").html();
         System.out.println(str);

            //Allways <img class="b-product-groups__image
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
