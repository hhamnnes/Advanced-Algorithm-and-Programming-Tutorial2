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

        //According to gitHub-copilot i had to use list.toArray
        //with new Integer[0]
        Integer[] finalHigh = execute(high.toArray(new Integer[0]));
        Integer[] finalLow = execute(low.toArray(new Integer[0]));

        return concatenate(finalLow, pivot, finalHigh);
    }

    private Integer[] concatenate(Integer[] low, int pivot, Integer[] high) {
        
        int listSize = low.length + 1 + high.length;
        int resultIndex = 0;
        
        Integer[] result = new Integer[listSize];

        for(int i = 0; i < low.length; i++) {
            result[resultIndex++] = low[i];
        }

        result[resultIndex++] = pivot;

        for(int i = 0; i < high.length; i++) {
            result[resultIndex++] = high[i];
        }

        return result;
    }
}
