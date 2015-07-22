package services;

import constants.Constants_01;
import entity.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.UnknownHostException;

public abstract class AbstractServices implements Constants_01 {
    protected Document reqDoc;
    protected Elements elements;
    protected static Product product;

    static {
        product = new Product();
        product.setLink(PRODUCT_CATALOG);
        product.setName(WEBSITE);
        product.generationID();
    }

    protected boolean isProduct(Document doc) {
        //selector is responsible for a product
        return (!doc.select(PRODUCT_title_type_product).html().isEmpty());
    }

    protected boolean isCatalog(Document doc) {
        //selector is responsible for a catalog
        return (!doc.select(PRODUCT_groups_view_list).html().isEmpty());
    }

    protected boolean isDesCatalog(Document doc) {
        //selector is responsible for a sub-selector
        return (doc.select(PRODUCT_gallery).html().isEmpty() == false & doc.select(PRODUCT_groups_view_list).html().isEmpty() == true) ? true : false;
    }

    protected Document openConnection(int timeout, String str) {
        try {
            reqDoc = Jsoup.connect(str).timeout(timeout).get();
        } catch (UnknownHostException e) {
            /** UnknownHostException -> No internet connection. */
            System.out.println("No internet connection");
            System.exit(0);
        } catch (IOException e) {
            /** SocketTimeException -> replay connection. */
            if (timeout < 5000) openConnection(timeout * 10, str);
            else throw new IllegalArgumentException(">> IllegalArgumentException -> Error connecting to the Internet");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return reqDoc;
    }

}
