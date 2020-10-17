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
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class intends to create the unit hash table for Pokemon Object being confirmed as favorite
 * state. [Note: this class does not apply the HashTableMap.class, because myFavorite is independent
 * to the our main HashTable. Thus, we do not need to apply our different HashTableMap.classes.]
 *
 * @author Minghao Zhou, Liangqi Cai, Tianwei Bao, Seungjun Chong, Zhiwei Cao, Jiahe Jin, Yunzhao Liu
 * @version 1.0
 */
public class MyFavorite implements MapADT {
    private LinkedList<HashNode>[] hashTable;
    private int size;
    private int capacity;

    /**
     * The default constructor is used to set up the basic condition for MyFavorite hash table.
     * Set the size as zero, the capacity as ten, and make a new hashTable.
     */
    public MyFavorite() {
        this.size = 0;
        this.capacity = 10;
        this.hashTable = new LinkedList[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            hashTable[i] = new LinkedList<HashNode>();
        }
    }

    public MyFavorite(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.hashTable = new LinkedList[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            hashTable[i] = new LinkedList<HashNode>();
        }
    }

    /**
     * The private rehashing() method is a helper method which intends to check if the load factor
     * is attained. If it is accomplished that load capacity is greater or equal to 80%, starting it.
     */
    private void rehashing() {
        if ((float) size / (float) capacity >= 0.8) { // if the load factor is >= 0.8
            this.capacity = capacity * 2; // double the capacity.
            LinkedList[] Template = new LinkedList[capacity]; // Make a template double hash table
            for (int i = 0; i < this.capacity; i++) {
                Template[i] = new LinkedList(); // set a linked list as an object into each position
            }
            for (int i = 0; i < this.hashTable.length; i++) {
                if (this.hashTable[i] != null) { // if the position has items
                    for (int j = 0; j < this.hashTable[i].size(); j++) {
                        HashNode node = (HashNode) this.hashTable[i].get(j); // get key-value pair
                        Template[this.hashKey(node.getKey())].add(node); //hashKey by new capacity
                    }
                } else { // if the position does NOT have items
                    continue;
                }
            }
            this.hashTable = Template; // set the Template to hash table
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
     * This method intends to put the Pokemon into the MyFavorite hashtable with its name as the key, at the
     * index corresponding to the hashed key by the .getHashKey() method. Before adding the Pokemon,
     * we need to check if the name of pokemon has already existed by using .containsKey() method.
     * When the added pokemon makes the hashtable attains its load capacity (equal or larger than 0.75), we need to
     * rehash the table and double its capacity. Remember, the size is the number of pokemon being
     * added, and it is recommended to use the private rehashing method to help double the hash table's
     * capacity.
     *
     * @param name    the name of the Pokemon as the key
     * @param pokemon the Pokemon class Object as the value
     * @return true if we successfully add the pokemon in our table, and false if the table does
     * not change.
     */
    @Override public boolean put(Object name, Object pokemon) {
        int hashIndex = this.hashKey(name); //get the hashed index
        HashNode node = new HashNode(name, pokemon); // create the name-Pokemon pair
        if (!this.containsKey(name)) { // if the hashtable does NOT have the key
            this.hashTable[hashIndex].add(node); // adding the created node of name-Pokemon pair
            ((Pokemon) pokemon).setFavorite(true); // set the Pokemon for Favorite
            this.size++; // increase the size
            this.rehashing(); // check or perform rehashing once load capacity is attained
            return true; // successfully added
        }
        return false; // Without any changes
    }

    /**
     * This method intends to get the Pokemon Object by entering the name of the pokemon.
     *
     * @param name the name of the Pokemon as the key
     * @return the Pokemon Object by entering the name of the Pokemon
     * @throws NoSuchElementException when no pokemon of corresponded name was found.
     */
    @Override public Pokemon get(Object name) throws NoSuchElementException {
        int hashIndex = this.hashKey(name); //get the hashed index
        if (!this.containsKey(name)) { // if the hash table does not contain the name
            throw new NoSuchElementException( // throw the Exception
                "Sorry, we can not find an item stored with the corresponded key!");
        } else { // if the hash table contains the name
            for (int i = 0; i < hashTable[hashIndex].size(); i++) { // looping the position
                HashNode<String, Pokemon> node =
                    (HashNode) hashTable[hashIndex].get(i); // get the node of each
                if (node.getKey().equals(name)) { // if names entered are same
                    return node.getValue(); // return the Pokemon Object
                }
            }
        }
        return null;
    }

    /**
     * This method intends to get the current size of the MyFavorite hashtable.
     *
     * @return the current size of the table
     */
    @Override public int size() {
        return this.size;
    }

    /**
     * This method intends to find if the pokemon that is already in the MyFavorite hashtable.
     *
     * @param name the name of the Pokemon as the key
     * @return true if the method find the pokemon's name that is already in the hash table, and
     * false if the pokemon's name that is not in the hash table.
     */
    @Override public boolean containsKey(Object name) {
        int hashIndex = this.hashKey(name); //get the hashed index
        if (hashTable[hashIndex] != null) { // to see if the hashIndex position is occupied
            for (int i = 0; i < hashTable[hashIndex].size(); i++) { //if not, start looping
                HashNode<String, Pokemon> node =
                    (HashNode) hashTable[hashIndex].get(i); // get the node of each
                if (node.getKey().equals(name)) { // if names are equal
                    return true;
                } else { // if names are NOT equal
                    continue;
                }
            }
        }
        return false; // the key is not contained.
    }

    /**
     * This method intends to remove the pokemon in the MyFavorite hashtable by calling its name.
     *
     * @param name the name of the Pokemon as the key
     * @return the Pokemon Object being removed from the table, and null if nothing is removed.
     */
    @Override public Pokemon remove(Object name) {
        if (this.containsKey(name)) { // see if key is existed.
            int hashIndex = this.hashKey(name); //get the hashed index
            for (int i = 0; i < this.hashTable[hashIndex].size(); i++) { // looping position
                HashNode<String, Pokemon> node =
                    (HashNode) this.hashTable[hashIndex].get(i); // get the node
                if (node.getKey().equals(name)) { // see if node is corresponded to the key
                    Pokemon removedValue = node.getValue(); // set a removed item
                    this.hashTable[hashIndex].remove(i); // remove the item
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
     * This method intends to remove all pokemon from the MyFavorite hashtable, and remember that the size
     * should change back to zero after we set the hashtable become empty.
     */
    @Override public void clear() {
        this.size = 0;
        for (int i = 0; i < this.size; i++) {
            hashTable[i] = null;
        }
    }

    /**
     * This method intends to get all pokemon in the MyFavorite hashtable without specific requirement on its
     * order, so that we can just loop the whole hashtable, and add Pokemon Object in the new template
     * LinkedList which will then be output.
     *
     * @return the LinkedList of Pokemon Objects in the MyFavorite hashtable.
     */
    public LinkedList<Pokemon> getAll() {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        for (LinkedList<HashNode> pokemonList : hashTable) {
            if (pokemonList.size() != 0) {
                for (HashNode<String, Pokemon> pokemon : pokemonList) {
                    collection.add(pokemon.getValue());
                }
            }
        }
        return collection;
    }


}

