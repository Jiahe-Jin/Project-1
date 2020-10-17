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

public interface MapADT<KeyType, ValueType> {
    public boolean put(KeyType key, ValueType value);

    public ValueType get(KeyType key) throws NoSuchElementException;

    public int size();

    public boolean containsKey(KeyType key);

    public ValueType remove(KeyType key);

    public void clear();
}
