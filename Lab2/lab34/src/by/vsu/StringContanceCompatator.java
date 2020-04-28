package by.vsu;

import java.util.Comparator;

public class StringContanceCompatator implements Comparator<String>{
    public static int count1 = 0;
    private static String s= "à";
    public int compare(String s1, String s2) {
        count1++;

        if(s1.lastIndexOf(s) > s2.lastIndexOf(s)){
            return 1;
        }else{
            if(s1.lastIndexOf(s) < s2.lastIndexOf(s)){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
