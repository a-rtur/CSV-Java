package br.com.zarpo.exercises;

import java.io.*;

/**
 *
 * @author Artur
 */
public class Exercise4 {

    public static void main(String[] args) throws FileNotFoundException {
        String csvPath = "src\\br\\com\\zarpo\\data\\Members.csv";
        BufferedReader br = null;
        String line = "";
        int A = 0;
        int B = 0;
        int C = 0;
        try {
            br = new BufferedReader(new FileReader(csvPath));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[2].equals("A")) {
                    A++;
                }
                else if (columns[2].equals("B")) {
                    B++;
                }
                else {
                    C++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(A + " " + B + " " + C);
    }
}
