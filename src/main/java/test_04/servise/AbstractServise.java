package test_04.servise;

import test_04.entity.CatalogList;
import test_04.entity.ProductList;

/**
 * Created by root on 02.07.15.
 */
public abstract class AbstractServise {
    private CatalogList catalogList = new CatalogList();
    private ProductList productList = new ProductList();

    protected CatalogList getCatalogList() {
        return catalogList;
    }


    public ProductList getProductList() {
        return productList;
    }
}
