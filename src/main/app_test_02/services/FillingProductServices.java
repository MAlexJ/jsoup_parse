package services;

import constants.Constants_01;
import entity.Product;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;


public class FillingProductServices extends AbstractServices implements Constants_01 {
    private List<Product> productList;
    private Product currentProduct;

    public void init() {
        fillingCatalog(product);
    }


    private void fillingCatalog(Product currentProduct) {
        reqDoc = openConnection(TIMEOUT, currentProduct.getLink());
        if (reqDoc == null) {
            System.out.println("Фиговый коннект");
            return;
        }
        if (isCatalog(reqDoc)) {
            this.productList = new ArrayList<>();
            parseContextDirectory(reqDoc.select(PRODUCT_groups_view_list).html());
            currentProduct.setProductList(this.productList);
        }
        if (isDesCatalog(reqDoc)) {
            return;
        }
        if (isProduct(reqDoc)) {
            return;
        }
        if (!currentProduct.getProductList().isEmpty()) {
            for (Product iter : currentProduct.getProductList()) {
                fillingCatalog(iter);
            }
        }

    }

    private void fillingDesCatalog(Product currentProduct) {

    }

    private void fillingProduct(Product currentProduct) {

    }

    private void parseContextDirectory(String str) {
        if (str == null) {
            throw new IllegalArgumentException(">>> parseContext(String str) -> str == null");
        }
        char[] chars = str.toCharArray();
        int targetEnd = str.indexOf("</li>");
        if (targetEnd >= 0) {
            this.currentProduct = new Product();
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
            this.currentProduct.setLink(WEBSITE + elements.attr("href"));
            /** Name catalog */
            elements = reqDoc.select("img");
            this.currentProduct.setName(elements.attr("alt"));
            /** Image catalog */
            this.currentProduct.setImage(searchImageDirectory(elements.attr("src"), elements.attr("longdesc")));
            /** Id catalog */
            this.currentProduct.generationID();
            this.productList.add(this.currentProduct);
            parseContextDirectory(resultString);
        } else {
            return;
        }
    }

    private String searchImageDirectory(String... str) {
        for (int i = 0; i < str.length; i++) {
            if (str[i].endsWith(".jpeg") || str[i].endsWith(".jpg") || str[i].endsWith(".png")) {
                return str[i];
            }
        }
        return "http://images.ua.prom.st/157205743_w0_h290_div_header.jpg";
    }

}
