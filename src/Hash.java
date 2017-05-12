import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * In house hash function to hash input string.
 * Hashes strings, places key-value pairs in tables, and performs lookups.
 * @author Cody Young
 * @version 5/19/17
 */
public class Hash {
    //Instance variables and constants
    final private int TABLESIZE = 37;   //Size of table
    private ObjectList chain;           //List for collision resolution - if collision found, insert into linked list
    int collisions = 0;
    int chainsize = 0;
    int[] hashtable;

    /**
     * Constructor for Hash objects. Initializes instance variables.
     */
    public Hash() {
        chain = new ObjectList();
        hashtable = new int[TABLESIZE];
    }

    /**
     * Hash function for input string.
     * @param s String to hash
     * @return Index value as int
     */
    private int getHash(String s) {
        return 0;       //Placeholder return statement
    }

    //Read words from omitfile.txt
    //Use hash function to create values
    //Store keys in table
    //In xref, check each word for hash value
    //If word exists in hash value, skip
    //Else, place in binary tree as usual
}
