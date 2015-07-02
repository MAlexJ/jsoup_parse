package test_03.servise;

import test_03.entity.CatalogList;

/**
 * Created by root on 02.07.15.
 */
public abstract class AbstractServise {
    private CatalogList catalogList = new CatalogList();

    protected CatalogList getCatalogList() {
        return catalogList;
    }




}
