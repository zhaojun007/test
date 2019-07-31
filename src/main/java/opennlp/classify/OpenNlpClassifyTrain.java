package opennlp.classify;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class OpenNlpClassifyTrain {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
       InputStream fileInputStream = new FileInputStream("D:\\data\\train.txt");
       FileOutputStream fileOutputStream = new FileOutputStream("D:\\data\\category.model");
        ObjectStream<String> plainTextByLineStream = new PlainTextByLineStream(fileInputStream, "gbk");
        ObjectStream<DocumentSample> documentSampleStream = new DocumentSampleStream(plainTextByLineStream);
        DoccatModel train = DocumentCategorizerME.train("en", documentSampleStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        train.serialize(bufferedOutputStream);
    }
}
