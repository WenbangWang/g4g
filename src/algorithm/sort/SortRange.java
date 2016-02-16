package algorithm.sort;

/**
 * Sort n numbers in range from 0 to n^2 – 1 in linear time
 */
public class SortRange {

    public static void main(String[] args) {
        int[] array = {9,4,7,24,6};

        RadixSort.radixCountingSort(array, array.length, 1);
        RadixSort.radixCountingSort(array, array.length, array.length);

        for(int i : array) {
            System.out.println(i);
        }
    }
}