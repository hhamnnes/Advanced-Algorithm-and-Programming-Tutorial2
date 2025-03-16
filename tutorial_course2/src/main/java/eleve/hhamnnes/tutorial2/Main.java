package eleve.hhamnnes.tutorial2;

import eleve.hhamnnes.tutorial2.first_part.MergeSortRecursiveAlgorithm;
import eleve.hhamnnes.tutorial2.first_part.MergeSortIterativeAlgorithm;
import eleve.hhamnnes.tutorial2.partTwo.QuickSortRecursiveAlgorithm;

public class Main {
    public static void main(String[] args) {

        Integer[] list = {6, 5, 3, 1, 8, 7, 2, 4};

        MergeSortRecursiveAlgorithm mergeSortRecursiveAlgorithm = new MergeSortRecursiveAlgorithm();

        list = mergeSortRecursiveAlgorithm.execute(list);

        System.out.println("Recursive Merge Sort:");

        for (int i = 0; i < list.length; i ++){
            System.out.println(list[i]);
        }

        Integer[] list2 = {6, 5, 3, 1, 8, 7, 2, 4};

        MergeSortIterativeAlgorithm mergeSortIterativeAlgorithm = new MergeSortIterativeAlgorithm();

        list2 = mergeSortIterativeAlgorithm.execute(list2);

        System.out.println("Iterative Merge Sort:");

        for (int i = 0; i < list.length; i ++){
            System.out.println(list2[i]);
        }

        Integer[] list3 = {5, 2, 1, 8, 4,7, 6, 3};

        QuickSortRecursiveAlgorithm quickSortRecursiveAlgorithm = new QuickSortRecursiveAlgorithm();

        list3 = quickSortRecursiveAlgorithm.execute(list3);

        System.out.println("Recursive Quick Sort:");

        for (int i = 0; i < list.length; i ++){
            System.out.println(list3[i]);
        }



    }
}