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
     * Reads from getty.txt (after hashing), wraps into Word objects, and places into object binary tree.
     */
    public void scanGetty() throws IOException {
        Scanner sc = new Scanner(new File("getty.txt"));
        int word_count = 0;
        int line_no = 1;
        int word_pos = 1;

        while(sc.hasNext()) {
            String input_string = sc.next();
            //Ignore all non-letter characters, convert to lower case
            String delims = "[\\W]+";
            String[] tokens = input_string.split(delims);
            String first = tokens[0];

            word = new Word(first, word_count, lpos, line_track);   //Create new word object

            for(String word: tokens) {
                lpos = new LinePosition(line_no, word_pos);     //Create line position object
                line_track = new ObjectList();                  //Create new ObjectList

                lpos.setLine_no(line_no);
                if(sc.hasNextLine()) {
                    word_pos++;
                }
                else {
                    lpos.setWord_pos(word_pos);
                    line_no++;
                }
            }
            word.setInword(first);
            line_track.insert(lpos);
            tree.insertBSTDup(word);
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
