import java.io.*;
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
    private ObjectList line_track;      //ObjectList attached to Word objects
    private LinePosition lpos;       //Object attached to Words used to track line number and word position

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
        LineNumberReader lr = new LineNumberReader(new FileReader("getty.txt"));
        lr.setLineNumber(1);        //Overrides default line number of 0
        int word_count = 0;
        int line_no = 1;
        int word_pos = 1;
        String lin;

        while((lin = lr.readLine()) != null) {
            Scanner sc = new Scanner(lin);
            while (sc.hasNext()) {
                String input_string = sc.next();
                //Ignore all non-letter characters, convert to lower case
                String[] tokens = input_string.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                String first = tokens[0];


                word = new Word(first, word_count, line_track);
                line_track = new ObjectList();
                lpos = new LinePosition(line_no, word_pos);     //Create line position object
                word.setInword(first);

                lpos.setLine_no(lr.getLineNumber());
                lpos.setWord_pos(word_pos);

                line_track.addFirst(lpos);
                word.setWord_count(word_count);
                tree.insertBSTDup(word);
            }
        }
    }

    /**
     * Outputs each word in binary tree alphabetically, line number, word position, and word count.
     */
    public void outputTree() {
        ObjectTreeNode p = tree.getRoot();
        tree.inTrav(p);
    }
}
