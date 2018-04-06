package br.com.zarpo.exercises.five;

import java.io.*;
import java.util.*;

/**
 *
 * @author Artur
 */
public class Exercise {

    public static void main(String[] args) throws FileNotFoundException {
        String csvMembers = "src\\br\\com\\zarpo\\data\\Members.csv";
        String csvVisits = "src\\br\\com\\zarpo\\data\\Visits.csv";
        BufferedReader brM = null;
        BufferedReader brV = null;
        String lineM = "";
        String lineV = "";
        int incomeA = 0;
        int incomeB = 0;
        int incomeC = 0;
        try {
            brV = new BufferedReader(new FileReader(csvVisits));
            brV.readLine();
            while ((lineV = brV.readLine()) != null) {
                String[] columnsV = lineV.split(",");
                if (Integer.parseInt(columnsV[3]) > 0) {
                    brM = new BufferedReader(new FileReader(csvMembers));
                    brM.readLine();
                    while ((lineM = brM.readLine()) != null) {
                        String columnsM[] = lineM.split(",");
                        if (Integer.parseInt(columnsV[1]) == Integer.parseInt(columnsM[0])) {
                            if (columnsM[2].equals("A")) {
                                incomeA = incomeA + Integer.parseInt(columnsV[3]);
                            }
                            else if (columnsM[2].equals("B")) {
                                incomeB = incomeB + Integer.parseInt(columnsV[3]);
                            }
                            else {
                                incomeC = incomeC + Integer.parseInt(columnsV[3]);
                            }
                            break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(incomeA + " " + incomeB + " " + incomeC);
    }
}
