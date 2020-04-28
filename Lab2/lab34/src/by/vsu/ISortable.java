package by.vsu;

import java.util.Comparator;

public interface ISortable {
    public <T> ISortResult  sort(T[] array, Comparator<T> comparator);
}