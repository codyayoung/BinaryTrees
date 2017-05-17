import java.io.*;
import java.util.Scanner;

/**
 * Performs operations and runs main program.
 * @author Cody Young   Palomar ID: 008372648
 * @version 5/18/17
 */
public class Driver {
    public static void main(String[] args) throws IOException {
        PrintWriter foutput = new PrintWriter(new FileWriter("csis.txt"));
        Xref x = new Xref(foutput);
        int line_number = 0;

        //Start main program output
        Scanner sc = new Scanner(new File("getty.txt"));
        System.out.println("The Gettysburg Address - November 19, 1863");
        foutput.println("The Gettysburg Address - November 19, 1863");

        while (sc.hasNext()) {       //Outputs text file in entirety with line numbers
            line_number += 1;
            String input_string = sc.nextLine();
            System.out.printf("%-5d  ", line_number);
            foutput.printf("%-5d  ", line_number);
            System.out.println(input_string);
            foutput.println(input_string);
        }
        System.out.print('\n');
        foutput.print('\n');
        x.scanGetty();
        x.outputTree();
        foutput.close();
    }
}
