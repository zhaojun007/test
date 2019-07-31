package opennlp.sentiment;

import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
/**
 * 情感分析 支持英文
 * TODO
 * 
 * @author zhaojun
 * 2019年7月25日 下午4:16:42
 *
 */
public class TSentiment {
    public static void main(String[] args) {
        String reviewText = "我觉得这部片子很垃圾";
       // String reviewText=" i think this movie is terrible";
        Properties props = new Properties();  
        props.put("annotators", "tokenize,ssplit,parse,sentiment");
        String sentimentText[] = { "非常乐观", "乐观",  "一般","消极", "非常消极" };
        StanfordCoreNLP coreNLP = new StanfordCoreNLP(props);
        Annotation annotation = new Annotation(reviewText);
        coreNLP.annotate(annotation);
        List<CoreMap> list = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap coreMap : list) {
            Tree tree = coreMap.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            int predictedClass = RNNCoreAnnotations.getPredictedClass(tree);
            System.out.println(sentimentText[predictedClass]);
        }

    }
}
