package test_02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class Selector_2 {

    static int i =0;
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://to-chto-nado.prom.ua/").timeout(10000).get();

            String str = doc.select("ul.b-product-groups.b-product-groups_view_gallery").html();

            parceContext(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void parceContext(String str) {

        System.out.println(++i);
        char[] strArray = str.toCharArray();

        // 1
        int linFirst = str.indexOf("b-product-groups__item");
        if (linFirst < 0) return;
        linFirst += 5;
        char[] firstArray = new char[strArray.length - linFirst];
        System.arraycopy(strArray, linFirst, firstArray, 0, firstArray.length);
        String firstStr = new String(firstArray);

        // 2
        int linSecond = firstStr.indexOf("b-product-groups__item");

       //********** exit frame ***********
        if (linSecond < 0) return;
        //3
        int linTree = linFirst + linSecond;
        linTree -= 30;
        char[] treeArray = new char[linTree];
        System.arraycopy(strArray, 0, treeArray, 0, linTree);
        String result = new String(treeArray);
        System.out.println();
        System.out.println("*****************************************************");
        System.out.println();
        System.out.println(result);
        System.out.println("*****************************************************");


        // 4
       char[] fourArray = new char[strArray.length-treeArray.length];

        System.arraycopy(strArray,treeArray.length,fourArray,0,fourArray.length);
String s = new String(fourArray);

    parceContext(s);


    }


}
