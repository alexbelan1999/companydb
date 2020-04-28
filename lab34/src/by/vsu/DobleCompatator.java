package by.vsu;

import java.util.Comparator;

public class DobleCompatator implements Comparator<Double> {
    public int compare(Double a, Double b) {
        if(a > b){
            return 1;
        }else{
            if(a < b){
                return -1;
            }else{
                return 0;
            }
        }
    }
}

