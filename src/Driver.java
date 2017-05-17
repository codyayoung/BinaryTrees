import java.io.*;
import java.util.Scanner;
/**
 * Binary Trees Lab - Uses binary trees and linked lists
 * to perform functions on a famous speech.
 * @author Cody Young   Palomar ID: 008372648
 * @version 5/19/17
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

        while (sc.hasNext()) {       //Outputs raw text file with line numbers
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
