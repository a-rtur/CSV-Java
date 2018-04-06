package br.com.zarpo.exercises.six;

import java.io.*;
import java.text.ParseException;
import java.util.*;

/**
 *
 * @author Artur
 */
public class Exercise {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        String csvMembers = "src\\br\\com\\zarpo\\data\\Members.csv";
        String csvVisits = "src\\br\\com\\zarpo\\data\\Visits.csv";
        BufferedReader brM = null;
        BufferedReader brV = null;
        String lineM = "";
        String lineV = "";
        double totalVisits = 0;
        double visits = 0;
        boolean firstRun = true;
        double result;
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
                    int currentIdV = Integer.parseInt(columnsV[1]);
                    if (currentIdM == currentIdV) {
                        String[] subscribeDate = columnsM[1].split("-");
                        String[] firstVisitDate = columnsV[0].split("-");
                        HowManyDays HMD = new HowManyDays();
                        long howManyDays = HMD.howManyDays(Integer.parseInt(subscribeDate[0]), Integer.parseInt(subscribeDate[1]), Integer.parseInt(subscribeDate[2]), Integer.parseInt(firstVisitDate[0]), Integer.parseInt(firstVisitDate[1]), Integer.parseInt(firstVisitDate[2]));
                        if (howManyDays <= 15) {
                            visits = visits + Integer.parseInt(columnsV[2]);
                        }
                    }
                    if (firstRun == true) {
                        totalVisits = totalVisits + Integer.parseInt(columnsV[2]);
                    }
                }
                firstRun = false;
            }
            System.out.println(visits);
            System.out.println(totalVisits);
            result = visits/totalVisits * 100;
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
