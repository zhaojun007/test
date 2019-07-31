import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TReadFile {
    public static void main(String[] args) throws IOException {

        String readTxt = readTxt(
                new File("D:\\test2\\X64-release-200\\keData\\trainData\\200\\80464503CB33273BE053C805A8C0D581.txt"),
                "utf-8");
        System.out.println(readTxt);

    }

    public static String readTxt(File file, String charsetName) throws IOException {
        FileInputStream is = new FileInputStream(file);
        byte[] targetArray = new byte[is.available()];
        int len = 0;
        while (len != -1) {
            len = is.read(targetArray);
        }
        is.close();

        return new String(targetArray, charsetName);
    }
}