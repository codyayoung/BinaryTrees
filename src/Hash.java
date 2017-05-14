import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * In house hash function for input strings.
 * Hashes strings, places key-value pairs in tables, and performs lookups.
 * @author Cody Young
 * @version 5/19/17
 */
public class Hash {
    //Instance variables and constants
    final private int TABLESIZE = 37;   //Size of table
    int collisions = 0;
    int chainsize = 0;
    int value = 0;
    ObjectList[] hashtable;             //Hash table - an array of linked lists
    ObjectList nodechain;               //Name of each linked list in array
    Chain chain;                        //ObjectListNode holding String and hash value


    /**
     * Constructor for Hash objects. Creates an array of Object linked lists.
     */
    public Hash() {
        hashtable = new ObjectList[TABLESIZE];      //Initialize hash table
        nodechain = new ObjectList();
        for(int i = 0; i < TABLESIZE; i++) {
            hashtable[i] = nodechain;               //Fill hash table with linked lists
        }
    }

    /**
     * Hash function for input string.
     * @param s String to hash
     * @return Index value as int
     */
    private int getHash(String s) {
        for(int i = 0; i < s.length(); i++) {
             value = value*33 + s.charAt(i);
            //value = ((value << 5)) + s.charAt(i);
        }
        return value % TABLESIZE;
    }

    /**
     * Hashes string and checks if value exists in hash table.
     * If it does, inserts key and value into hash table.
     */
    public void cookHash(String s) {
        int j = getHash(s);     //Create hash value
        chain = new Chain(s, j);            //Create chain object
        for(int i = 0; i < hashtable.length; i++) {     //Loop through entire array of linked lists
               hashtable[i].insert(chain);
        }
    }
}
