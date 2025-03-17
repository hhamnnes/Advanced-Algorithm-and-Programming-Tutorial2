package eleve.hhamnnes.tutorial2.partThree;

import eleve.hhamnnes.tutorial2.interfaces.IntListInIntListOutAlgorithm;
import java.util.ArrayList;

public class RadixSortAlgorithm implements IntListInIntListOutAlgorithm {
    private ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
    private int numberOfDigit;

    public RadixSortAlgorithm() {

        //Just to initializing all the buckets.
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<Integer>());
        }

    }

    @Override
    public Integer[] execute(Integer[] list) {

        //First step: Find the biggest number of digit in a number
        //within the list.
        numberOfDigit = 0;
        for (int i = 0; i < list.length; i++) {
            if (countDigits(list[i]) > numberOfDigit) {
                numberOfDigit = countDigits(list[i]);
            }
        }
        

        for (int z = 0; z < numberOfDigit; z++) {
            for (ArrayList<Integer> bucket : buckets) {
                bucket.clear();
            }

            for (int i = 0; i < list.length; i++) {
                int digit = getDigitAtPosition(list[i], z);
                buckets.get(digit).add(list[i]);
            }

            int index = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (int number : bucket) {
                    list[index++] = number;
                }
            }
        }

        return list;
    }

    //To find how many digit there are in for one number in the list.
    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        return (int) Math.log10(Math.abs(number)) + 1;
    }

    //To find at digit at a specific position.
    public static int getDigitAtPosition(int number, int position) {
        return (number / (int) Math.pow(10, position)) % 10;
    }
}
