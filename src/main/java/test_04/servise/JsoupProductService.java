package test_04.servise;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import test_03.constants.Constants;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by root on 05.07.15.
 */
public class JsoupProductService extends AbstractServise implements Constants{
    private Document reqDoc;
    private Elements elements;
    private String str;

    public void init(int timeout) {
        try {
            /** Open connection. */
            reqDoc = Jsoup.connect(PRODUCT).timeout(timeout).get();
            /**  Parse CSS selector <ul class=productCatalogSelectorCSS >... <ul/>. */
            str = reqDoc.select(PRODUCT_SELECTOR_CSS).html();
            /**  Parse context. */

            /** Name */
            elements = reqDoc.select(".b-product__name");
            System.out.println(elements.text());

            /** Price */
            elements = reqDoc.select(".b-product__price");
            System.out.println(elements.text());

            /** State */
            elements = reqDoc.select(".b-product__state_type_available");
            System.out.println(elements.text());

            /** Text */
            elements = reqDoc.select(".b-online-edit");
            System.out.println(elements.select("h3").text());
            System.out.println(elements.select("p").text());
           // System.out.println(elements.select("ul").first().select("li"));



        } catch (UnknownHostException e) {
            /** UnknownHostException -> No internet connection. */
            System.out.println("No internet connection");
            System.exit(0);
        } catch (IOException e) {
            /** SocketTimeException -> replay connection. */
            if (timeout < 5000) init(timeout * 40);
            else throw new IllegalArgumentException(">> IllegalArgumentException -> Error connecting to the Internet");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


}
