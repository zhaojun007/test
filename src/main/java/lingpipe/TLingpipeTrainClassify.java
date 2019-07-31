package lingpipe;

import java.io.File;
import java.io.IOException;

import com.aliasi.classify.Classification;
import com.aliasi.classify.Classified;
import com.aliasi.classify.DynamicLMClassifier;
import com.aliasi.lm.NGramProcessLM;
import com.aliasi.util.AbstractExternalizable;
import com.aliasi.util.Files;

public class TLingpipeTrainClassify {
    public static void main(String[] args) throws IOException {
        String trainDirectory = "D:\\test2\\X64-release-002\\keData\\trainData";
        String categories[] = { "002001", "002002" };
        DynamicLMClassifier<NGramProcessLM> classifier = DynamicLMClassifier.createNGramProcess(categories, 6);
        for (int i = 0; i < categories.length; i++) {
            File classDir = new File(trainDirectory, categories[i]);
            String[] trainFiles = classDir.list();
            for (int j = 0; j < trainFiles.length; j++) {
                File file2 = new File(classDir, trainFiles[j]);
                String text = Files.readFromFile(file2, "ISO-8859-1");
                Classification classification = new Classification(categories[i]);
                Classified<CharSequence> classified = new Classified<>(text, classification);
                classifier.handle(classified);
            }
        }
        AbstractExternalizable.compileTo(classifier, new File("d:\\data\\lingpipeTrain.model"));
    }
}
