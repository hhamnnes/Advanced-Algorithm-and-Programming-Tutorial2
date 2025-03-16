package eleve.hhamnnes.tutorial2.tools;

import eleve.hhamnnes.tutorial2.interfaces.IntListInIntListOutAlgorithm;
import isep.eleve.hamnnes.interfaces.ExecutionTimeAnalyzer;

import java.util.Random;


public class ETAIntListInIntListOut implements ExecutionTimeAnalyzer<IntListInIntListOutAlgorithm> {

    private int numberOfSamples;
    private long executionTime;
    private long startTime;
    private long stopTime;
    private Integer[] inputList;
    private Integer[] sortedResult;

    public ETAIntListInIntListOut() {
    }

    @Override
    public Object[][] measureExecutionTime(int scopeStart, int scopeEnd, int interval, IntListInIntListOutAlgorithm algorithm) {
        numberOfSamples = (scopeEnd - scopeStart) / interval;

        if (numberOfSamples % 2 != 0) numberOfSamples -= 1;

        Object[][] executionTimes = new Object[numberOfSamples][3];

        Random random = new Random();

    
        for (int i = 0; i < 10; i++) {
            algorithm.execute(new Integer[]{random.nextInt(100), random.nextInt(100)});
        }

        for (int i = 0, y = scopeStart; i < numberOfSamples; i++, y += interval) {
            inputList = new Integer[y];
            for (int a = 0; a < y; a++) {
                inputList[a] = random.nextInt(1000);
            }

            startTime = System.nanoTime();
            sortedResult = algorithm.execute(inputList);
            stopTime = System.nanoTime();
            executionTime = stopTime - startTime;

            StringBuilder listString = new StringBuilder();

            executionTimes[i][0] = y;
            executionTimes[i][1] = executionTime;

            listString.append("[");
            for(int z = 0; z < sortedResult.length; z++) {
                listString.append(sortedResult[z]);
                if(z < sortedResult.length - 1) {
                    listString.append(",");
                }
            }
            listString.append("]");


            executionTimes[i][2] = listString;
        }

        return executionTimes;
    }
}
