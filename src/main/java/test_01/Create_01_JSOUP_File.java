package test_01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Alex on 14.06.2015.
 */
public class Create_01_JSOUP_File {

    public static void main(String[] args) throws IOException {
        File file = new File("index.html");
        // file.createNewFile();
        FileWriter writeFile = null;
        try {
            writeFile = new FileWriter(file);
            writeFile.write(donloadHTML());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writeFile != null) {
                try {
                    writeFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Document doc = Jsoup.parse(file, "UTF-8", "http://ya.ru/");
        System.out.println(doc);
    }

    public static String donloadHTML() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://ya.ru/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (doc == null) {
            String html = "<html><head><title>First parse</title></head><body><p>Hello, world!</p></body></html>";
            return html;
        }
        return doc.toString();
    }
}
