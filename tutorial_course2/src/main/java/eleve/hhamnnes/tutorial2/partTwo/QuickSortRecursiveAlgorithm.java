package eleve.hhamnnes.tutorial2.partTwo;

import java.util.ArrayList;
import java.util.List;

import eleve.hhamnnes.tutorial2.interfaces.IntListInIntListOutAlgorithm;

public class QuickSortRecursiveAlgorithm implements IntListInIntListOutAlgorithm {

    @Override
    public Integer[] execute(Integer[] list) {
        if (list.length <= 1) {
            return list;
        }

        int middleIndex = list.length / 2;
        int pivot = list[middleIndex];

        List<Integer> high = new ArrayList<>();
        List<Integer> low = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if (i == middleIndex) continue;
            if (list[i] > pivot) {
                high.add(list[i]);
            } else {
                low.add(list[i]);
            }
        }

        Integer[] finalHigh = execute(high.toArray(new Integer[0]));
        Integer[] finalLow = execute(low.toArray(new Integer[0]));

        return concatenate(finalLow, pivot, finalHigh);
    }

    private Integer[] concatenate(Integer[] low, int pivot, Integer[] high) {
        Integer[] result = new Integer[low.length + 1 + high.length];
        System.arraycopy(low, 0, result, 0, low.length);
        result[low.length] = pivot;
        System.arraycopy(high, 0, result, low.length + 1, high.length);
        return result;
    }
}
