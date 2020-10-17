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
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class intends to hash the organized data into its own hash table and install some basic
 * operations to allow the table adjustments which will be the important prerequisites for the front
 * end developing. To get more abundant operations, the Manager interface is implemented.
 *
 * @author Tianwei Bao, Seungjun Chong, Minghao Zhou, Liangqi Cai, Zhiwei Cao, Jiahe Jin, Yunzhao Liu
 * @version 1.0
 */
public class PokemonTable implements MapADT, Manager {
    HashTableMap basedTable; // create the based table from each member's HashTableMap

    /**
     * The default constructor intends to load all contents from getPokemonList() method of Data class
     * into its own hashTable with appropriate hashed index. For this reason, this method will come to
     * use other methods being built in this class.
     *
     * @throws IOException for getPokemonList() method
     */
    public PokemonTable() throws IOException {
        Data collection = new Data(); // create the data import object
        collection.update(); // Loading data
        basedTable =
            new HashTableMap(); // Instantiate team members' HashTableMap (different with others)
        for (Pokemon pokemon : collection.getPokemonList()) {
            basedTable
                .put(pokemon.getName(), pokemon); // put each pokemon from data into hash table
        }
    }

    /**
     * used to create a new hashTable with designated capacity
     *
     * @param capacity the capacity of the hashTable
     */
    public PokemonTable(int capacity) {
        basedTable = new HashTableMap();
        basedTable = new HashTableMap(capacity);
    }


    /**
     * This method intends to give out the all types documented in the Pokemon
     */
    public void getTypes() {
        LinkedList<String> types = new LinkedList<String>();
        for (LinkedList pokemonList : basedTable.getTable()) {
            if (pokemonList.size() != 0) {
                for (int i = 0; i < pokemonList.size(); i++) {
                    String type1 =
                        ((HashNode<String, Pokemon>) pokemonList.get(i)).getValue().getType1();
                    if (!types.contains(type1)) {
                        types.add(type1);
                    }
                    String type2 =
                        ((HashNode<String, Pokemon>) pokemonList.get(i)).getValue().getType2();
                    if (!types.contains(type2) && !type2.equalsIgnoreCase("Not Documented Yet!")) {
                        types.add(type2);
                    }
                }
            }
        }
        int count = 0;
        for (String type : types) {
            if (count == 6) {
                System.out.println("     ");
            }
            if (count == 12) {
                System.out.println("     ");
            }
            System.out.print("[" + type + "]" + " ");
            count++;
        }
    }


