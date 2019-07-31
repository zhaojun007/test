package bayes;
import java.util.HashMap;
import java.util.Map;

public class Model {
    /**
     * 先验概率的对数值 log( P(c) )
     */
    public Map<Integer, Double> logPriors = new HashMap<Integer, Double>();

    /**
     * 似然对数值 log( P(x|c) )
     */
    public Map<Integer, Map<Integer, Double>> logLikelihoods = new HashMap<Integer, Map<Integer, Double>>();

    /**
     * 训练样本数r
     */
    public int n = 0;
    public Map<Integer, Double> getLogPriors() {
        return logPriors;
    }
    public void setLogPriors(Map<Integer, Double> logPriors) {
        this.logPriors = logPriors;
    }
    public Map<Integer, Map<Integer, Double>> getLogLikelihoods() {
        return logLikelihoods;
    }
    public void setLogLikelihoods(Map<Integer, Map<Integer, Double>> logLikelihoods) {
        this.logLikelihoods = logLikelihoods;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }
    public int getD() {
        return d;
    }
    public void setD(int d) {
        this.d = d;
    }
    /**
     * 类别数
     */
    public int c = 0;
    /**
     * 特征数
     */
    public int d = 0;
}
