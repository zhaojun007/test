package bayes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.google.common.base.Joiner;

public class TproduceTrainFile {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\test2\\X64-release-200\\keData\\trainData"
                + "\\200001");
        if(f.isDirectory()) {
            File[] listFiles = f.listFiles();
            String text[]=new String[listFiles.length];
            File file2 = new File("d:\\data\\train.txt");
            for (File file : listFiles) {
                FileOutputStream fileOutputStream = new FileOutputStream(file2,true);
               String readTxt = TReadFile.readTxt(file, "gbk");
                String replaceAll =Joiner.on(" ").join("200001",readTxt.substring(0, 100)).replaceAll("\\n", "");
                System.out.println(replaceAll);
                fileOutputStream.write(replaceAll.getBytes("gbk"));
                fileOutputStream.write("\r\n".getBytes("gbk"));
                System.out.println("写出成功！");
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
    }

}
