
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Parcer {
    public static void parcing(String url,String path) {
        try {
            Document doc = Jsoup.connect(url).timeout(5000).get();
            List<Element> elms = doc.select("[class=col-xs-4 isLayout3]");
            List<Element> elms1 = null;
            for (int i = 0; i < elms.size(); i++) {
                elms1 = doc.select("[class=product-name-link]");
                String res = elms1.get(i).toString();
                String resultBrand = res.substring(res.indexOf("/p/") + 3, res.indexOf("/", res.indexOf("/p/") + 3));
                String resultProductName = res.substring(res.indexOf(">") + 1, res.lastIndexOf("<"));
                String ProductName = resultProductName;
                String Brand = resultBrand.toUpperCase();
                String HTMLString =
                        " <offer>" + "\r\n" +
                                "  <name>" +
                                ProductName +
                                "</name>" + "\r\n" +
                                "  <brand>" +
                                Brand +
                                "</brand>" + "\r\n" +
                                " </offer>" + "\r\n";
                try {
                    FileWriter writer = new FileWriter(path, true);
                    BufferedWriter bufferWriter = new BufferedWriter(writer);
                    bufferWriter.write(HTMLString);
                    bufferWriter.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
