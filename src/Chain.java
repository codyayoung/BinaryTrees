/**
 * Creates Chain objects, which are inserted into a hash table's linked list.
 * Stores key and value pairs.
 */
public class Chain implements Comparable {
    //Instance variables
    private String instring;        //Word from omit file
    private int value;              //Hash value

    /**
     * Overloaded constructor method for Chain objects. Initializes instance variables.
     */
    public Chain(String instring, int value) {
        this.instring = instring;
        this.value = value;
    }

    public String getInstring() {
        return instring;
    }

    public void setInstring(String instring) {
        this.instring = instring;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int compareTo(Object o) {
       return 1;
    }
}
