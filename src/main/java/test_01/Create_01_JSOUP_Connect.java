package test_01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Create_01_JSOUP_Connect {

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("http://github.com/").get();
            System.out.println(doc);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
