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


/**
 * The HashNode class is come to put key and value together as a whole unit which will be added in
 * the LinkedList of the hashtable.
 */
public class HashNode<KeyType, ValueType> {
    private KeyType key;
    private ValueType value;

    /**
     * The constructor used to set key and value by users
     *
     * @param key   the user entered KeyType key
     * @param value the user entered ValueType value
     */
    public HashNode(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    /**
     * The getter method used to get the key
     *
     * @return the key user entered KeyType
     */
    public KeyType getKey() {
        return this.key;
    }

    /**
     * The getter method used to get the value
     *
     * @return the value user entered ValueType
     */
    public ValueType getValue() {
        return this.value;
    }

    /**
     * The setter method used to set the key
     *
     * @param key the user entered KeyType key
     */
    public void setKey(KeyType key) {
        this.key = key;
    }

    /**
     * The setter method used to set the value
     *
     * @param value the user entered ValueType value
     */
    public void setValue(ValueType value) {
        this.value = value;
    }


}
