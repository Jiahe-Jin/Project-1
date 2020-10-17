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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class intends to download and organize the data set of Pokemon
 *
 * @author Minghao Zhou, Liangqi Cai, Tianwei Bao, Seungjun Chong, Zhiwei Cao, Jiahe Jin, Yunzhao Liu
 * @version 1.0
 */
public class Data {

    private Pokemon[] pokemonList;
    private static String[] line;

    /**
     * The default constructor will set the new empty pokemonList.
     */
    public Data() {
        this.pokemonList = new Pokemon[799];
    }

    /**
     * It will load data set from the csv file, organize each line of them into the Pokemon Object,
     * and then put all Pokemon Object in the pokemonList.
     *
     * @throws IOException for the FileReader and readLine
     */
    public void update() throws IOException {
        BufferedReader content = new BufferedReader(new FileReader("PokemonList.csv"));
        String reader = "";
        int index = 0;
        while ((reader = content.readLine()) != null) {
            line = reader.split(",");
            String name = line[0];
            String type1 = line[1];
            String type2 = line[2];
            int total = Integer.parseInt(line[3]);
            int hp = Integer.parseInt(line[4]);
            int attack = Integer.parseInt(line[5]);
            int defense = Integer.parseInt(line[6]);
            int spAttack = Integer.parseInt(line[7]);
            int spDefense = Integer.parseInt(line[8]);
            int speed = Integer.parseInt(line[9]);
            boolean legendary = Boolean.parseBoolean(line[11]);
            boolean favorite = false;
            Pokemon current =
                new Pokemon(name, type1, type2, hp, attack, defense, spAttack, spDefense, speed,
                    total, legendary, favorite);
            pokemonList[index] = current;
            index++;
        }
        content.close();
    }

    /**
     * This method comes to get the Pokemon within the array by entering the index of the pokemon.
     * It is generally used to do the test
     *
     * @param index the specific index of the pokemon hope to get
     * @return the pokemon object
     */
    public Pokemon get(int index) {
        Pokemon something = pokemonList[index];
        return something;
    }

    /**
     * The accessor method of acquiring the list of pokemon
     *
     * @return the list of pokemon
     * @throws IOException for the FileReader and readLine
     */
    public Pokemon[] getPokemonList() throws IOException {
        return pokemonList;
    }
}
