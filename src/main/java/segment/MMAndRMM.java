package segment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;

public class MMAndRMM {
    static HashSet<String> dictSet=new HashSet<String>();
    public static void main(String[] args) {
        // 自定义一个词典
        String dictList = "北京,北京奥运会,奥体中心,奥林匹克,森林,公园,开幕";
        HashSet<String> dictionary = MMAndRMM.loadDictionary();
        // 输入子串
        String inputString = "北京奥运会在奥林匹克森林公园正式开幕";
        // 词典最大子串长度
        int max_length = 5;
        List<String> mm = MM.mm(dictionary, inputString, max_length);
        List<String> rmm = RMM.rmm(dictList, inputString, max_length);
        List<String> bestResult = getBestResult(mm, rmm);
        System.out.println(bestResult);
        loadDictionary();
    }

    public static List<String> getBestResult(List<String> mm, List<String> rmm) {
        if (mm.size() != rmm.size()) {
            if (mm.size() < rmm.size()) {
                return mm;
            } else {
                return rmm;
            }
        } else {
            boolean isEqual = true;
            int mmSingleWordCount = 0;
            int rmmSingleWordCount = 0;
            for (int i = 0; i < mm.size(); i++) {
                if (!mm.get(i).equals(rmm.get(i))) {
                    isEqual = false;
                }
                if (mm.get(i).length() == 1) {
                    mmSingleWordCount++;
                }
                if (rmm.get(i).length() == 1) {
                    rmmSingleWordCount++;
                }
            }
            if (isEqual) {
                return rmm;
            } else {
                if (mmSingleWordCount > rmmSingleWordCount) {
                    return rmm;
                } else {
                    return mm;
                }
            }
        }
    }
    public static HashSet<String> loadDictionary() {
        String filePath="\\dictionary.txt";
        String line=null;
        try(BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)),"gbk"))){
            while((line=bufferedReader.readLine())!=null) {
                line=line.split("\\s+")[1];
                dictSet.add(line);  
            } 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(dictSet.size());
        return dictSet;
    }
}
