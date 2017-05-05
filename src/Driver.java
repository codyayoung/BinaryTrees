import java.io.*;
import java.util.Scanner;

/**
 * Created by Cody on 5/4/2017.
 */
public class Driver {

    public static void main (String [] args) throws IOException {
        int line_number = 0;
        Scanner sc = new Scanner(new File("getty.txt"));

        while(sc.hasNext()) {
            line_number += 1;
            String input_string = sc.nextLine();
            System.out.printf("%d ", line_number);
            System.out.println(input_string);
        }
    }
}
