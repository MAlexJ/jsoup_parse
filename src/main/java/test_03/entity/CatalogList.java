package test_03.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CatalogList implements Serializable {

    private List<Catalog> catalogList = new ArrayList<Catalog>();

    public CatalogList() {
    }

    public boolean addCatalog(Catalog catalog) {
        return catalogList.add(catalog);
    }

    public List<Catalog> getCatalogList() {
        return catalogList;
    }

    public void printCatalog() {
        for (Catalog iter : catalogList) {
            System.out.println();
            System.out.println("***************************");
            System.out.println(iter);
            System.out.println("***************************");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "CatalogList -> " + catalogList;
    }
}
