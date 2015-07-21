package test_04.servise;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import test_04.constants.Constants;
import test_04.entity.Catalog;

import java.io.IOException;
import java.net.UnknownHostException;

public class JsoupCatalogService extends AbstractServise implements Constants {
    private Document reqDoc;
    private Elements elements;
    private String str;

    public void init(int timeout) {
        try {
            /** Open connection. */
            reqDoc = Jsoup.connect(PRODUCT_CATALOG).timeout(timeout).get();
            /**  Parse CSS selector <ul class=productCatalogSelectorCSS >... <ul/>. */
            str = reqDoc.select(PRODUCT_CATALOG_SELECTOR_CSS).html();
            /**  Parse context. */
            parseContext(str);
            getCatalogList().printCatalog();
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
            catalog.setImage(searchImage(elements.attr("src"), elements.attr("longdesc")));
            /** Id catalog */
            catalog.generationID();
            getCatalogList().addCatalog(catalog);
            parseContext(resultString);
        } else {
            return;
        }
    }

    private String searchImage(String... str) {
        for (int i = 0; i < str.length; i++) {
            if (str[i].endsWith(".jpeg") || str[i].endsWith(".jpg") || str[i].endsWith(".png")) {
                return str[i];
            }
        }
        return "http://images.ua.prom.st/157205743_w0_h290_div_header.jpg";
    }
}
