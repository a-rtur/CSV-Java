package br.com.zarpo.exercises.three;

import java.io.*;
import java.util.*;

/**
 *
 * @author Artur
 */
public class ExerciseSales {

    public static void main(String[] args) throws FileNotFoundException {
        String csvVisits = "src\\br\\com\\zarpo\\data\\Visits.csv";
        BufferedReader brV = null;
        String lineV = "";
        ArrayList<Integer> dontCheck = new ArrayList<Integer>();
        int alreadyBought = 0;
        try {
            brV = new BufferedReader(new FileReader(csvVisits));
            brV.readLine();
            while ((lineV = brV.readLine()) != null) {
                String columnsV[] = lineV.split(",");
                boolean foundIt = false;
                int currentIdV = Integer.parseInt(columnsV[1]);
                int currentSales = Integer.parseInt(columnsV[3]);
                for (int i = 0; i < dontCheck.size(); i++) {
                    if (currentIdV == dontCheck.get(i)) {
                        foundIt = true;
                        break;
                    }
                }
                if (currentSales > 0 && foundIt == false) {
                    alreadyBought++;
                }
                if (currentSales != 0) {
                    dontCheck.add(currentIdV);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Bought at least once: " + alreadyBought);
    }
}
