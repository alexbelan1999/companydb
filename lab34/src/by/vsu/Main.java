package by.vsu;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Expected: substring, dictionary.");
            return;
        }

        Integer[] inputStringArray = {12, 56, 3, 4, 5, 9};
        String[] firstArray = args.clone();
        String[] secondArray = args.clone();
        Double[] thirdArray = {12.56, 56.3, 3.24, 3.31, 5.32};

            ISortable[] sorters = new ISortable[]{
                    new BubbleSort(),
                    new MergeSort()
            };
            for (ISortable sorter : sorters) {
                ISortResult result = sorter.sort(firstArray, new StringLengthCompatator());

                System.out.println(sorter.getClass().getSimpleName() + " - Length comparator - " + result);
                System.out.println(Arrays.toString(firstArray) + '\n');

                result = sorter.sort(secondArray, new StringContanceCompatator());

                System.out.println(sorter.getClass().getSimpleName() + " - Contance substring comparator - " + result);
                System.out.println(Arrays.toString(secondArray) + '\n');

                result = sorter.sort(inputStringArray, new IntCompatator());

                System.out.println(sorter.getClass().getSimpleName() + " - Integer comparator - " + result);
                System.out.println(Arrays.toString(inputStringArray) + '\n');

                result = sorter.sort(thirdArray, new DobleCompatator());

                System.out.println(sorter.getClass().getSimpleName() + " - Double comparator - " + result);
                System.out.println(Arrays.toString(thirdArray) + '\n');

            }
        }
    }


