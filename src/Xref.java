import java.io.*;
import java.util.ArrayList;
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
    private Hash h;                  //Hash table and function

    /**
     * Constructor method for Xref objects. Initializes instance variables.
     */
    public Xref() throws IOException {

        tree = new ObjectBinaryTree();
        h = new Hash();
    }

    /**
     * Reads from getty.txt (after hashing), wraps into Word objects, and places into object binary tree.
     */
    public void scanGetty() throws IOException {
        Scanner sc = new Scanner(new File("getty.txt"));
        Scanner om = new Scanner(new File("omitfile.txt"));
        ArrayList<String> blacklist = new ArrayList<String>();
        int word_count = 1;
        int line_no = 1;
        int word_pos = 0;

        while(om.hasNextLine()) {           //Reads input from omit file, puts in string arraylist
            String word = om.nextLine();
            blacklist.add(word);
        }
        for(String browns : blacklist) {    //Hashes each word in string arraylist
            h.cookHash(browns);
        }

        System.out.println("Initializing hash...done");
        System.out.println("Collisions:" + h.getCollisions());
        System.out.print('\n');
        System.out.println("Description: Takes input string, shifts each character's bit in string to the left by 7,");
        System.out.println("sums value and divides by the modulus, which is the table size.");
        //Print average chain size(float)
        //Print maximum chain size

        while(sc.hasNextLine()) {
            String input_string = sc.nextLine();
            //Ignore all non-letter characters, convert to lower case
            String delims = "[\\W]+";
            String[] tokens = input_string.replaceAll("\\s*\\p{Punct}+\\s*$", "").toLowerCase().split(delims);
            for (int i = 0; i < tokens.length; i++) {
                String in_string = tokens[i];
                if (h.containsHash(in_string)) {
                    break;
                }
                //If hash value of main string matches blacklist, break - else continue
                else {
                    lpos = new LinePosition(line_no, word_pos);                     //Create line position object
                    line_track = new ObjectList();                                  //Create new ObjectList
                    word = new Word(in_string, word_count, lpos, line_track);       //Create new Word object

                    word.setInword(in_string);      //Set word
                    lpos.setLine_no(line_no);       //Set line number

                    word_pos++;
                    lpos.setWord_pos(word_pos);     //Set word position

                    line_track.insert(lpos);        //Insert LinePosition object into linked list
                    tree.insertBSTDup(word);        //Insert word into tree
                }
            }
            line_no++;          //Increment line number
            word_pos = 0;       //Reset word position when new line is reached
        }
        h.outputHash();
    }

    /**
     * Outputs each word in binary tree alphabetically, line number, word position, and word count.
     */
    public void outputTree() {
        System.out.print('\n');
        System.out.println("X-REFERENCE");
        System.out.println("-----------");
        System.out.printf("%-10s %15s %37s\n", "Word List", "Word Count", "Line Number-Word Position\n");
        ObjectTreeNode p = tree.getRoot();
        tree.inTrav(p);
    }
}
