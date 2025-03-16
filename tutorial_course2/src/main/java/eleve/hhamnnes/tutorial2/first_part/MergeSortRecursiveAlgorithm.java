package eleve.hhamnnes.tutorial2.first_part;

import java.util.Arrays;
import eleve.hhamnnes.tutorial2.interfaces.IntListInIntListOutAlgorithm;

public class MergeSortRecursiveAlgorithm implements IntListInIntListOutAlgorithm {

    @Override
    public Integer[] execute(Integer[] list) {
        if (list.length <= 1) {
            return list;
        }

        int middleIndex = list.length / 2;

        Integer[] listA = Arrays.copyOfRange(list, 0, middleIndex);
        Integer[] listB = Arrays.copyOfRange(list, middleIndex, list.length);

        listA = execute(listA);
        listB = execute(listB);

        return merge(listA, listB);
    }

    private Integer[] merge(Integer[] listA, Integer[] listB) {
        Integer[] mergedList = new Integer[listA.length + listB.length];
        int a = 0, b = 0, m = 0;

        while (a < listA.length && b < listB.length) {
            if (listA[a] <= listB[b]) {
                mergedList[m++] = listA[a++];
            } else {
                mergedList[m++] = listB[b++];
            }
        }

        while (a < listA.length) {
            mergedList[m++] = listA[a++];
        }

        while (b < listB.length) {
            mergedList[m++] = listB[b++];
        }

        return mergedList;
    }
}
