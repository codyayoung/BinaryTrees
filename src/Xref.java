import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Outputs a cross-referenced listing of the text file. Performs traversal of binary tree.
 *
 * Created by Cody Young on 5/8/2017.
 */
public class Xref {
    //Instance variables
    private Word word;      //Word object
    private ObjectBinaryTree tree;      //Binary tree for Word objects

    /**
     * Constructor method for Xref objects. Initializes instance variables.
     */
    public Xref() throws IOException {
        tree = new ObjectBinaryTree();
    }

    /**
     * Reads from getty.txt (after hashing) , wraps into Word objects, and places into object binary tree.
     */
    public void scanGetty() throws IOException {
        Scanner sc = new Scanner(new File("getty.txt"));
        while (sc.hasNext()) {
            String input_string = sc.next();
            String delims = "[,.-; ]+";
            String[] tokens = input_string.toLowerCase().split(delims);
            String first = tokens[0];
            word = new Word(first);
            tree.insertBSTDup(word);
        }
    }

    /**
     * Outputs each word in binary tree alphabetically, line number, word position, and word count.
     */
    public void outputTree() {
        ObjectTreeNode p = tree.getRoot();
        while(p != null) {
            Word temp = (Word)p.getInfo();
            tree.inTrav(p);
            System.out.printf("%s", temp.getInword());
        }
    }
}
