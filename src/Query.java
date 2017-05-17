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
        while (true) {
            System.out.println("Enter word:");
            Scanner fj = new Scanner(System.in);
            String input = fj.nextLine();
            //String input = "dedicated";
            if(input.equals("EXIT")) {
                return;
            }
            Word target = new Word(input);
            ObjectTreeNode found = tree.searchBST(target);
            if(target == null) {
                System.out.println("Error: Word not found.");
                return;
            }
            System.out.println(found.getInfo().toString());
        }
    }
}

