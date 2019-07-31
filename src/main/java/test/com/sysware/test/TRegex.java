package test.com.sysware.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TRegex {
    public static void main(String[] args) {
        /*
         * String numberToLetter = numberToLetter(1);
         * System.out.println(numberToLetter);
         */
        /*
         * NumberFormat nf = NumberFormat.getPercentInstance(new Locale("en ", "US "));
         * nf.setMinimumFractionDigits(2); System.out.println((double)29 /(double) 47);
         * String format = nf.format(29 / 47); System.out.println(format);
         */
        /*
         * Random random=new Random(); System.out.println(random.nextInt(10));
         */
        String word = "粘接剂导电塑料电位器\r\n";
        word=word.replaceAll("\r\n", "");
        String regex = "^[a-zA-Z0-9\u4E00-\u9FA5]+$";
        String regexNum = "[0-9]*";
        if (checked(regex, word.replaceAll(" ", "")) == false
                || checked(regexNum, word.replaceAll(" ", "").charAt(0) + "") == true || word.length() > 20) {
            System.out.println(1);
        }
    }

    public static boolean checked(String reg, String word) {
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(word);
        return matcher.matches();
    }

    private static String numberToLetter(int num) {
        String letter = "";
        num--;
        do {
            if (letter.length() > 0) {
                num--;
            }
            letter = ((char) (num % 26 + (int) 'A')) + letter;
            num = (int) ((num - num % 26) / 26);
        } while (num > 0);

        return letter;
    }

}
