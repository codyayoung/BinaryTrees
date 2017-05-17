import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Creates Word class objects, which are placed into the object binary search tree.
 * @author Cody Young
 * @version 5/19/17
 */
public class Word implements TreeComparable, Comparable{
    //Instance variables
    private String inword;                //The word itself
    private int word_count;               //Word count
    private ObjectList line_track;        //Object list containing LinePosition objects,
                                          //which contains line number and word position.
    private LinePosition lpos;            //LinePosition object to insert into linked list
    private int key;                      //Hash value - determines which index to store in hash table
    private PrintWriter foutput;

    /**
     * Constructor for Word objects. Takes input string and variables as argument.
     */
    public Word (String inword, int word_count, LinePosition lpos, ObjectList line_track, PrintWriter foutput) throws IOException {
        this.word_count = word_count;
        this.inword = inword;
        this.lpos = lpos;
        this.line_track = line_track;
        this.foutput = foutput;
    }

    /**
     * Overloaded empty constructor for word objects.
     */
    public Word(PrintWriter foutput) throws IOException {
        this.foutput = foutput;
    }

    /**
     * Overloaded constructor for Word objects. Takes input string and hash value as argument.
     */
    public Word(String inword, int key, PrintWriter foutput) throws IOException {
        this.inword = inword;
        this.key = key;
        this.foutput = foutput;
    }

    /**
     * Overloaded constructor for Word objects. Takes input string as argument.
     */
    public Word(String inword, PrintWriter foutput) throws IOException {
        this.inword = inword;
        this.foutput = foutput;
    }

    /**
     * Returns line position of word.
     * @return Line position
     */
    public LinePosition getLpos() {
        return lpos;
    }

    /**
     * Gets word input from text file.
     * @return Word from text file.
     */
    public String getInword() {
        return inword;
    }

    /**
     * Sets word from text file.
     * @param inword Input word from text file
     */
    public void setInword(String inword) {
        this.inword = inword;
    }

    /**
     * Performs specific operations on duplicate objects in the binary tree.
     * @param r Duplicate object
     */
    public void operate (Object r) {
        //If word already exists in binary tree, do these things
        Word w = (Word) r;
        word_count++;       //Increment word count
        //Get and set new line number where word is found again
        line_track.insert(w.getLpos());
        //Get and set word position where word is found
        //Insert into ObjectList
    }

    /**
     * Visits node and prints out contents and info fields.
     */
    public void visit() {
        ObjectListNode p = line_track.getFirstNode();
        System.out.printf("%-10s%10d ",inword,word_count);  //Prints out word and count
        foutput.printf("%-10s%10d ",inword,word_count);
        System.out.print("                 ");
        foutput.print("                 ");
        //Prints out line number and word position for each word
        while(p != null) {
            LinePosition temp = (LinePosition)p.getInfo();
            System.out.printf("%d-%d ", temp.getLine_no(), temp.getWord_pos());
            foutput.printf("%d-%d ", temp.getLine_no(), temp.getWord_pos());
            p = p.getNext();
        }
        System.out.print('\n');
        foutput.print('\n');
    }

    /**
     * compareTo method overwrite to compare Word objects.
     * @param w O object to compare
     * @return If word w is greater than y, return 1 
     */
    public int compareTo(Object w) {
        Word y = (Word) w;
        return inword.compareTo(y.getInword());
    }

    /**
     * Gets hash value.
     * @return Hash value
     */
    public int getKey() {
        return key;
    }

    /**
     * Gets number of times word appears in file.
     * @return Frequency of word
     */
    public int getWord_count() {
        return word_count;
    }

    /**
     *Overriden toString method for Word objects - used to print out searched word in Query.
     * @return String representation of a Word object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(inword);
        sb.append("   ");
        sb.append(getWord_count());
        sb.append("   ");
        ObjectListNode p = line_track.getFirstNode();
        while(p != null) {
            LinePosition temp = (LinePosition)p.getInfo();
            sb.append(temp.toString());
            sb.append(" ");
            p = p.getNext();
        }
        return sb.toString();
    }
}
