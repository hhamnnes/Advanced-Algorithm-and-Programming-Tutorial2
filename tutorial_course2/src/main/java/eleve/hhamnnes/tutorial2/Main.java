package eleve.hhamnnes.tutorial2;

import eleve.hhamnnes.tutorial2.first_part.MergeSortRecursiveAlgorithm;
import eleve.hhamnnes.tutorial2.first_part.MergeSortIterativeAlgorithm;
import eleve.hhamnnes.tutorial2.partTwo.QuickSortRecursiveAlgorithm;
import eleve.hhamnnes.tutorial2.partThree.RadixSortAlgorithm;
import eleve.hhamnnes.tutorial2.tools.ETAIntListInIntListOut;
import eleve.hhamnnes.tutorial2.tools.JsonFileWriterExecutionTimeData;

public class Main {
    public static void main(String[] args) {
        
        int scopeStart = 100;
        int scopeEnd = 1000;
        int interval = 100;

        
        MergeSortRecursiveAlgorithm mergeSortRecursiveAlgorithm = new MergeSortRecursiveAlgorithm();
        MergeSortIterativeAlgorithm mergeSortIterativeAlgorithm = new MergeSortIterativeAlgorithm();
        QuickSortRecursiveAlgorithm quickSortRecursiveAlgorithm = new QuickSortRecursiveAlgorithm();
        RadixSortAlgorithm radixSortAlgorithm = new RadixSortAlgorithm();

        
        ETAIntListInIntListOut eta = new ETAIntListInIntListOut();

        
        Object[][] mergeSortRecursiveTimes = eta.measureExecutionTime(scopeStart, scopeEnd, interval, mergeSortRecursiveAlgorithm);
        Object[][] mergeSortIterativeTimes = eta.measureExecutionTime(scopeStart, scopeEnd, interval, mergeSortIterativeAlgorithm);
        Object[][] quickSortRecursiveTimes = eta.measureExecutionTime(scopeStart, scopeEnd, interval, quickSortRecursiveAlgorithm);
        Object[][] radixSortTimes = eta.measureExecutionTime(scopeStart, scopeEnd, interval, radixSortAlgorithm);

        
        JsonFileWriterExecutionTimeData.writeToFile(mergeSortRecursiveTimes,"mergeSortRecursiveTimes.json");
        JsonFileWriterExecutionTimeData.writeToFile(mergeSortIterativeTimes,"mergeSortIterativeTimes.json");
        JsonFileWriterExecutionTimeData.writeToFile(quickSortRecursiveTimes,"quickSortRecursiveTimes.json");
        JsonFileWriterExecutionTimeData.writeToFile(radixSortTimes,"radixSortTimes.json");
        


        System.out.println("Execution times have been written to JSON files.");
    }
}