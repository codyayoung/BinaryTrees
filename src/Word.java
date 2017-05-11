/**
 * Creates Word class objects, which are placed into the object binary search tree.
 * Created by Cody Young on 5/4/17.
 */
public class Word implements TreeComparable {
    //Instance variables
    private String inword;                //The word itself
    private int word_count;               //Word count
    private ObjectList line_track;        //Object list containing LinePosition objects,
                                          //which contains line number and word position.

    /**
     * Constructor method for Word objects. Initializes instance variables.
     */
    public Word () {
        word_count = 0;
        line_track = new ObjectList();
    }

    /**
     * Overloaded constructor for Word objects. Takes input string as argument.
     */
    public Word (String inword, int word_count) {
        word_count = 0;
        line_track = new ObjectList();
        this.inword = inword;
    }

    /**`
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
     * Adds a LinePosition object to the ObjectList.
     */
    public void addLinePos(LinePosition linepos) {
        line_track.insert(linepos);
    }

    /**
     * Does an operation on something.
     * @param r
     */
    public void operate (Object r) {

    }

    /**
     * Visits node and prints out contents and info fields.
     */
    public void visit() {
        System.out.printf("%-10s %10d \n",inword,((LinePosition)line_track.getFirst()).getLine_no());  //Prints out word
        //System.out.printf("%10d \n", ((LinePosition)line_track.getFirst()).getLine_no());
    }

    /**
     * compareTo method overwrite to compare Word objects.
     * @param w
     * @return
     */
    public int compareTo(Object w) {
        Word y = (Word) w;
        return inword.compareTo(y.getInword());
    }

    public int getWord_count() {
        return word_count;
    }

    public void setWord_count(int word_count) {
        this.word_count = word_count;
    }

    public ObjectList getLine_track() {
        return line_track;
    }

    public void setLine_track(ObjectList line_track) {
        this.line_track = line_track;
    }
}
