/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author Ahmed.Oladele
 */
import java.io.*;
import java.util.Scanner;

public class Test {

    public static void main(String args[]) {cd 
        try 
        {
            System.out.println("****************************************");
            System.out.println("****************************************");
            System.out.println("************File Splitter(LAA)**********");
            System.out.println("****************************************");
            System.out.println("****************************************");
            System.out.println("Enter Source file location");
            Scanner scanner = new Scanner(System.in);
            String inputfile = scanner.nextLine();
            System.out.println("Enter No of Lines required in splited files");
            String nol = scanner.nextLine();
            System.out.println("Enter OutPut Location");
            String outputLocation = scanner.nextLine();            
            
            if(inputfile==null){System.out.println("Wrong inputfile Start Over");System.exit(0);}
            
            if(nol==null){System.out.println("Wrong Number of Lines Start Over");System.exit(0);}
            if(outputLocation==null){System.out.println("Wrong outputLocation Start Over");System.exit(0);}
            System.out.println("********************************");
            System.out.println("********************************");
            System.out.println("*****RELAX BEANS IS COOKING*****");
            System.out.println("********************************");
            System.out.println("********************************");
            
            int count = 0;
            BufferedReader reader = new BufferedReader(new FileReader(inputfile));
            while (reader.readLine() != null) {
                count++;
            }
            reader.close();

            System.out.println("Lines in the file: " + count);     // Displays no. of lines in the input file.

            double temp = (count / Double.parseDouble(nol));
            int temp1 = (int) temp;
            int nof = 0;
            if (temp1 == temp) {
                nof = temp1;
            } else {
                nof = temp1 + 1;
            }
            System.out.println("No. of files to be generated :" + nof); // Displays no. of files to be generated.

            //---------------------------------------------------------------------------------------------------------
            // Actual splitting of file into smaller files
            FileInputStream fstream = new FileInputStream(inputfile);
            DataInputStream in = new DataInputStream(fstream);

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            for (int j = 1; j <= nof; j++) {
                FileWriter fstream1 = new FileWriter(outputLocation+"/File" + j + ".txt");     // Destination File Location
                BufferedWriter out = new BufferedWriter(fstream1);
                for (int i = 1; i <= Double.parseDouble(nol); i++) {
                    strLine = br.readLine();
                    if (strLine != null) {
                        out.write(strLine);
                        if (i != Double.parseDouble(nol)) {
                            out.newLine();
                        }
                    }
                }
                out.close();
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("******HOPE YOU ENJOYED THE MEAL******");
        System.out.println("************LAA**********");
    }

}
