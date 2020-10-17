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
 * This class intends to contain all attributes of a pokemon which could be the value object
 * being stored in the hashtable.
 *
 * @author Tianwei Bao, Seungjun Chong, Minghao Zhou, Liangqi Cai, Zhiwei Cao, Jiahe Jin, Yunzhao Liu
 * @version 1.0
 */
public class Pokemon {

    private String name;
    private String type1;
    private String type2;
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    private int total;
    private boolean legendary;
    private boolean favorite;


    /**
     * The non-default constructor is used to set the one specific pokemon in this class.
     *
     * @param attack    the int value of Attack the pokemon possesses
     * @param defense   the int value of Defense the pokemon possesses
     * @param hp        the int value of HP the pokemon possesses
     * @param legendary the boolean state of Legendary character the pokemon is
     * @param name      the String name of the pokemon is
     * @param spAttack  the int value of Special Attack the pokemon possesses
     * @param spDefense the int value of Special Defense the pokemon possesses
     * @param speed     the int value of Speed the pokemon possesses
     * @param total     the int value of Total Values the pokemon has by adding all other values
     * @param type1     the String First Type of the pokemon has
     * @param type2     the String Second Type of the pokemon has
     * @param favorite  the favorite state of the pokemon is
     */
    public Pokemon(String name, String type1, String type2, int hp, int attack, int defense,
        int spAttack, int spDefense, int speed, int total, boolean legendary, boolean favorite) {

        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.total = total;
        this.legendary = legendary;
        this.favorite = favorite;
    }

    /**
     * The accessor method of name. Because it might not be documented, we need to consider this
     * situation by adding the if statement.
     *
     * @return the name of the pokemon
     */
    public String getName() {
        if (this.name.equals("")) {
            return "Not Documented Yet!";
        }
        return name;
    }

    /**
     * The accessor method of Type 1. Because it might not be documented, we need to consider this
     * situation by adding the if statement.
     *
     * @return the type1 category of the pokemon
     */
    public String getType1() {
        if (this.type1.equals("")) {
            return "Not Documented Yet!";
        }
        return type1;
    }

    /**
     * The accessor method of Type 2. Because it might not be documented, we need to consider this
     * situation by adding the if statement.
     *
     * @return the type2 category of the pokemon
     */
    public String getType2() {
        if (this.type2.equals("")) {
            return "Not Documented Yet!";
        }
        return type2;
    }

    /**
     * The accessor method of Attack
     *
     * @return the attack value of the pokemon
     */
    public int getAttack() {
        return attack;
    }

    /**
     * The accessor method of Defense
     *
     * @return the defense value of the pokemon
     */
    public int getDefense() {
        return defense;
    }

    /**
     * The accessor method of Special Attack
     *
     * @return the special attack value of the pokemon
     */
    public int getSpAttack() {
        return spAttack;
    }

    /**
     * The accessor method of Special Defense
     *
     * @return the special defense value of the pokemon
     */
    public int getSpDefense() {
        return spDefense;
    }

    /**
     * The accessor method of HP
     *
     * @return the HP of the pokemon
     */
    public int getHp() {
        return hp;
    }

    /**
     * The accessor method of Speed
     *
     * @return the speed value of the pokemon
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * The accessor method of Total Value
     *
     * @return the total value of the pokemon
     */
    public int getTotal() {
        return total;
    }

    /**
     * The accessor method of Legendary
     *
     * @return if the pokemon is legendary
     */
    public boolean isLegendary() {
        return legendary;
    }

    /**
     * The accessor method of favorite
     *
     * @return if the pokemon is favorite
     */
    public boolean getFavorite() {
        return favorite;
    }

    /**
     * This accessor method of getting all attributes in a sentence
     *
     * @return the String of a sentence including all attributes of the pokemon
     */
    public String getAttributes() {
        return " [Type] " + type1 + "\n" + " [Type2] " + type2 + "\n" + " [HP] " + hp + "\n"
            + " [Attack] " + attack + "\n" + " [Defense] " + defense + "\n" + " [Special Attack] "
            + spAttack + "\n" + " [Special Defense] " + spDefense + "\n" + " [Speed] " + speed
            + "\n" + " [Combat Effectiveness] " + total + "\n" + " [Legendary] " + legendary + "\n"
            + " [Favorite] " + favorite;
    }

    /**
     * The mutator method of Name
     *
     * @param name the String name of the pokemon is
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The mutator method of Type 1
     *
     * @param type1 the String First Type of the pokemon has
     */
    public void setType1(String type1) {
        this.type1 = type1;
    }

    /**
     * The mutator method of Type 2
     *
     * @param type2 the String Second Type of the pokemon has
     */
    public void setType2(String type2) {
        this.type2 = type2;
    }

    /**
     * The mutator method of Attack
     *
     * @param attack the attack value of the pokemon
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * The mutator method of Defense
     *
     * @param defense the defense value of the pokemon
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * The mutator method of HP
     *
     * @param hp the HP of the pokemon
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * The mutator method of Special Attack
     *
     * @param spAttack the special attack of the pokemon
     */
    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    /**
     * The mutator method of Special Defense
     *
     * @param spDefense the special defense of the pokemon
     */
    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    /**
     * The mutator method of Speed
     *
     * @param speed the speed of the pokemon has
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * The mutator method of Total Value
     *
     * @param total the total value of the pokemon has
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * The mutator method of Legendary
     *
     * @param legendary the legendary state of the pokemon is
     */
    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }

    /**
     * The mutator method of Legendary
     *
     * @param favorite the favorite state of the pokemon is
     */
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
