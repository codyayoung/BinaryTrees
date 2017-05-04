/**
 * Creates Word class objects, which are placed into the object binary search tree.
 * Created by Cody Young on 5/4/17.
 */
public class Word {
    //Instance variables
    private String inword;
    private int word_count;     //Word count
    private int word_pos;       //Word position
    private int line_num;
    private LinePosition line_tracker;        //Contains line number and word position

    /**
     * Constructor method for Word objects. Initializes instance variables.
     */
    public Word () {
        this.inword = inword;
        word_count = 0;
        LinePosition line_tracker = new LinePosition(line_num, word_pos);
    }

    public String getInword() {
        return inword;
    }

    public void setInword(String inword) {
        this.inword = inword;
    }
}
