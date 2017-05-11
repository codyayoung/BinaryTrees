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
    //private ObjectList line_track;      //ObjectList attached to Word objects
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
        LineNumberReader lr = new LineNumberReader(new FileReader("getty.txt"));
        int word_count = 1;
        int line_no = 1;
        int word_pos = 1;      //Position of word in line
        String lin;

        while((lin = lr.readLine()) != null) {
            Scanner sc = new Scanner(lin);
            while (sc.hasNext()) {
                String input_string = sc.next();
                //Ignore all non-letter characters, convert to lower case
                //Need to remove punctuation instead of replacing it with a space
                String delims = "[\\W]+";
                String[] tokens = input_string.replaceAll("\\s*\\p{Punct}+\\s*$", "").toLowerCase().split(delims);
                //String[] tokens = input_string.split(delims);
                String first = tokens[0];

                if(first.equals(""))
                    continue;
                word = new Word(first, word_count);
                lpos = new LinePosition(line_no, word_pos);     //Create line position object
                word.setInword(first);      //Set word object in word

                lpos.setLine_no(lr.getLineNumber());   //Gets line number from LineNumberReader method
                lpos.setWord_pos(word_pos);             //Doesn't do much yet
                word_pos++;

                ObjectList lineTrack = word.getLine_track();
                lineTrack.addFirst(lpos);          //Adds LinePosition Object to ObjectList
                word.setLine_track(lineTrack);     //Adds ObjectList to Word object
                //word.setWord_count(word_count);    //Sets word count
                tree.insertBSTDup(word);           //Inserts word into tree
            }
        }
    }

    /**
     * Outputs each word in binary tree alphabetically, line number, word position, and word count.
     */
    public void outputTree() {
        System.out.print('\n');
        System.out.printf("%-10s %15s %40s\n", "Word List", "Word Count", "Line Number - Word Position");
        ObjectTreeNode p = tree.getRoot();
        tree.inTrav(p);
    }
}
