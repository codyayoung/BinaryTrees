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
    private float avg_len = 0;                  //Average length of linked list
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
        value = 0;
        for(int i = 0; i < s.length(); i++) {
            value = (value << 7) + s.charAt(i);      //Left shfit for each character in string 
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
            ObjectList newChain = new ObjectList();
            newChain.insert(chain);
            hashtable[i] = newChain;
        }
        else {
            ObjectList oldChain = hashtable[i];
            collisions++;
            len++;
            oldChain.addLast(chain);
            hashtable[i] = oldChain;
        }
    }

    /**
     * Outputs hash table.
     */
    public void outputHash() {
        System.out.print('\n');
        System.out.println("HASH TABLE");
        System.out.println("-----------");
        System.out.printf("%-10s %15s\n", "Index", "Key\n");
        for(int i = 0; i < hashtable.length; i++) {
            if(hashtable[i] == null) {
                continue;
            }
            else {
                ObjectList pablochain = hashtable[i];
                ObjectListNode kim = pablochain.getFirstNode();
                while(kim != null) {
                    Word north = (Word)kim.getInfo();
                    System.out.printf("%-10d %15s\n", north.getKey(), north.getInword());
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
    public boolean containsHash(String s) {
        int i = getHash(s);      //Get hash value
        ObjectList yeezychain = hashtable[i];    //Check list at index value
        if(yeezychain == null)
            return false;
        Word kanye = new Word(s, i);
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

    public float getAvg_len() {
        return avg_len;
    }

    public void setAvg_len(float avg_len) {
        this.avg_len = avg_len;
    }
}
