package test.com.sysware.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import org.apdplat.word.WordSegmenter;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.summary.TextRankKeyword;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

public class TextRank {
    public static void main(String[] args) {

      /*  @SuppressWarnings("rawtypes")
        List words = WordSegmenter.seg("xxx是sysware应用级产品开发平台的作者");
        @SuppressWarnings("rawtypes")
        List words1 = WordSegmenter.segWithStopWords("xxx是sysware应用级产品开发平台的作者");
        System.out.println(words);
        System.out.println(words1);

        List<Term> segment = HanLP.segment("xxx是sysware应用级产品开发平台的作者");
        System.out.println(segment);
        List<Term> seg2sentence = StandardTokenizer.segment("xxx是sysware应用级产品开发平台的作者");
        System.out.println(seg2sentence.toString());
        List<String> extractKeyword = HanLP.extractKeyword("xxx是sysware应用级产品开发平台的作者", 5);
        System.out.println(extractKeyword);
        List<String> keywordList = TextRankKeyword.getKeywordList("xxx是sysware应用级产品开发平台的作者", 5);
        System.out.println(keywordList);*/

        String[] s = { "程序员", "英文", "程序", "开发", "维护", "专业", "人员", "程序员", "分为", "程序", "设计", "人员", "程序", "编码", "人员", "界限",
                "特别", "中国", "软件", "人员", "分为", "程序员", "高级", "程序员", "系统", "分析员", "项目", "经理" };
        List<String> termList = Arrays.asList(s);
        int windowSize = 5;// 窗口大小
        Map<String, Float> map = getRank(termList, windowSize);
        for (Entry<String, Float> entry : map.entrySet()) {
            String key = entry.getKey();
            float value = entry.getValue();
            System.out.println(key + "=" + value);
        }

    }

    /**
     * 基于TextRank算法的关键字提取，适用于单文档
     */
    final static float d = 0.85f;// 阻尼系数，一般取值为0.85
    final static int max_iter = 200;// 最大迭代次数
    final static float min_diff = 0.001f;// 最小区别值，当收敛程度小于这个值结束迭代

    /**
     * 使用已经分好的词来计算rank
     */
    public static Map<String, Float> getRank(List<String> termList, int windowSize) {
        List<String> wordList = new ArrayList<String>(termList.size());// 去掉停用词后的词序列
        for (String str : termList) {
            wordList.add(str);
        }
        // System.out.println(wordList);
        Map<String, Set<String>> words = new LinkedHashMap<String, Set<String>>();// 词和它对应的邻居们
        Queue<String> que = new LinkedList<String>();// 用一个队列来表示窗口的移动
        for (String w : wordList) {
            if (!words.containsKey(w)) {
                words.put(w, new TreeSet<String>());
            }
            if (que.size() >= windowSize) {// 如果队列长度大于窗口大小了，则把队列头元素移除
                que.poll();
            }
            for (String qWord : que) {
                if (w.equals(qWord)) {
                    continue;
                }
                // 既然是邻居,那么关系是相互的,遍历一遍即可
                words.get(w).add(qWord);
                words.get(qWord).add(w);
            }
            que.offer(w);// 将w添加到队列尾部
        }
        // System.out.println(words);
        Map<String, Float> score = new LinkedHashMap<String, Float>();// 每一轮迭代后的词和对应的权值
        for (int i = 0; i < max_iter; ++i) {
            Map<String, Float> m = new LinkedHashMap<String, Float>();// 此次迭代中的结果
            float max_diff = 0;// 此次迭代中变化最大的权值
            for (Map.Entry<String, Set<String>> entry : words.entrySet()) {
                String key = entry.getKey();
                Set<String> value = entry.getValue();
                m.put(key, 1 - d);
                for (String element : value) {
                    int size = words.get(element).size();
                    if (key.equals(element) || size == 0)
                        continue;
                    m.put(key, m.get(key) + d / size * (score.get(element) == null ? 0 : score.get(element)));
                    // 按照公式计算新的权值
                }
                max_diff = Math.max(max_diff, Math.abs(m.get(key) - (score.get(key) == null ? 0 : score.get(key))));
            }
            score = m;// 新一轮的迭代结果存进score中
            if (max_diff <= min_diff)
                break;// 变化最大的权值小于min_diff，结束迭代
        }

        return score;
    }

}
