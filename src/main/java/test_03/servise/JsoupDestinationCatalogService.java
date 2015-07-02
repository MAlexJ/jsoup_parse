package test_03.servise;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import test_03.constants.Constants;
import test_03.entity.Product;
import test_03.entity.ProductList;


import java.io.IOException;
import java.net.UnknownHostException;

public class JsoupDestinationCatalogService extends AbstractServise implements Constants {
    private Document reqDoc;
    private Elements elements;
    private String str;

    public void init(int timeOut, String strPath) {
        try {
            reqDoc = Jsoup.connect(strPath).timeout(timeOut).get();
            str = reqDoc.select(PRODUCT_CATALOG_SELECTOR_CSS_GALLERY).html();
            parseContext(str);
            getProductList().printProduct();
        } catch (UnknownHostException e) {
            /** UnknownHostException -> No internet connection. */
            System.out.println("No internet connection");
            System.exit(0);
        } catch (IOException e) {
            /** SocketTimeException -> replay connection. */
            if (timeOut < 5000) init(timeOut * 40, strPath);
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
            Product product = new Product();

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
            product.setLink(elements.attr("href"));
            /** Name catalog */
            elements = reqDoc.select("img");
            product.setTitle(elements.attr("alt"));
            /** Image catalog */
            product.setImage(searchImage(elements.attr("src"), elements.attr("longdesc"), elements.attr("content")));
            /** Name price */
            elements = reqDoc.select(PRODUCT_CATALOG_SELECTOR_CSS_GALLERY_CURRENT_PRICE);
            String textPrice = elements.text();
            try {
                product.setPrice(Float.valueOf(textPrice.replace(" грн.", "")));
            } catch (NumberFormatException e) {
                System.out.println("Float.valueOf(textPrice.replace(\" грн.\",\"\"))");
                throw e;
            }
            /** Name state */
            elements = reqDoc.select(PRODUCT_CATALOG_SELECTOR_CSS_GALLERY_STATE);
            product.setStok(elements.text());
            /** Id catalog */
            product.generationID();
            getProductList().addProductList(product);
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
