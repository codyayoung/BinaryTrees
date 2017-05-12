import java.io.*;
import java.util.Scanner;

/**
 * Performs operations and runs main program.
 * @author Cody Young   Palomar ID: 008372648
 * @version 5/18/17
 */
public class Driver {

    public static void main (String [] args) throws IOException {
        Xref x = new Xref();
        Hash h = new Hash();
        int line_number = 0;

        //h.getHash(omit);

        Scanner sc = new Scanner(new File("getty.txt"));

        while(sc.hasNext()) {       //Outputs text file in entirety with line numbers
            line_number += 1;
            String input_string = sc.nextLine();
            System.out.printf("%-5d  ", line_number);
            System.out.println(input_string);
        }
        x.scanGetty();
        x.outputTree();
    }
}
