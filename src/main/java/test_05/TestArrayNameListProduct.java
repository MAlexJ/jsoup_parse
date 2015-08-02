package test_05;


import java.util.ArrayList;
import java.util.List;

public class TestArrayNameListProduct {

    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product("Электронные сигареты", 1));
        productList.add(new Product("Электронные кальяны", 2));
        productList.add(new Product("Атомайзеры", 3));
        productList.add(new Product("Аккумуляторы для электронных сигарет", 4));
        productList.add(new Product("Комплектующие", 5));
        productList.add(new Product("Жидкости для электронных сигарет и кальянов", 6));
    }

    public static void main(String[] args) {

        String[] arrayName = new String[productList.size()];
        for (int i = 0; i < arrayName.length; i++) {
            arrayName[i] = productList.get(i).getName();
        }

        for (int i = 0; i < arrayName.length; i++) {
            System.out.println(arrayName[i]);
        }
        System.out.println("************");
        for (Product iter : productList)
            System.out.println(iter);

    }
}
