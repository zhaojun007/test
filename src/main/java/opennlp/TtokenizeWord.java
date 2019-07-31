package opennlp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NERIDAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class TtokenizeWord {
    public static void main(String[] args) throws FileNotFoundException, IOException {
       // tokenizeWord();
        
        englishSegment();
    }

    /**
     * opennlp分词
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void tokenizeWord() throws FileNotFoundException, IOException {
        String paragraph = "Hi. How are you? This is JD_Dog. He is my good friends.He is very kind.but he is no more handsome than me. ";
        try (InputStream is = new FileInputStream(new File("D:\\openNlpModel\\en-token.bin"))) {
            TokenizerModel tokenizerModel = new TokenizerModel(is);
            TokenizerME tokenizerME = new TokenizerME(tokenizerModel);
            String[] tokenize = tokenizerME.tokenize(paragraph);
            for (String string : tokenize) {
                System.out.println(string);
            }
        }
    }
    public static void englishSegment() {
        String paragraph="she is a girl";
        Properties properties=new Properties();
        properties.put("annotators", "tokenize,ssplit,pos,lemma,ner");
        StanfordCoreNLP stanfordCoreNLP = new StanfordCoreNLP(properties);
        Annotation annotation=new Annotation(paragraph);
        stanfordCoreNLP.annotate(annotation);
        List<CoreMap> string = annotation.get(SentencesAnnotation.class);
        for (CoreMap coreMap : string) {
            for (CoreLabel coreLabel : coreMap.get(TokensAnnotation.class)) {
                String string2 = coreLabel.get(LemmaAnnotation.class);
                String string3 = coreLabel.get(NERIDAnnotation.class);
                System.out.println(string3);
                System.out.println(string2);
            }
        }
    }
}
