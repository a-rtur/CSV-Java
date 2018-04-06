package br.com.zarpo.exercises;

import java.io.*;
import java.util.*;

/**
 *
 * @author Artur
 */
public class Exercise3 {

    public static void main(String[] args) throws FileNotFoundException {
        String csvMembers = "src\\br\\com\\zarpo\\data\\Members.csv";
        String csvVisits = "src\\br\\com\\zarpo\\data\\Visits.csv";
        BufferedReader brM = null;
        BufferedReader brV = null;
        String lineM = "";
        String lineV = "";
        ArrayList<Integer> dontCheck = new ArrayList<Integer>();
        int alreadyVisited = 0;
        int alreadyBought = 0;
        try {
            brM = new BufferedReader(new FileReader(csvMembers));
            brM.readLine();
            while ((lineM = brM.readLine()) != null) {
                String[] columnsM = lineM.split(",");
                int currentIdM = Integer.parseInt(columnsM[0]);
                brV = new BufferedReader(new FileReader(csvVisits));
                brV.readLine();
                while ((lineV = brV.readLine()) != null) {
                    String columnsV[] = lineV.split(",");
                    boolean foundIt = false;
                    int currentIdV = Integer.parseInt(columnsV[1]);
                    int currentVisits = Integer.parseInt(columnsV[2]);
                    int currentSales = Integer.parseInt(columnsV[3]);
                    if (currentIdM == currentIdV) {
                        for (int i = 0; i < dontCheck.size(); i++) {
                            if (currentIdM == dontCheck.get(i)) {
                                foundIt = true;
                                break;
                            }
                        }
                        if (currentVisits > 0 && foundIt == false) {
                            alreadyVisited++;
                        }
                        if (currentSales > 0 && foundIt == false) {
                            alreadyBought++;
                        }
                        dontCheck.add(currentIdM);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Visited at least once: " + alreadyVisited);
        System.out.println("Bought at least once: " + alreadyBought);
    }
}
