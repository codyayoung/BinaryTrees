/**
 * Creates LinePosition objects to keep track of line numbers
 * and current positions of words from input file.
 * Created by Cody Young on 5/4/17.
 */
public class LinePosition {
    //Instance variables
    private int line_no;
    private int word_pos;
    private ObjectList wordtrack;

    /**
     * Constructor method for LinePosition objects. Initializes instance variables.
     */
    public LinePosition(int line_no, int word_pos) {
        this.line_no = line_no;
        this.word_pos = word_pos;
        ObjectList wordtrack = new ObjectList();
    }

    public int getLine_no() {
        return line_no;
    }

    public void setLine_no(int line_no) {
        this.line_no = line_no;
    }

    public int getWord_pos() {
        return word_pos;
    }

    public void setWord_pos(int word_pos) {
        this.word_pos = word_pos;
    }

    public ObjectList getWordtrack() {
        return wordtrack;
    }

    public void setWordtrack(ObjectList wordtrack) {
        this.wordtrack = wordtrack;
    }
}