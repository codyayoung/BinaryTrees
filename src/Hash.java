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
    Chain new_chain;                        //ObjectListNode holding String and hash value


    /**
     * Constructor for Hash objects. Creates an array of Object linked lists.
     */
    public Hash() {
        hashtable = new ObjectList[TABLESIZE];      //Initialize hash table
        for(int i = 0; i < TABLESIZE; i++) {
            hashtable[i] = new ObjectList();
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
        }
        return value = value % TABLESIZE;
    }

    /**
     * Hashes string and checks if value exists in hash table.
     * If it does, inserts key and value into hash table.
     */
    public void cookHash(String s) {
        int j = getHash(s);     //Create hash value - currently bugged, assigns it nothing

        for(int i = 0; i < TABLESIZE; i++) {
            new_chain = new Chain(s, j); //Create new node with string and hash value
            hashtable[i].insert(new_chain);     //Insert node into linked list
        }
    }
}
