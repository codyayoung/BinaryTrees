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
    int len = 0;                        //Length of chain in linked list
    ObjectList[] hashtable;             //Hash table - an array of linked lists
    ObjectList nodechain;
    Chain chain;                        //ObjectListNode holding String and hash value


    /**
     * Constructor for Hash objects. Creates an array of Object linked lists.
     */
    public Hash() {
        hashtable = new ObjectList[TABLESIZE];      //Initialize hash table
        nodechain = new ObjectList();
        for(int i = 0; i < TABLESIZE; i++) {
            hashtable[i] = nodechain;
        }
    }

    /**
     * Hash function for input string.
     * @param s String to hash
     * @return Index value as int
     */
    private int getHash(String s) {
        for(int i = 0; i < s.length(); i++) {
             value = value * 33 + s.charAt(i);
            //value = ((value << 5)) + s.charAt(i);
        }
        return value % TABLESIZE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Hashes string and checks if value exists in hash table.
     * If it does, inserts key and value into hash table.
     */
    public void cookHash(String s) {
        int j = getHash(s);     //Create hash value
        chain = new Chain(s, j);            //Create chain object
        for (int i = 0; i < hashtable.length; i++) {     //Loop through entire array of linked lists
            hashtable[i] = nodechain;
            nodechain.addFirst(chain);
            //If new hash value from chain already exists in list, insert another node
            if(nodechain.getFirst().equals(chain.getValue())) {
                    hashtable[i].insert(chain);
                    len++;          //Increment length and set it
                    chain.setLength(len);
                    collisions++;   //Increment number of collisions
                    break;
                }
            else {
                hashtable[i].addFirst(chain);
                 }
            }
        }

    /**
     * Gets hash value of input string.
     * @param s Input string from file.
     * @return Hash value
     */
    public int servHash(String s) {
        return getHash(s);
    }

    /**
     * Gets total number of collisions after hashing.
     * @return Number of collisions
     */
    public int getCollisions() {
        return collisions;
    }
}
