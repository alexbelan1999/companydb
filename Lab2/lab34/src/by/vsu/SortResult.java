package by.vsu;

public final class SortResult implements ISortResult {
    public int comparisonsCount;
    public int exchangesCount;

    public String toString() {
        return "Comparisons count: " + comparisonsCount + ", exchanges count: " + exchangesCount;
    }
}