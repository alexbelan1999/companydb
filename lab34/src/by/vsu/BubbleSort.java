package by.vsu;

import java.util.Comparator;


public class BubbleSort implements ISortable {

    public <T> SortResult sort(T[] array,Comparator<T> comparator){

        SortResult result = new SortResult();
            for(int i=0;i<array.length;i++){
                for(int j=1;j<array.length-i;j++){
                    result.comparisonsCount++;
                if(comparator.compare(array[j-1],array[j])<0){

                    result.exchangesCount++;
                    T t=array[j-1];
                    array[j-1]=array[j];
                    array[j]=t;

                }
            }

        }
        return result;
    }
}

