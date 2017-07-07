
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class MakeFile {


    public static void beginFile(String path) {
        try {
            FileWriter writer = new FileWriter(path, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\r\n" +
                    "<offers>" + "\r\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public static void finishFile(String path) {
        try {
            FileWriter writer = new FileWriter(path, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("</offers>" + "\r\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
