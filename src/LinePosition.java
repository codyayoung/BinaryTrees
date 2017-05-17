/**
 * Creates LinePosition objects to keep track of line numbers
 * and current positions of words from input file.
 * @author Cody Young
 * @version 5/19/17
 */
public class LinePosition implements Comparable{
    //Instance variables
    private int line_no;
    private int word_pos;

    /**
     * compareTo override for comparing LinePosition objects
     * @param o LinePosition object to compare.
     * @return 1 if value compared is greater than next value inserted.
     */
    public int compareTo(Object o) {
        return 1;
    }

    /**
     * Constructor method for LinePosition objects. Initializes instance variables.
     */
    public LinePosition(int line_no, int word_pos) {
        this.line_no = line_no;
        this.word_pos = word_pos;
    }

    /**
     * Gets line number of word.
     * @return Line number of word
     */
    public int getLine_no() {
        return line_no;
    }
                                                                        
    /**
     * Sets line number of word.
     * @param line_no Line number
     */
    public void setLine_no(int line_no) {
        this.line_no = line_no;
    }

    /**
     * Gets position of word in line.
     * @return Word position in line
     */
    public int getWord_pos() {
        return word_pos;
    }

    /**
     * Sets word position in line.
     * @param word_pos Word position in line
     */
    public void setWord_pos(int word_pos) {
        this.word_pos = word_pos;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(line_no);
       sb.append("-");
       sb.append(word_pos);

       return sb.toString();
    }
}
