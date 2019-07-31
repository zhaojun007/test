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
        List words = WordSegmenter.seg("xxx��syswareӦ�ü���Ʒ����ƽ̨������");
        @SuppressWarnings("rawtypes")
        List words1 = WordSegmenter.segWithStopWords("xxx��syswareӦ�ü���Ʒ����ƽ̨������");
        System.out.println(words);
        System.out.println(words1);

        List<Term> segment = HanLP.segment("xxx��syswareӦ�ü���Ʒ����ƽ̨������");
        System.out.println(segment);
        List<Term> seg2sentence = StandardTokenizer.segment("xxx��syswareӦ�ü���Ʒ����ƽ̨������");
        System.out.println(seg2sentence.toString());
        List<String> extractKeyword = HanLP.extractKeyword("xxx��syswareӦ�ü���Ʒ����ƽ̨������", 5);
        System.out.println(extractKeyword);
        List<String> keywordList = TextRankKeyword.getKeywordList("xxx��syswareӦ�ü���Ʒ����ƽ̨������", 5);
        System.out.println(keywordList);*/

        String[] s = { "����Ա", "Ӣ��", "����", "����", "ά��", "רҵ", "��Ա", "����Ա", "��Ϊ", "����", "���", "��Ա", "����", "����", "��Ա", "����",
                "�ر�", "�й�", "���", "��Ա", "��Ϊ", "����Ա", "�߼�", "����Ա", "ϵͳ", "����Ա", "��Ŀ", "����" };
        List<String> termList = Arrays.asList(s);
        int windowSize = 5;// ���ڴ�С
        Map<String, Float> map = getRank(termList, windowSize);
        for (Entry<String, Float> entry : map.entrySet()) {
            String key = entry.getKey();
            float value = entry.getValue();
            System.out.println(key + "=" + value);
        }

    }

    /**
     * ����TextRank�㷨�Ĺؼ�����ȡ�������ڵ��ĵ�
     */
    final static float d = 0.85f;// ����ϵ����һ��ȡֵΪ0.85
    final static int max_iter = 200;// ����������
    final static float min_diff = 0.001f;// ��С����ֵ���������̶�С�����ֵ��������

    /**
     * ʹ���Ѿ��ֺõĴ�������rank
     */
    public static Map<String, Float> getRank(List<String> termList, int windowSize) {
        List<String> wordList = new ArrayList<String>(termList.size());// ȥ��ͣ�ôʺ�Ĵ�����
        for (String str : termList) {
            wordList.add(str);
        }
        // System.out.println(wordList);
        Map<String, Set<String>> words = new LinkedHashMap<String, Set<String>>();// �ʺ�����Ӧ���ھ���
        Queue<String> que = new LinkedList<String>();// ��һ����������ʾ���ڵ��ƶ�
        for (String w : wordList) {
            if (!words.containsKey(w)) {
                words.put(w, new TreeSet<String>());
            }
            if (que.size() >= windowSize) {// ������г��ȴ��ڴ��ڴ�С�ˣ���Ѷ���ͷԪ���Ƴ�
                que.poll();
            }
            for (String qWord : que) {
                if (w.equals(qWord)) {
                    continue;
                }
                // ��Ȼ���ھ�,��ô��ϵ���໥��,����һ�鼴��
                words.get(w).add(qWord);
                words.get(qWord).add(w);
            }
            que.offer(w);// ��w��ӵ�����β��
        }
        // System.out.println(words);
        Map<String, Float> score = new LinkedHashMap<String, Float>();// ÿһ�ֵ�����ĴʺͶ�Ӧ��Ȩֵ
        for (int i = 0; i < max_iter; ++i) {
            Map<String, Float> m = new LinkedHashMap<String, Float>();// �˴ε����еĽ��
            float max_diff = 0;// �˴ε����б仯����Ȩֵ
            for (Map.Entry<String, Set<String>> entry : words.entrySet()) {
                String key = entry.getKey();
                Set<String> value = entry.getValue();
                m.put(key, 1 - d);
                for (String element : value) {
                    int size = words.get(element).size();
                    if (key.equals(element) || size == 0)
                        continue;
                    m.put(key, m.get(key) + d / size * (score.get(element) == null ? 0 : score.get(element)));
                    // ���չ�ʽ�����µ�Ȩֵ
                }
                max_diff = Math.max(max_diff, Math.abs(m.get(key) - (score.get(key) == null ? 0 : score.get(key))));
            }
            score = m;// ��һ�ֵĵ���������score��
            if (max_diff <= min_diff)
                break;// �仯����ȨֵС��min_diff����������
        }

        return score;
    }

}
