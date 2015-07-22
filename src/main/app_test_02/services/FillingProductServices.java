package services;

import constants.Constants_01;
import entity.Product;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;


public class FillingProductServices extends AbstractServices implements Constants_01 {
    private List<Product> productList;

    public void init() {
        fillingDirectory(product);

        //sout product
        for (Product iter : product.getProductList()) {
            System.out.println(iter);
        }
    }


    private void fillingDirectory(Product currentProduct) {
        reqDoc = openConnection(TIMEOUT, currentProduct.getLink());
        if (isCatalog(reqDoc)) {
            productList = new ArrayList<>();
            parseContext(reqDoc.select(PRODUCT_groups_view_list).html());
            currentProduct.setProductList(productList);
        } else {
            return;
        }
        if (isDesCatalog(reqDoc)) {
            System.out.println(currentProduct);
            return;
        }
        if (isProduct(reqDoc)) {
            return;
        }
        if (!currentProduct.getProductList().isEmpty()) {
            for (Product iter : currentProduct.getProductList()) {
                fillingDirectory(iter);
            }
        }

    }

    public void parseContext(String str) {
        if (str == null) {
            throw new IllegalArgumentException(">>> parseContext(String str) -> str == null");
        }
        char[] chars = str.toCharArray();
        int targetEnd = str.indexOf("</li>");
        if (targetEnd >= 0) {
            Product currentProduct = new Product();
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
            currentProduct.setLink(WEBSITE + elements.attr("href"));
            /** Name catalog */
            elements = reqDoc.select("img");
            currentProduct.setName(elements.attr("alt"));
            /** Image catalog */
            currentProduct.setImage(searchImage(elements.attr("src"), elements.attr("longdesc")));
            /** Id catalog */
            currentProduct.generationID();
            productList.add(currentProduct);
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
