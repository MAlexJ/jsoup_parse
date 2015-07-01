package test_02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.UnknownHostException;

public class Selector_JSOUP {

    private final String WEBSITE = "http://kingsmoke.com.ua";
    private final String PRODUCT_CATALOG = "http://kingsmoke.com.ua/product_list";
    private final String PRODUCT_CATALOG_SELECTOR_CSS = ".b-product-groups_view_list";
    private ProductCatalog productCatalog = new ProductCatalog();

    private Document reqDoc;
    private Elements elements;
    private String str;

    public static void main(String[] args) {
        Selector_JSOUP regJO = new Selector_JSOUP();
        regJO.init(1000);
    }

    public void init(int timeout) {
        try {
            /** Open connection. */
            reqDoc = Jsoup.connect(PRODUCT_CATALOG).timeout(timeout).get();
            /**  Parse CSS selector <ul class=productCatalogSelectorCSS >... <ul/>. */
            str = reqDoc.select(PRODUCT_CATALOG_SELECTOR_CSS).html();
            /**  Parse context. */
            parseContext(str);
            productCatalog.printCatalog();
        } catch (UnknownHostException e) {
            /** UnknownHostException -> No internet connection. */
            System.out.println("No internet connection");
            System.exit(0);
        } catch (IOException e) {
            /** SocketTimeException -> replay connection. */
            if (timeout < 5000) init(timeout * 2);
            else throw new IllegalArgumentException(">> IllegalArgumentException -> Error connecting to the Internet");
        } catch (IllegalArgumentException e) {
            /** IllegalArgumentException -> parseContext(String str) -> str == null. */
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


    public void parseContext(String str) {
        if (str == null) {
            throw new IllegalArgumentException(">>> parseContext(String str) -> str == null");
        }
        char[] chars = str.toCharArray();
        int targetEnd = str.indexOf("</li>");
        if (targetEnd >= 0) {
            Catalog catalog = new Catalog();
            /** </li> -> char=5 */
            targetEnd += 5;
            char[] charsCatalog = new char[targetEnd];
            System.arraycopy(chars, 0, charsCatalog, 0, targetEnd);
            char[] resultArray = new char[chars.length - targetEnd];
            System.arraycopy(chars, targetEnd, resultArray, 0, chars.length - targetEnd);
            String resultString = new String(resultArray);
            /** <Link to catalog */
            reqDoc = Jsoup.parse(new String(charsCatalog));
            elements = reqDoc.select("a[href]");
            catalog.setLink(WEBSITE + elements.attr("href"));
            /** Name catalog */
            elements = reqDoc.select("img");
            catalog.setName(elements.attr("alt"));
            /** Image catalog */
            String src = elements.attr("src");
            String longdesc = elements.attr("longdesc");
            if (src.endsWith(".jpg") || src.endsWith(".jpeg")) {
                catalog.setImage(src);
            } else if (longdesc.endsWith(".jpeg") || longdesc.endsWith(".jpg")) {
                catalog.setImage(longdesc);
            } else {
            //** картинка по умолчанию
            }
            /** Id catalog */
            catalog.generationID();
            productCatalog.addCatalog(catalog);
            parseContext(resultString);
        } else {
            return;
        }
    }


}
