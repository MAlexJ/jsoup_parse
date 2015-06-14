package test_01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Create_01_JSOUP_String {
    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head><body><p>Hello, world!</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc);
    }
}
