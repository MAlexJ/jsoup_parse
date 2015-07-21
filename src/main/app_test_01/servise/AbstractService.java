package servise;

import org.jsoup.nodes.Document;


public abstract class AbstractService {
    protected Document reqDoc;
    protected String str;

    public boolean isProduct(String str) {
        //selector is responsible for a product
        return (!reqDoc.select(".b-title_type_product").html().isEmpty());
    }

    public boolean isCatalog(String str) {
        //selector is responsible for a catalog
        return (!reqDoc.select(".b-product-groups_view_list").html().isEmpty());
    }

    public boolean isDesCatalog(String str) {
        //selector is responsible for a sub-selector
        return (reqDoc.select(".b-product-gallery").html().isEmpty() == false & reqDoc.select(".b-product-groups_view_list").html().isEmpty() == true) ? true : false;
    }
}
