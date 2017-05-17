import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Allows user to perform searches on words in text file. Returns statistics.
 * @author Cody Young
 * @version 5/18/17
 */
public class Query {
    //Instance variables
    ObjectBinaryTree tree;
    Word target;
    private PrintWriter foutput;

    /**
     * Overloaded constructor method for Query objects - takes binary tree as argument.
     */
    public Query(ObjectBinaryTree tree) throws IOException {
        target = new Word();
        this.tree = tree;
        foutput = new PrintWriter(new FileWriter("csis.txt"));
    }

    public void findWord() throws IOException {
        System.out.println("SUPER WORD SEARCHER(ALMOST LIKE GOOGLE)");
        foutput.println("SUPER WORD SEARCHER(ALMOST LIKE GOOGLE)");
        System.out.println("--------------------------------------------");
        foutput.println("--------------------------------------------");
        while (true) {
            System.out.println("Enter word:");          //Get user input
            foutput.println("Enter word:");
            Scanner fj = new Scanner(System.in);
            String input = fj.nextLine();
            //String input = "soldier";
            if(input.equals("EXIT")) {              //Type "EXIT" to exit program and end execution
                return;
            }
            Word target = new Word(input);
            ObjectTreeNode found = tree.searchBST(target);
            if(found == null) {                 //Check if word is not found
                System.out.println("ERROR: Word not found.");
                foutput.println("ERROR: Word not found.");
                return;
            }
            System.out.println(found.getInfo().toString());     //Print out Word object found
            foutput.println(found.getInfo().toString());
        }
    }
}

