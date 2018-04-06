package br.com.zarpo.exercises;

import java.io.*;

/**
 *
 * @author Artur
 */
public class ExerciseTwo {

    public static void main(String[] args) throws FileNotFoundException {
        String csvPath = "src\\br\\com\\zarpo\\data\\Visits.csv";
        BufferedReader br = null;
        String line = "";
        double totalSales = 0;
        double totalVisits = 0;
        double conversionRate;
        try {
            br = new BufferedReader(new FileReader(csvPath));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                totalSales = totalSales + Integer.parseInt(columns[3]);
                totalVisits = totalVisits + 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        conversionRate = totalSales / totalVisits * 100;
        System.out.println(conversionRate + "%");
    }
}
