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
    private int collisions = 0;                 //Number of collisions
    private int value = 0;
    private int len = 0;                        //Length of linked list - number of nodes
    private ObjectList[] hashtable;             //Hash table - an array of linked lists
    private ObjectList nodechain;
    private Word chain;                         //Key to hash

    /**
     * Constructor for Hash objects. Creates an array of Object linked lists.
     */
    public Hash() {
        hashtable = new ObjectList[TABLESIZE];      //Initialize hash table
        nodechain = new ObjectList();
        for(int i = 0; i < TABLESIZE; i++) {
            hashtable[i] = null;
        }
    }

    /**
     * Overloaded constructor for Hash objects. Takes hash table of specified size as argument.
     */
    public Hash(ObjectList[] hashtable) {
        hashtable = new ObjectList[TABLESIZE];      //Initialize hash table
        nodechain = new ObjectList();
        for(int i = 0; i < TABLESIZE; i++) {
            hashtable[i] = null;
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
        }
        return Math.abs(value % TABLESIZE);
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
        int i = getHash(s);     //Create hash value
        chain = new Word(s, i);         //Create new Word object with input string and hash value
        if(hashtable[i] == null) {
            nodechain = new ObjectList();
            hashtable[i] = nodechain;
            nodechain.insert(chain);
        }
        else {
            ObjectListNode p = nodechain.getFirstNode();
            while(p != null) {
                Word temp = (Word)p.getInfo();
                p = p.getNext();
                if(temp.getKey() == chain.getKey()) {
                    nodechain.insert(chain);
                }
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

    /**
     * Sets number of collisions after hashing.
     * @param collisions Number of collisions
     */
    public void setCollisions(int collisions) {
        this.collisions = collisions;
    }

    /**
     * Gets length of linked list(bucket) in hash table.
     * @return Length of linked list
     */
    public int getLen() {
        return len;
    }

    /**
     * Sets length of linked list(bucket) in hash table.
     * @param len Length of linked list
     */
    public void setLen(int len) {
        this.len = len;
    }
}
