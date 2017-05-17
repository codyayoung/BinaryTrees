import java.io.IOException;
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

    /**
     * Overloaded constructor method for Query objects - takes binary tree as argument.
     */
    public Query(ObjectBinaryTree tree) {
        target = new Word();
        this.tree = tree;
    }

    public void findWord() throws IOException {
        System.out.println("SUPER WORD SEARCHER(ALMOST LIKE GOOGLE)");
        System.out.println("--------------------------------------------");
        System.out.println("Enter word to search:");
        try {

            Scanner fj = new Scanner(System.in);
            String input = fj.nextLine();
            Word target = new Word(input);
            tree.searchBST(target.getInword());
            target.visit();

        } catch (InputMismatchException a) {
            System.out.println("Error: Word not found.");
        }
    }
}

