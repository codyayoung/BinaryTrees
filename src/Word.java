/**
 * Creates Word class objects, which are placed into the object binary search tree.
 * Created by Cody Young on 5/4/17.
 */
public class Word {
    //Instance variables
    private String inword;
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
    public Word (String inword) {
        word_count = 0;
        line_track = new ObjectList();
        this.inword = inword;
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
     * Adds a LinePosition object to the ObjectList.
     */
    public void addWord(LinePosition linepos) {
        line_track.insert(linepos);
    }
}
