package br.com.zarpo.exercises;

import java.io.*;

/**
 *
 * @author Artur
 */
public class ExerciseOne {

    public static void main(String[] args) throws FileNotFoundException {
        String csvPath = "src\\br\\com\\zarpo\\data\\Visits.csv";
        BufferedReader br = null;
        String line = "";
        int totalSales = 0;
        try {
            br = new BufferedReader(new FileReader(csvPath));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                totalSales = totalSales + Integer.parseInt(columns[3]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(totalSales);
    }
}
