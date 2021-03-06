package segment;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class MM {
    public static void main(String[] args) {
        //自定义一个词典
        //String dictList="北京,北京奥运会,奥体中心,奥林匹克,森林,公园,开幕";
        HashSet<String> dictionary = MMAndRMM.loadDictionary();
        //输入子串
        String inputString="2008奥运会在北京奥林匹克森林公园正式开幕";
        //词典最大子串长度
        int max_length=5;
        List<String> mm = mm(dictionary, inputString, max_length);
        System.out.println(mm);
    }
    public static List<String> mm(HashSet<String> dictList,String inputString,int maxLength){
        List<String> resultList=new ArrayList<>();
        String subInputString;
        while(inputString.length()>0) {
            if(inputString.length()<maxLength) {
                subInputString=inputString;
            }else {
                subInputString=inputString.substring(0,maxLength);
            }
            while(subInputString.length()>0) {
                if(dictList.contains(subInputString)||subInputString.length()==1) {
                    resultList.add(subInputString);
                    inputString=inputString.substring(subInputString.length());
                    break;
                }else {
                    subInputString=subInputString.substring(0, subInputString.length()-1);
                }
            }
        }
        return resultList;
    }
}
