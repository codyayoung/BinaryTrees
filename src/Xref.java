import java.io.*;
import java.util.Scanner;

/**
 * Outputs a cross-referenced listing of the text file. Performs traversal of binary tree.
 * Hases files into 
 ** @author Cody Young
 * @version 5/19/17
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
     * Reads from getty.txt (after hashing), wraps into Word objects, and places into object binary tree.
     */
    public void scanGetty() throws IOException {
        Scanner sc = new Scanner(new File("getty.txt"));
        int word_count = 1;
        int line_no = 1;
        int word_pos = 0;

        while(sc.hasNextLine()) {
            String input_string = sc.nextLine();
            //Ignore all non-letter characters, convert to lower case
            String delims = "[\\W]+";
            String[] tokens = input_string.replaceAll("\\s*\\p{Punct}+\\s*$", "").toLowerCase().split(delims);
            for(int i = 0; i < tokens.length; i++) {
                String in_string = tokens[i];

                lpos = new LinePosition(line_no, word_pos);                     //Create line position object
                line_track = new ObjectList();                                  //Create new ObjectList
                word = new Word(in_string, word_count, lpos, line_track);       //Create new Word object

                word.setInword(in_string);

                lpos.setLine_no(line_no);       //Set line number

                word_pos++;
                lpos.setWord_pos(word_pos);     //Set word position

                line_track.insert(lpos);        //Insert LinePosition object into linked list
                tree.insertBSTDup(word);        //Insert word into tree
            }
            line_no++;          //Increment line number
            word_pos = 0;       //Reset word position when new line is reached
        }
    }

    /**
     * Outputs each word in binary tree alphabetically, line number, word position, and word count.
     */
    public void outputTree() {
        System.out.print('\n');
        System.out.printf("%-10s %15s %37s\n", "Word List", "Word Count", "Line Number-Word Position");
        ObjectTreeNode p = tree.getRoot();
        tree.inTrav(p);
    }
}
