package algorithm.sort;

public class RadixSort {

    public static void main(String[] args) {
        int[] array = {23452345,678568758,12341234,5673456};

        radixSort(array, 10);

        for(int i : array) {
            System.out.println(i);
        }
    }

    public static void radixSort(int[] array, int range) {
        int max = getMax(array);

        for(int exp = 1; max / exp > 0; exp *= 10) {
            radixCountingSort(array, range, exp);
        }
    }

    static void radixCountingSort(int[] array, int range, int exp) {
        int length = array.length;
        int[] output = new int[length];
        int[] count = new int[range];

        for(int i : array) {
            count[(i / exp) % range]++;
        }

        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for(int i = length - 1; i >= 0; i--) {
            int num = array[i];
            int position = (num / exp) % range;

            output[count[position] - 1] = num;
            count[position]--;
        }

        System.arraycopy(output, 0, array, 0, length);
    }

    private static int getMax(int[] array) {
        int max = Integer.MIN_VALUE;

        for(int i : array) {
            max = Math.max(max, i);
        }

        return max;
    }
}