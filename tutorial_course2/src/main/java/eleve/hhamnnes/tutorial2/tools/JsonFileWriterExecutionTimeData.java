package eleve.hhamnnes.tutorial2.tools;

import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriterExecutionTimeData {

    

    public static void writeToFile(Object[][] executionTimeData, String fileName) {


        int rows = executionTimeData.length;

        StringBuilder jsonString = new StringBuilder();

        jsonString.append("[\n");

        for(int i = 0; i < rows; i++) {
            jsonString.append("    {\n");
            
            jsonString.append("     \"Number\": " + executionTimeData[i][0] + ",\n");
            jsonString.append("     \"ExecutionTime\": " + executionTimeData[i][1] + ",\n");

            if(executionTimeData[i][2] instanceof String) {
                jsonString.append("     \"Result\": " + "\"" + executionTimeData[i][2] + "\"" + "\n");

            }
            else {
                jsonString.append("     \"Result\": " + executionTimeData[i][2] + "\n");
            }
            
            
            jsonString.append("    }");

            if(i < rows - 1) jsonString.append(",\n");

            
        }

        jsonString.append("\n]");

        System.out.println(jsonString);

        String filePath = "X:\\Onedrive\\Dokumenter\\Høgskolen i Østfold\\4.Semster\\II.2415 Advanced Algorithmic & Programming\\Assignments\\Assingment 2\\Output\\";

        try (FileWriter file = new FileWriter(filePath + fileName)) {
            file.write(jsonString.toString());
            System.out.println("Data has been written to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }







        


    }

    
}

