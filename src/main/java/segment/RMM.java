package segment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class RMM {
    public static void main(String[] args) {
        // 自定义一个词典
        // String dictList="北京,北京奥运会,奥体中心,奥林匹克,森林,公园,开幕";
        HashSet<String> dictionary = MMAndRMM.loadDictionary();
        // 输入子串
        String inputString = "2008奥运会在北京奥林匹克森林公园正式开幕";
        // 词典最大子串长度
        int max_length = 5;
        List<String> mm = rmm(dictionary, inputString, max_length);
        System.out.println(mm);
    }

    public static List<String> rmm(HashSet<String> dictList, String inputString, int maxLength) {
        Stack<String> stack = new Stack<String>();
        List<String> resultList = new ArrayList<>();
        String subInputString;
        while (inputString.length() > 0) {
            if (inputString.length() < maxLength) {
                subInputString = inputString;
            } else {
                subInputString = inputString.substring(inputString.length() - maxLength);
            }
            while (subInputString.length() > 0) {
                if (dictList.contains(subInputString) || subInputString.length() == 1) {
                    stack.add(subInputString);
                    inputString = inputString.substring(0, inputString.length() - subInputString.length());
                    break;
                } else {
                    subInputString = subInputString.substring(1);
                }
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            resultList.add(stack.pop());
        }
        return resultList;
    }
}
