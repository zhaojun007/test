package opennlp.classify;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.util.InvalidFormatException;

public class OpenNlpTestCategory {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws InvalidFormatException, IOException {
        String testYL="第3期船舶转向过程中速度下降问题的研究大连海事大学 李宗波 张显库 贾 云内容提要:随着大型船舶的数";
        FileInputStream fileInputStream = new FileInputStream(new File("d:\\data\\category.model"));
        DoccatModel doccatModel = new DoccatModel(fileInputStream);
        DocumentCategorizerME documentCategorizerME = new DocumentCategorizerME(doccatModel);
        double[] categorize = documentCategorizerME.categorize(testYL);
        for (int i=0;i< documentCategorizerME.getNumberOfCategories() ;i++) {
            String category = documentCategorizerME.getCategory(i);
            System.out.println(category+"-->"+categorize[i]);
        }
    }
}
