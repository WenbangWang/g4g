package algorithm.sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3};
        countingSort(array, 9);

        for(int i : array) {
            System.out.println(i);
        }
    }


    public static void countingSort(int[] array, int range) {
        int length = array.length;
        int[] output = new int[length];
        int[] count = new int[range + 1];

        for(int i : array) {
            count[i]++;
        }

        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for(int i : array) {
            output[count[i] - 1] = i;
            count[i]--;
        }

        System.arraycopy(output, 0, array, 0, length);
    }
}