package eleve.hhamnnes.tutorial2.first_part;

import eleve.hhamnnes.tutorial2.interfaces.IntListInIntListOutAlgorithm;

public class MergeSortIterativeAlgorithm implements IntListInIntListOutAlgorithm {

    @Override
    public Integer[] execute(Integer[] list) {
        if (list.length <= 1) {
            return list;
        }

        Integer[] temp = new Integer[list.length];

        for (int subListWidth = 1; subListWidth < list.length; subListWidth *= 2) {
            for (int i = 0; i < list.length; i += 2 * subListWidth) {

                int left = i;
                int middle = i + subListWidth;

                if (middle > list.length) {
                    middle = list.length;
                }

                int right = i + 2 * subListWidth;

                if (right > list.length) {
                    right = list.length;
                }
                
                merge(list, temp, left, middle, right);
            }
        }

        return list;
    }

    private void merge(Integer[] list, Integer[] temp, int left, int middle, int right) {
        int i = left;
        int j = middle;
        int k = left;

        while (i < middle && j < right) {
            if (list[i] <= list[j]) {
                temp[k++] = list[i++];
            } else {
                temp[k++] = list[j++];
            }
        }

        while (i < middle) {
            temp[k++] = list[i++];
        }

        while (j < right) {
            temp[k++] = list[j++];
        }

        for (i = left; i < right; i++) {
            list[i] = temp[i];
        }
    }
}
