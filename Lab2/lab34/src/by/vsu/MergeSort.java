package by.vsu;

import java.util.Comparator;

public class MergeSort implements ISortable {
    public <T> SortResult sort(T[] array, Comparator<T> comparator) {
        SortResult result = new SortResult();

        if (array.length > 1) {
            T[] left = (T[])leftHalf(array, result);
            T[] right = (T[])rightHalf(array, result);

            sort(left, comparator);
            sort(right, comparator);

            merge(array, left, right, comparator, result);
        }

        return result;
    }

    private static Object[] leftHalf(Object[] array, SortResult result) {
        int size1 = array.length / 2;
        Object[] left = new Object[size1];

        result.exchangesCount++;

        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }

        return left;
    }

    private static Object[] rightHalf(Object[] array, SortResult result) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        Object[] right = new Object[size2];

        result.exchangesCount++;

        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }

        return right;
    }

    private static <T> void merge(T[] array, T[] left, T[] right, Comparator<T> comparator, SortResult result) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < array.length; i++) {
            result.comparisonsCount++;

            if (i2 >= right.length || (i1 < left.length && comparator.compare(left[i1], right[i2]) < 0)) {
                array[i] = left[i1];
                i1++;
            } else {
                array[i] = right[i2];
                i2++;
            }
        }
    }
}
