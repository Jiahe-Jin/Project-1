// --== CS400 File Header Information ==--
// Name: Jiahe Jin
// Email: jjin82wisc.edu
// Team: JB
// Role: Front End Developer
// TA: Harper
// Lecturer: Florian Heimerl
// Notes to Grader: My responsible part is the [Launch.java]. The signatures of MapADT being
// implemented in [HashTableMap.java] come from my own hashtable methods which has been written
// in the last week. Also, Manager Interface is implemented in the PokemonTable class to give it
// specific signatures which should be implemented in. Remember to use [g] command after click
// [Enter] to open the guidebook where you can find more operations, introductions, and instructions
// regarded to our project "Pokédex". Hope to enjoy our App!
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * The class is the hash table which has been implemented with the MapADT interface
 * and will utilize or be utilized by other classes like HashNode.java, and
 * TestHashTable.java.
 */
public class HashTableMap implements MapADT {

    private int capacity; // The number of spaces in the collection.
    private int size; // The current number of key-value pairs stored in the collection.
    private LinkedList[] bucketArray; // The array used to store key-value pairs.

    /**
     * The default constructor sets the capacity of of hashtable as 10;
     * the size as 0, and all items in the bucketArray are empty linked list.
     */
    public HashTableMap() {
        this.capacity = 10;
        this.size = 0;
        this.bucketArray = new LinkedList[10];
        for (int i = 0; i < capacity; i++) {
            this.bucketArray[i] = new LinkedList(); // set each seat of bucketArray is a linked list
        }
    }

