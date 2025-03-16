package eleve.hhamnnes.tutorial2;

import eleve.hhamnnes.tutorial2.first_part.MergeSortRecursiveAlgorithm;
import eleve.hhamnnes.tutorial2.first_part.MergeSortIterativeAlgorithm;


public class Main {
    public static void main(String[] args) {

        Integer[] list = {6, 5, 3, 1, 8, 7, 2, 4};

        MergeSortRecursiveAlgorithm mergeSortRecursiveAlgorithm = new MergeSortRecursiveAlgorithm();

        list = mergeSortRecursiveAlgorithm.execute(list);

        for (int i = 0; i < list.length; i ++){
            System.out.println(list[i]);
        }

        Integer[] list2 = {6, 5, 3, 1, 8, 7, 2, 4};

        MergeSortIterativeAlgorithm mergeSortIterativeAlgorithm = new MergeSortIterativeAlgorithm();

        list2 = mergeSortIterativeAlgorithm.execute(list2);

        for (int i = 0; i < list.length; i ++){
            System.out.println(list2[i]);
        }

    }
}