import java.io.IOException;
import java.io.PrintWriter;

/**
 * In house hash function for input strings.
 * Hashes strings, places key-value pairs in tables, and performs lookups.
 * Implements separate chaining for collision resolutions.
 * @author Cody Young
 * @version 5/19/17
 */
public class Hash {
    //Instance variables and constants
    final private int TABLESIZE = 37;   //Size of table
    private int collisions = 0;                 //Number of collisions
    private int value = 0;
    private int len = 0;                        //Length of linked list - number of nodes
    private int maxlen = 0;                     //Maximum length of linked list - total number of nodes
    private double avg_len;                     //Average length of linked list
    private double chains = 0;
    private float num_keys = 0;                 //Number of elements in hash table
    private ObjectList[] hashtable;             //Hash table - an array of linked lists
    private ObjectList nodechain;
    private Word chain;                         //Key to hash
    private PrintWriter foutput;

    /**
     * Constructor for Hash objects. Creates an array of Object linked lists.
     */
    public Hash(PrintWriter foutput) throws IOException {
        hashtable = new ObjectList[TABLESIZE];      //Initialize hash table
        nodechain = new ObjectList();
        for(int i = 0; i < TABLESIZE; i++) {
            hashtable[i] = null;
        }
         this.foutput = foutput;
        //foutput = new PrintWriter(new FileWriter("csis.txt"));
    }

    /**
     * Hash function for input string.
     * @param s String to hash
     * @return Index value as int
     */
    private int getHash(String s) {
        value = 0;
        for(int i = 0; i < s.length(); i++) {
            value = (value << 7) + s.charAt(i);      //Left shift for each character in string
        }
        return Math.abs(value % TABLESIZE);
    }

    /**
     * Hashes string and checks if value exists in hash table.
     * If it does, inserts key and value into hash table.
     */
    public void cookHash(String s) throws IOException {
        int i = getHash(s);     //Create hash value
        chain = new Word(s, i, foutput);         //Create new Word object with input string and hash value
        if(hashtable[i] == null) {
            ObjectList newChain = new ObjectList();
            newChain.insert(chain);
            hashtable[i] = newChain;
            chains++;                  //Increment number of linked lists
            num_keys++;                //Increment overall number of elements in hash table
        }
        else {
            ObjectList oldChain = hashtable[i];
            collisions++;           //Increment collisions
            len++;                  //Increment length of chain
            num_keys++;
            oldChain.insert(chain);
            hashtable[i] = oldChain;
        }
        if(len > maxlen) {                   //Longest chain value
            maxlen = len;
        }
          avg_len = num_keys / chains;      //Calculate average chain size
    }

    /**
     * Outputs hash table. Prints index and key.
     */
    public void outputHash() {
        System.out.print('\n');
        foutput.print('\n');
        System.out.println("HASH TABLE");
        foutput.println("HASH TABLE");
        System.out.println("----------");
        foutput.println("----------");
        System.out.printf("%-10s %15s\n", "Index", "Key\n");
        foutput.printf("%-10s %15s\n", "Index", "Key\n");
        for(int i = 0; i < hashtable.length; i++) {
            if(hashtable[i] == null) {
                continue;
            }
            else {
                ObjectList pablochain = hashtable[i];
                ObjectListNode kim = pablochain.getFirstNode();
                while(kim != null) {
                    Word north = (Word)kim.getInfo();
                    System.out.printf("%-10d%15s\n", north.getKey(), north.getInword());
                    foutput.printf("%-10d%15s\n", north.getKey(), north.getInword());
                    kim = kim.getNext();
                }
            }
        }
    }

    /**
     * Look up method for hash table.
     * @param s String to look up
     * @return True if found, false if not
     */
    public boolean containsHash(String s) throws IOException {
        int i = getHash(s);      //Get hash value
        ObjectList yeezychain = hashtable[i];    //Check list at index value
        if(yeezychain == null)
            return false;
        Word kanye = new Word(s, i, foutput);
        return yeezychain.contains(kanye);
    }

    /**
     * Gets total number of collisions after hashing.
     * @return Number of collisions
     */
    public int getCollisions() {
        return collisions;
    }


    /**
     * Gets average chain length of the linked lists in the hash table.
     * @return
     */
    public double getAvg_len() {
        return avg_len;
    }

    /**
     * Gets the longest linked list in the table.
     * @return Length of longest list
     */
    public int getMaxlen() {
        return maxlen;
    }
}