    /**
     * The second constructor sets the capacity of of hashtable as
     * what the users expected to set; the size as 0, and all items
     * in the bucketArray are empty linked list.
     */
    public HashTableMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.bucketArray = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            this.bucketArray[i] = new LinkedList();
        }
    }

    /**
     * The getCapacity() method helps to check the current capacity of our hashtable.
     *
     * @return the current capacity of the hash table.
     */
    public int getCapacity() {
        return this.capacity;
    }


    /**
     * The private rehashing() method is a helper method which intends to check if the load factor
     * is attained. If it is accomplished that load capacity is greater or equal to 80%, starting it.
     */
    private void rehashing() {
        if ((float) size / (float) capacity >= 0.8) { // if the load factor is >= 0.8
            this.capacity = capacity * 2; // double the capacity.
            LinkedList[] Template = new LinkedList[capacity]; // Make a template double bucket
            for (int i = 0; i < this.capacity; i++) {
                Template[i] = new LinkedList(); // set a linked list as an object into each position
            }
            for (int i = 0; i < this.bucketArray.length; i++) {
                if (this.bucketArray[i] != null) { // if the position has items
                    for (int j = 0; j < this.bucketArray[i].size(); j++) {
                        HashNode node = (HashNode) this.bucketArray[i].get(j); // get key-value pair
                        Template[this.hashKey(node.getKey())].add(node); //hashKey by new capacity
                    }
                } else { // if the position does NOT have items
                    continue;
                }
            }
            this.bucketArray = Template; // set the Template to bucketArray
        }
        // Otherwise, nothing happened.
    }

    /**
     * The hashKey(Object key) is the helper method trying to get the hashed key by the absolute
     * key.hashcode() mod capacity.
     *
     * @param key the KeyType user entered.
     * @return the index of hashtable.
     */
    private int hashKey(Object key) {
        return Math.abs(key.hashCode()) % capacity; //get the hashed key
    }

    /**
     * The put method comes to store a key-value pair in our hashtable, at the index corresponding
     * to hashed key. When the key is passed which is already existed in hashtable, we will use
     * equal method. When the added item makes arrayBucket attains the load capacity, we will take
     * rehashing method to double the capacity of the hash table.
     *
     * @param key   the KeyType user entered.
     * @param value the ValueType user wanted to store in.
     * @return true after successfully storing a new key-value pair; false
     * without making any changes to the hash table.
     */
    @Override public boolean put(Object key, Object value) {
        int hashIndex = this.hashKey(key); //get the hashed index
        HashNode node = new HashNode(key, value); // create the key-value pair
        if (!this.containsKey(key)) { // if the hashtable does NOT have the key
            this.bucketArray[hashIndex].add(node); // adding the created node of key-value pair
            this.size++; // increase the size
            this.rehashing(); // check or perform rehashing once load capacity is attained
            return true; // successfully added
        }
        return false; // Without any changes
    }

    /**
     * The get(Object key) method intends to get the value of key-value pair of items based on
     * the KeyType key.
     *
     * @param key the KeyType user entered.
     * @return the value contained in key-value pair based on key.
     * @throws NoSuchElementException when no items of corresponded key found.
     */
    @Override public Object get(Object key) throws NoSuchElementException {
        int hashIndex = this.hashKey(key); //get the hashed index
        if (!this.containsKey(key)) { // if the hash table does not contain the key
            throw new NoSuchElementException( // throw the Exception
                "Sorry, we can not find an item stored with the corresponded key!");
        } else { // if the hash table contains the key
            for (int i = 0; i < bucketArray[hashIndex].size(); i++) { // looping the position
                HashNode node = (HashNode) bucketArray[hashIndex].get(i); // get the node of each
                if (node.getKey().equals(key)) { // if keys entered are same
                    return node.getValue(); // return the value
                }
            }
        }
        return null;
    }

    /**
     * The size() method intends to get the the number of key-value pairs stored in this collection.
     *
     * @return the the number of key-value pairs stored in this collection.
     */
    @Override public int size() {
        return size;
    }

    /**
     * The containsKey(Object key) method intends to find if the key that is already in the hash
     * table.
     *
     * @param key the the KeyType user entered.
     * @return true if the method find the key that is already in the hash table, false if the the
     * method find the key that is not in the hash table yet.
     */
    @Override public boolean containsKey(Object key) {
        int hashIndex = this.hashKey(key); //get the hashed index
        if (bucketArray[hashIndex] != null) { // to see if the hashIndex position is occupied
            for (int i = 0; i < bucketArray[hashIndex].size(); i++) { //if not, start looping
                HashNode node = (HashNode) bucketArray[hashIndex].get(i); // get the node of each
                if (node.getKey().equals(key)) { // if keys are equal
                    return true;
                } else { // if keys are NOT equal
                    continue;
                }
            }
        }
        return false; // the key is not contained.
    }

    /**
     * The remove(Object key) method intends to remove the value of the reference (HashNode)
     * to the key-value pair which will be return. When the key does not exited, we need to
     * return the null.
     *
     * @param key the KeyType user entered.
     * @return the value of the hashNode that is removed; or null if the key doesn't exited.
     */
    @Override public Object remove(Object key) {
        if (this.containsKey(key)) { // see if key is existed.
            int hashIndex = this.hashKey(key); //get the hashed index
            for (int i = 0; i < this.bucketArray[hashIndex].size(); i++) { // looping position
                HashNode node = (HashNode) this.bucketArray[hashIndex].get(i); // get the node
                if (node.getKey().equals(key)) { // see if node is corresponded to the key
                    Object removedValue = node.getValue(); // set a removed item
                    this.bucketArray[hashIndex].remove(i); // remove the item
                    this.size--; //decrease the size
                    return removedValue;
                }
            }
            return null;
        } else { // if it is not existed
            return null;
        }

    }

    /**
     * The clear() method intends to remove all key-value pairs in the collection
     */
    @Override public void clear() {
        LinkedList[] Template = new LinkedList[capacity];
        for (int i = 0; i < this.capacity; i++) {
            Template[i] = new LinkedList(); // set the LinkedList into an array
        }
        this.size = 0; // set the size back to 0
        this.bucketArray = Template; // set the bucketArray as the new empty Template
    }


    /**
     * This extra method intends to give out the LinkedList[] bucketArray
     *
     * @return the LinkedList[] bucketArray
     */
    public LinkedList[] getTable() {
        return this.bucketArray;
    }


}
