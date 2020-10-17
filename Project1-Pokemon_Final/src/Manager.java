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

/**
 * This interface possesses lots of signatures of methods which are used to sort the pokemon based
 * on their attributes and to be the base code of front end developing.
 *
 * @author Minghao Zhou, Liangqi Cai, Tianwei Bao, Seungjun Chong, Zhiwei Cao, Jiahe Jin, Yunzhao Liu
 * @version 1.0
 */
public interface Manager {


    public LinkedList<Pokemon> sortByName(boolean order);


    public LinkedList<Pokemon> sortByType(String type);


    public LinkedList<Pokemon> sortByLegendary(boolean legendary);


    public LinkedList<Pokemon> sortByFavorite(boolean favorite);


    public LinkedList<Pokemon> sortByHp(boolean order);


    public LinkedList<Pokemon> sortByAttack(boolean order);


    public LinkedList<Pokemon> sortByDefense(boolean order);


    public LinkedList<Pokemon> sortBySpAttack(boolean order);


    public LinkedList<Pokemon> sortBySpDefense(boolean order);


    public LinkedList<Pokemon> sortBySpeed(boolean order);


    public LinkedList<Pokemon> sortByTotal(boolean order);

}