    /**
     * This method intends to get all pokemon in the hashtable without specific requirement on its
     * order, so that we can just loop the whole hashtable, and add Pokemon Object in the new template
     * LinkedList which will then be output.
     *
     * @return the array of Pokemon Objects in the hashtable.
     */
    public LinkedList<Pokemon> getAll() {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
            if (pokemonList.size() != 0) {
                for (HashNode<String, Pokemon> node : pokemonList) {
                    collection.add(node.getValue());
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList with the required alphabetic
     * order based on its name.
     *
     * @param order the ascending(true) or descending(false) alphabetic order
     * @return the ascending alphabetic order array of Pokemon Object based on their name , or
     * descending alphabetic order array of Pokemon Object based on their name.
     */
    @Override public LinkedList<Pokemon> sortByName(boolean order) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        LinkedList<String> names = new LinkedList<String>();
        for (LinkedList<HashNode> pokemonList : basedTable
            .getTable()) { // copy the names from hashTable to names,
            // about to be sorted
            if (pokemonList != null) {
                for (HashNode<String, Pokemon> pokemon : pokemonList) {
                    names.add(
                        pokemon.getKey()); // names.add(pokemon.getPokemon().getName) also works
                }
            }
        }
        if (order == true) { // in ascending order
            Collections.sort(names);
        } else { // in descending order
            Collections.sort(names, Collections.reverseOrder());
        }

        for (String name : names) {
            for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
                if (pokemonList != null) {
                    for (HashNode<String, Pokemon> node : pokemonList) {
                        if (node != null && node.getKey().equalsIgnoreCase(name) && !collection
                            .contains(
                                node.getValue())) { // pokemon.getPokemon.getName().equals(name) also works
                            collection.add(node.getValue());
                        }
                    }
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList based on their type. Note,
     * because we have two types for each pokemon, we are recommended to use OR to deal with it.
     *
     * @param type the type of pokemon
     * @return the LinkedList of Pokemon Object based on their type. If the type of pokemon is equal
     * to the assigned type, they will be put in the another LinkedList which will then be
     * output.
     */
    @Override public LinkedList<Pokemon> sortByType(String type) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
            if (pokemonList != null) {
                for (HashNode<String, Pokemon> node : pokemonList) {
                    if (node.getValue().getType1().equalsIgnoreCase(type)
                        || node.getValue().getType2().equalsIgnoreCase(type) && !collection
                        .contains(node.getValue())) {
                        collection.add(node.getValue());
                    }
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList based on their legendary state.
     *
     * @param legendary the legendary state of pokemon is
     * @return the LinkedList of Pokemon Object based on their legendary state. If they are (true),
     * they will be put in the another LinkedList which will then be output.
     */
    @Override public LinkedList<Pokemon> sortByLegendary(boolean legendary) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
            if (pokemonList != null) {
                for (HashNode<String, Pokemon> node : pokemonList) {
                    if (node.getValue().isLegendary() == legendary && !collection
                        .contains(node.getValue())) {
                        collection.add(node.getValue());
                    }
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList based on the favorite state of
     * them.
     *
     * @param favorite the favorite state of pokemon
     * @return the LinkedList of Pokemon Object based on their favorite state. If they are (true),
     * they will be put in the another LinkedList which will then be output.
     */
    @Override public LinkedList<Pokemon> sortByFavorite(boolean favorite) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
            if (pokemonList != null) {
                for (HashNode<String, Pokemon> node : pokemonList) {
                    if (node.getValue().getFavorite() == favorite && !collection
                        .contains(node.getValue())) {
                        collection.add(node.getValue());
                    }
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList based on the size of HP.
     *
     * @param order the descending(true)-larger HP at the front or ascending(false) order-smaller HP
     *              at the front
     * @return the LinkedList of Pokemon Object based on their PH size. If the order is descending,
     * the Pokemon Object with larger size of HP will be put at the front (smaller index); the
     * Pokemon Object with smaller size of HP will be put at the back (larger index). All are
     * in the order.
     */
    @Override public LinkedList<Pokemon> sortByHp(boolean order) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        LinkedList<Integer> HPs = new LinkedList<Integer>();

        for (LinkedList<HashNode> pokemonList : basedTable
            .getTable()) { // copy the HPs of pokemons from hashTable to HPs, about to be sorted
            if (pokemonList != null) {
                for (HashNode<String, Pokemon> pokemon : pokemonList) {
                    HPs.add(pokemon.getValue().getHp());
                }
            }
        }
        if (order == true) { // in descending order
            Collections.sort(HPs, Collections.reverseOrder());
        } else { // in ascending order
            Collections.sort(HPs);
        }
        for (Integer HP : HPs) {
            for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
                if (pokemonList != null) {
                    for (HashNode<String, Pokemon> node : pokemonList) {
                        if (node != null && node.getValue().getHp() == HP && !collection
                            .contains(node.getValue())) {
                            collection.add(node.getValue());
                        }
                    }
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList based on their attack value.
     *
     * @param order the descending(true) or ascending(false) order
     * @return the LinkedList of Pokemon Object based on their attack value. If the order is
     * descending, the Pokemon Object with larger attack value will be put at the front
     * (smaller index); the Pokemon Object with smaller attack value will be put at the back
     * (larger index). All are in the order.
     */
    @Override public LinkedList<Pokemon> sortByAttack(boolean order) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        LinkedList<Integer> ATTACKs = new LinkedList<Integer>();

        for (LinkedList<HashNode> pokemonList : basedTable
            .getTable()) { // copy the ATTACKs of pokemons from hashTable to ATTACKs, about to be sorted
            if (pokemonList != null) {
                for (HashNode<String, Pokemon> pokemon : pokemonList) {
                    ATTACKs.add(pokemon.getValue().getAttack());
                }
            }
        }
        if (order == true) { // in descending order
            Collections.sort(ATTACKs, Collections.reverseOrder());
        } else { // in ascending order
            Collections.sort(ATTACKs);
        }
        for (Integer ATTACK : ATTACKs) {
            for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
                if (pokemonList != null) {
                    for (HashNode<String, Pokemon> node : pokemonList) {
                        if (node != null && node.getValue().getAttack() == ATTACK && !collection
                            .contains(node.getValue())) {
                            collection.add(node.getValue());
                        }
                    }
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList based on their defense value.
     *
     * @param order the descending(true) or ascending(false) order
     * @return the LinkedList of Pokemon Object based on their attack value. If the order is
     * descending, the Pokemon Object with larger defense value will be put at the front
     * (smaller index); the Pokemon Object with smaller defense value will be put at the back
     * (larger index). All are in the order.
     */
    @Override public LinkedList<Pokemon> sortByDefense(boolean order) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        LinkedList<Integer> DEFENSEs = new LinkedList<Integer>();

        for (LinkedList<HashNode> pokemonList : basedTable
            .getTable()) { // copy the DEFENSEs of pokemons from hashTable to DEFENSEs, about to be sorted
            if (pokemonList != null) {
                for (HashNode<String, Pokemon> pokemon : pokemonList) {
                    DEFENSEs.add(pokemon.getValue().getDefense());
                }
            }
        }

        if (order == true) { // in descending order
            Collections.sort(DEFENSEs, Collections.reverseOrder());
        } else { // in ascending order
            Collections.sort(DEFENSEs);
        }
        for (Integer DEFENSE : DEFENSEs) {
            for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
                if (pokemonList != null) {
                    for (HashNode<String, Pokemon> node : pokemonList) {
                        if (node != null && node.getValue().getDefense() == DEFENSE && !collection
                            .contains(node.getValue())) {
                            collection.add(node.getValue());
                        }
                    }
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList based on their Special attack
     * value.
     *
     * @param order the descending(true) or ascending(false) order
     * @return the LinkedList of Pokemon Object based on their special attack value. If the order is
     * descending, the Pokemon Object with larger special attack value will be put at the
     * front (smaller index); the Pokemon Object with smaller special attack value will be put
     * at the back (larger index). All are in the order.
     */
    @Override public LinkedList<Pokemon> sortBySpAttack(boolean order) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        LinkedList<Integer> SpAttacks = new LinkedList<Integer>();

        for (LinkedList<HashNode> pokemonList : basedTable
            .getTable()) { // copy the SpAttacks of pokemons from hashTable to SpAttacks, about to be sorted
            if (pokemonList != null) {
                for (HashNode<String, Pokemon> pokemon : pokemonList) {
                    SpAttacks.add(pokemon.getValue().getSpAttack());
                }
            }
        }

        if (order == true) { // in descending order
            Collections.sort(SpAttacks, Collections.reverseOrder());
        } else { // in ascending order
            Collections.sort(SpAttacks);
        }
        for (Integer SpAttack : SpAttacks) {
            for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
                if (pokemonList != null) {
                    for (HashNode<String, Pokemon> node : pokemonList) {
                        if (node != null && node.getValue().getSpAttack() == SpAttack && !collection
                            .contains(node.getValue())) {
                            collection.add(node.getValue());
                        }
                    }
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList based on their Special defense
     * value.
     *
     * @param order the descending(true) or ascending(false) order
     * @return the array of Pokemon Object based on their special defense value. If the order is
     * descending, the Pokemon Object with larger special defense value will be put at the
     * front (smaller index); the Pokemon Object with smaller special defense value will be
     * put at the back (larger index). All are in the order.
     */
    @Override public LinkedList<Pokemon> sortBySpDefense(boolean order) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        LinkedList<Integer> SpDefenses = new LinkedList<Integer>();

        for (LinkedList<HashNode> pokemons : basedTable
            .getTable()) { // copy the SpDefenses of pokemons from hashTable to SpDefenses, about to be sorted
            if (pokemons != null) {
                for (HashNode<String, Pokemon> pokemon : pokemons) {
                    SpDefenses.add(pokemon.getValue().getSpDefense());
                }
            }
        }

        if (order == true) { // in descending order
            Collections.sort(SpDefenses, Collections.reverseOrder());
        } else { // in ascending order
            Collections.sort(SpDefenses);
        }
        for (Integer SpDefense : SpDefenses) {
            for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
                if (pokemonList != null) {
                    for (HashNode<String, Pokemon> node : pokemonList) {
                        if (node != null && node.getValue().getSpDefense() == SpDefense
                            && !collection.contains(node.getValue())) {
                            collection.add(node.getValue());
                        }
                    }
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList based on their Speed value.
     *
     * @param order the descending(true) or ascending(false) order
     * @return the LinkedList of Pokemon Object based on their speed value. If the order is descending, the
     * Pokemon Object with larger speed value will be put at the front (smaller index); the
     * Pokemon Object with smaller speed value will be put at the back (larger index). All are
     * in the order.
     */
    @Override public LinkedList<Pokemon> sortBySpeed(boolean order) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        LinkedList<Integer> Speeds = new LinkedList<Integer>();

        for (LinkedList<HashNode> pokemonList : basedTable
            .getTable()) { // copy the Speeds of pokemons from hashTable to Speeds, about to be sorted
            if (pokemonList != null) {
                for (HashNode<String, Pokemon> pokemon : pokemonList) {
                    Speeds.add(pokemon.getValue().getSpeed());
                }
            }
        }

        if (order == true) { // in descending order
            Collections.sort(Speeds, Collections.reverseOrder());
        } else { // in ascending order
            Collections.sort(Speeds);
        }
        for (Integer Speed : Speeds) {
            for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
                if (pokemonList != null) {
                    for (HashNode<String, Pokemon> node : pokemonList) {
                        if (node != null && node.getValue().getSpeed() == Speed && !collection
                            .contains(node.getValue())) {
                            collection.add(node.getValue());
                        }
                    }
                }
            }
        }
        return collection;
    }

    /**
     * This method aims to sort the pokemon in the another LinkedList based on their Total value.
     * It will tell us the rank of Pokemon to directly view their Combat Effectiveness.
     *
     * @param order the descending(true) or ascending(false) order
     * @return the LinkedList of Pokemon Object based on their Total value. If the order is descending, the
     * Pokemon Object with larger Total value will be put at the front (smaller index); the
     * Pokemon Object with smaller Total value will be put at the back (larger index). All are
     * in the order.
     */
    @Override public LinkedList<Pokemon> sortByTotal(boolean order) {
        LinkedList<Pokemon> collection = new LinkedList<Pokemon>();
        LinkedList<Integer> Totals = new LinkedList<Integer>();

        for (LinkedList<HashNode> pokemonList : basedTable
            .getTable()) { // copy the Totals of pokemons from hashTable to Totals, about to be sorted
            if (pokemonList != null) {
                for (HashNode<String, Pokemon> pokemon : pokemonList) {
                    Totals.add(pokemon.getValue().getTotal());
                }
            }
        }

        if (order == true) { // in descending order
            Collections.sort(Totals, Collections.reverseOrder());
        } else { // in ascending order
            Collections.sort(Totals);
        }
        for (Integer Total : Totals) {
            for (LinkedList<HashNode> pokemonList : basedTable.getTable()) {
                if (pokemonList != null) {
                    for (HashNode<String, Pokemon> node : pokemonList) {
                        if (node != null && node.getValue().getTotal() == Total && !collection
                            .contains(node.getValue())) {
                            collection.add(node.getValue());
                        }
                    }
                }
            }
        }
        return collection;
    }


    /**
     * This method intends to make changes directly in the HashTableMap.class
     *
     * @param key   the actual name of the Pokemon
     * @param value the actual Pokemon Object for each pokemon
     * @return true if we successfully put the name and Pokemon into the HashTable
     */
    @Override public boolean put(Object key, Object value) {
        return basedTable.put(key, value);
    }

    /**
     * This method intends to link directly to the HashTableMap.class
     *
     * @param key the actual name of the Pokemon
     * @return the Pokemon Object by entering its name
     */
    @Override public Object get(Object key) throws NoSuchElementException {
        return basedTable.get(key);
    }

    /**
     * This method intends to link directly to the HashTableMap.class
     *
     * @return the number of Pokemon currently in the Pokedex.
     */
    @Override public int size() {
        return basedTable.size();
    }

    /**
     * This method intends to link directly to the HashTableMap.class
     *
     * @param key the actual name of the Pokemon
     * @return true if the name of the Pokemon has already being in the Pokemon HashTable, false
     * if the name of the Pokemon has not been added in the Pokemon Hashtable.
     */
    @Override public boolean containsKey(Object key) {
        return basedTable.containsKey(key);
    }

    /**
     * This method intends to make changes directly in the HashTableMap.class
     *
     * @param key the actual name of the Pokemon
     * @return the removed Pokemon Object by entering its name
     */
    @Override public Object remove(Object key) {
        return basedTable.remove(key);
    }

    /**
     * This method intends to make changes directly in the HashTableMap.class
     */
    @Override public void clear() {
        basedTable.clear();
    }
}
