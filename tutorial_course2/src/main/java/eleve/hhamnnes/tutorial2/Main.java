package eleve.hhamnnes.tutorial2;

import eleve.hhamnnes.tutorial2.first_part.MergeSortRecursiveAlgorithm;



public class Main {
    public static void main(String[] args) {

        Integer[] list = {1,5,3,40, 2, 9};

        MergeSortRecursiveAlgorithm mergeSortRecursiveAlgorithm = new MergeSortRecursiveAlgorithm();

        list = mergeSortRecursiveAlgorithm.execute(list);

        for (int i = 0; i < list.length; i ++){
            System.out.println(list[i]);
        }
    }
}