package test_02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.Arrays;


public class Selector_01 {

    private static ProductCatalog productCatalog = new ProductCatalog();

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("http://kingsmoke.com.ua/product_list").get();
            String str = doc.select(".b-product-groups_view_list").html();

            parceContext(str);

            productCatalog.printCatalog();

            //Allways <img class="b-product-groups__image
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void parceContext(String str) {
        if (str == null) {
            throw new ArithmeticException();
        }
        char[] chars = str.toCharArray();
        int targetEnd = str.indexOf("</li>");
        if (targetEnd >= 0) {
            targetEnd += 5;

            char[] charsCatalog = new char[targetEnd];
            System.arraycopy(chars, 0, charsCatalog, 0, targetEnd);

            String strCatalog = new String(charsCatalog);
            Catalog catalog = new Catalog(strCatalog);
            productCatalog.addCatalog(catalog);

            char[] resultArray = new char[chars.length - targetEnd];
            System.arraycopy(chars, targetEnd, resultArray, 0, resultArray.length);
            String resultString = new String(resultArray);
            parceContext(resultString);
        } else {
            System.out.println("```````````````return``````````````````");
            return;
        }
    }


}
