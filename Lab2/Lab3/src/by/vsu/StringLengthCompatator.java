package by.vsu;

import java.util.Comparator;

public class StringLengthCompatator implements Comparator<String> {
    public static int count = 0;
    public int compare(String s1, String s2) {
        count++;
        if(s1.length() > s2.length()){
            return 1;
        }else{
            if(s1.length() < s2.length()){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
