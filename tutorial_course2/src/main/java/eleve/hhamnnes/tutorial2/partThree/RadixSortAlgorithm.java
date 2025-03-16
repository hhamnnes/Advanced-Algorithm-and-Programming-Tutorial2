package eleve.hhamnnes.tutorial2.partThree;

import eleve.hhamnnes.tutorial2.interfaces.IntListInIntListOutAlgorithm;

public class RadixSortAlgorithm implements IntListInIntListOutAlgorithm {

    @Override
    public Integer[] execute(Integer[] list) {
        return radixSort(list, 10); // Default to base 10
    }

    public Integer[] radixSort(Integer[] list, int radix) {
        if (list.length == 0) {
            return list;
        }

        // Find the maximum number to know the number of digits
        int maxNumber = findMax(list);

        // Perform counting sort for every digit
        for (int exp = 1; maxNumber / exp > 0; exp *= radix) {
            list = countingSortByDigit(list, exp, radix);
        }

        return list;
    }

    private int findMax(Integer[] list) {
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }

    private Integer[] countingSortByDigit(Integer[] list, int exp, int radix) {
        int n = list.length;
        Integer[] output = new Integer[n];
        int[] count = new int[radix];

        // Initialize count array with all zeros
        for (int i = 0; i < radix; i++) {
            count[i] = 0;
        }

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            int digit = (list[i] / exp) % radix;
            count[digit]++;
        }

        // Change count[i] so that count[i] contains the actual position of this digit in output[]
        for (int i = 1; i < radix; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (list[i] / exp) % radix;
            output[count[digit] - 1] = list[i];
            count[digit]--;
        }

        return output;
    }
}
