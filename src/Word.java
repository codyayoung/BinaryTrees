/**
 * Creates Word class objects, which are placed into the object binary search tree.
 * Created by Cody Young on 5/4/17.
 */
public class Word implements TreeComparable, Comparable{
    //Instance variables
    private String inword;                //The word itself
    private int word_count;               //Word count
    private ObjectList line_track;        //Object list containing LinePosition objects,
                                          //which contains line number and word position.
    private LinePosition lpos;

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
    public Word (String inword, int word_count, LinePosition lpos) {
        this.word_count = word_count;
        line_track = new ObjectList();
        this.inword = inword;
        this.lpos = lpos;
    }

    public LinePosition getLpos() {
        return lpos;
    }

    public void setLpos(LinePosition lpos) {
        this.lpos = lpos;
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
        System.out.printf("%-10s %10d",inword,word_count);  //Prints out word and count
        //Prints out line number and word position for each word
        System.out.printf("%20s-%d", ((LinePosition) line_track.getFirst()).getLine_no(), ((LinePosition) line_track.getFirst()).getWord_pos());
        System.out.print('\n');
        //Use the following while loop after all nodes are accounted for
        /*ObjectListNode p = line_track.getFirstNode();
        while(p != null) {
            LinePosition temp = (LinePosition)p.getInfo();
            System.out.printf("%20s-%d ", temp.getLine_no(), temp.getWord_pos());
        }
        System.out.print('\n');
        */
    }

    /**
     * compareTo method overwrite to compare Word objects.
     * @param w O oject to compare
     * @return If word w is greater than y, return 1 
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
