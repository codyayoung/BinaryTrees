import java.util.Scanner;

/**
 * Allows user to perform searches on words in text file. Returns statistics.
 * @author Cody Young
 * @version 5/18/17
 */
public class Query {
    //Instance variables
    ObjectBinaryTree target;

    /**
     * Constructor method for Query objects.
     */
    public Query() {

    }

    /**
     * Overloaded constructor method for Query objects - takes binary tree as argument.
     */
    public Query(ObjectBinaryTree target) {
        this.target = target;
    }

    public void findWord() {
        System.out.println("Enter word to search:");
        Scanner finput = new Scanner(System.in);

    }
}
