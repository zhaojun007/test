package bayes;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import com.google.common.base.Joiner;
import com.hankcs.hanlp.classification.classifiers.NaiveBayesClassifier;
import com.hankcs.hanlp.classification.models.NaiveBayesModel;

public class TLookTrianResult {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Map<String, String> map = new HashMap<String, String>();
        FileInputStream is = new FileInputStream("D:\\model.data");
        ObjectInputStream ois = new ObjectInputStream(is);
        NaiveBayesModel model = (NaiveBayesModel) ois.readObject();
        ois.close();
        NaiveBayesClassifier naiveBayesClassifier = new NaiveBayesClassifier(model);
         String url="D:\\test2\\X64-release-200\\keData\\testData";
        //String url = "D:\\test2\\X64-release-215\\keData\\testData";

        File file = new File(url);
        if (file.isDirectory()) {
            String[] fileList = file.list();
            int classifyTotal = 0;
            int correctTotal = 0;
            for (int i = 0; i < fileList.length; i++) {
                String trueClassify = fileList[i].substring(0, fileList[i].indexOf("_"));
                String trueClassifyNext = null;
                if (i + 1 < fileList.length) {
                    trueClassifyNext = fileList[i + 1].substring(0, fileList[i + 1].indexOf("_"));
                }
                String text = TReadFile.readTxt(new File(Joiner.on(File.separatorChar).join(url, fileList[i])),
                        "utf-8");
                String testClassify = naiveBayesClassifier.classify(text);
                classifyTotal++;
                if (i + 1 < fileList.length) {
                    if (trueClassify.equals(trueClassifyNext)) {
                        if (trueClassify.equals(testClassify)) {
                            correctTotal++;
                        }
                    } else {
                        String result = similarityResult((double) correctTotal / (double) classifyTotal);
                        correctTotal = 0;
                        classifyTotal = 0;
                        map.put(trueClassify, result);
                    }
                }else {
                    if (trueClassify.equals(testClassify)) {
                        correctTotal++;
                    }
                    String result = similarityResult((double) correctTotal / (double) classifyTotal);
                    map.put(trueClassify, result);
                }

            }
        }
        System.out.println(map);
    }

    private static String similarityResult(double result) {
        NumberFormat nf = NumberFormat.getPercentInstance(new Locale("en ", "US "));
        nf.setMinimumFractionDigits(2);
        return nf.format(result);
    }
}
