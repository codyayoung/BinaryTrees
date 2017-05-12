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
            Scanner sc = new Scanner(lin);  //Remember - do not insert words in hash table into tree!
            while (sc.hasNext()) {
                String input_string = sc.next();
                //Ignore all non-letter characters, convert to lower case
                String delims = "[\\W]+";
                String[] tokens = input_string.replaceAll("\\s*\\p{Punct}+\\s*$", "").toLowerCase().split(delims);
                String first = tokens[0];

                if(first.equals(""))
                    continue;

                lpos = new LinePosition(line_no, word_pos);     //Create line position object

                lpos.setLine_no(lr.getLineNumber());   //Gets line number from LineNumberReader method
                if(lin.equals(" ")) {
                    word_pos = 1;
                }
                lpos.setLine_no(line_no);               //Sets line number
                lpos.setWord_pos(word_pos);             //Sets word position

                //word = new Word(first, word_count, lpos);
                word = new Word(first, word_count, lpos);
                word.setInword(first);      //Set word object in word
               // line_track.insert(lpos);

                word_pos++;
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
