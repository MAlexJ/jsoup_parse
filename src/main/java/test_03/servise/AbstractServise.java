package test_03.servise;

import test_03.entity.CatalogList;
import test_03.entity.ProductList;

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
