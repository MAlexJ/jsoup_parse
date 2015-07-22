package servise;

import org.jsoup.nodes.Document;


public abstract class AbstractService {
    protected Document reqDoc;
    protected String str;

    public boolean isProduct(Document str) {
        //selector is responsible for a product
        return (!str.select(".b-title_type_product").html().isEmpty());
    }

    public boolean isCatalog(Document str) {
        //selector is responsible for a catalog
        return (!str.select(".b-product-groups_view_list").html().isEmpty());
    }

    public boolean isDesCatalog(Document str) {
        //selector is responsible for a sub-selector
        return (str.select(".b-product-gallery").html().isEmpty() == false & reqDoc.select(".b-product-groups_view_list").html().isEmpty() == true) ? true : false;
    }
}
