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
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;


public class TestSuite {

    static Pokemon[] testList = new Pokemon[6];
    static final int[] indices = {0, 2, 7, 268, 552, 798};
    static MapADT<Object, Pokemon> table;

    // initialize testing data
    static void dataTestInit() {
        // #0
        testList[0] =
            new Pokemon("Bulbasaur", "Grass", "Poison", 45, 49, 49, 65, 65, 45, 318, false, false);
        // #2
        testList[1] =
            new Pokemon("Venusaur", "Grass", "Poison", 80, 82, 83, 100, 100, 80, 525, false, false);
        // #7
        testList[2] =
            new Pokemon("CharizardMega Charizard X", "Fire", "Dragon", 78, 130, 111, 130, 85, 100,
                634, false, false);

        // #268
        testList[3] =
            new Pokemon("Lugia", "Psychic", "Flying", 106, 90, 130, 90, 154, 110, 680, true, false);
        // #552
        testList[4] =
            new Pokemon("Victini", "Psychic", "Fire", 100, 100, 100, 100, 100, 100, 600, true,
                false);
        // #798 the last
        testList[5] =
            new Pokemon("Volcanion", "Fire", "Water", 80, 110, 120, 130, 90, 70, 600, true, false);

    }

    // check wether to pokemon have same information
    static boolean pokemonEq(Pokemon a, Pokemon b) {
        if (a == null || b == null) {
            System.out.println("null error");
            return false;
        }
        String aStr = a.getName();
        String bStr = b.getName();
        if (aStr == null || !aStr.equals(bStr)) {
            System.out.print("name not match: ");
            System.out.print(aStr);
            System.out.println(bStr);
            return false;
        }
        aStr = a.getType1();
        bStr = b.getType1();
        if (aStr == null || !aStr.equals(bStr)) {
            System.out.print("type1 not match: ");
            System.out.print(aStr);
            System.out.println(bStr);
            return false;
        }
        aStr = a.getType2();
        bStr = b.getType2();
        if (aStr == null || !aStr.equals(bStr)) {
            System.out.print("type2 not match: ");
            System.out.print(aStr);
            System.out.println(bStr);
            return false;
        }
        if (a.getHp() != b.getHp()) {
            System.out.println("hp not match");
            return false;
        }
        if (a.getAttack() != b.getAttack()) {
            System.out.println("attack not match");
            return false;
        }
        if (a.getDefense() != b.getDefense()) {
            System.out.println("defense not match");
            return false;
        }
        if (a.getSpAttack() != b.getSpAttack()) {
            System.out.println("SpAttack not match");
            return false;
        }
        if (a.getSpDefense() != b.getSpDefense()) {
            System.out.println("SpDefense not match");
            return false;
        }
        if (a.getSpeed() != b.getSpeed()) {
            System.out.println("speed not match");
            return false;
        }
        if (a.isLegendary() != b.isLegendary()) {
            System.out.println("legendary not match");
            return false;
        }
        return true;
    }

    // test the loading of the data from csv file
    public static boolean testLoading() {
        Data instance = new Data();
        Pokemon[] list;
        try {
            instance.update();
            list = instance.getPokemonList();
            int cnt = 0;
            while (cnt < list.length && list[cnt] != null)
                cnt++;
            if (cnt != 799) {
                System.out.print("Pokemon num incorrect: ");
                System.out.println(cnt - 1);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("fall the test in exception");
            return false;
        }

        for (int i = 0; i < 6; i++) {
            if (!pokemonEq(testList[i], list[indices[i]])) {
                System.out.print("fail the test in check element ");
                System.out.println(i);
                return false;
            }
        }

        return true;
    }

    // test the getter and setter of Pokemom class
    public static boolean testPokemomGetSet() {
        Pokemon inst = new Pokemon("name", "type1", "type2", 2, 3, 4, 5, 6, 7, 8, false, false);
        if (!Objects.equals(inst.getName(), "name") || !Objects.equals(inst.getType1(), "type1")
            || !Objects.equals(inst.getType2(), "type2") || !Objects.equals(inst.getHp(), 2)
            || !Objects.equals(inst.getAttack(), 3) || !Objects.equals(inst.getDefense(), 4)
            || !Objects.equals(inst.getSpAttack(), 5) || !Objects.equals(inst.getSpDefense(), 6)
            || !Objects.equals(inst.getSpeed(), 7) || !Objects.equals(inst.getTotal(), 8)
            || !Objects.equals(inst.isLegendary(), false) || !Objects
            .equals(inst.getFavorite(), false)) {
            return false;
        }
        inst.setName("sName");
        inst.setType1("ttype1");
        inst.setType2("ttype2");
        inst.setHp(11);
        inst.setAttack(10);
        inst.setDefense(33);
        inst.setSpAttack(44);
        inst.setSpDefense(41);
        inst.setSpeed(1);
        inst.setTotal(222);
        inst.setLegendary(true);
        inst.setFavorite(true);
        if (!Objects.equals(inst.getName(), "sName") || !Objects.equals(inst.getType1(), "ttype1")
            || !Objects.equals(inst.getType2(), "ttype2") || !Objects.equals(inst.getHp(), 11)
            || !Objects.equals(inst.getAttack(), 10) || !Objects.equals(inst.getDefense(), 33)
            || !Objects.equals(inst.getSpAttack(), 44) || !Objects.equals(inst.getSpDefense(), 41)
            || !Objects.equals(inst.getSpeed(), 1) || !Objects.equals(inst.getTotal(), 222)
            || !Objects.equals(inst.isLegendary(), true) || !Objects
            .equals(inst.getFavorite(), true)) {
            return false;
        }
        return true;
    }

    public static void loadPokemonTable() {
        try {
            table = new PokemonTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFavorite() {
        table = new MyFavorite();
        for (Pokemon p : testList) {
            table.put(p.getName(), p);
        }
    }

    // test the get method of hashtable
    public static boolean testTableGet() {
        try {
            for (int i = 0; i < 6; i++) {
                if (!pokemonEq(table.get(testList[i].getName()), testList[i]))
                    return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    // test the clean method of hashtable
    public static boolean testTableClear() {
        table.clear();
        if (table.size() != 0)
            return false;
        return true;
    }

    // test the remove method of hashtable
    public static boolean testTableRemove(int size) {
        for (int i = 0; i < 6; i++) {
            if (table.remove(testList[i].getName()) == null)
                return false;
            if (table.size() != size - 1 - i) {
                return false;
            }
            try {
                table.get(testList[i].getName());
            } catch (NoSuchElementException e) {
                continue;
            }
            return false;
        }
        return true;
    }

    // test all the sort method in the PokemonList class
    public static boolean testSort() {
        Manager inst;
        try {
            inst = new PokemonTable();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        LinkedList<Pokemon> list;
        list = inst.sortByAttack(true);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getAttack() < list.get(i).getAttack()) {
                System.out.println("attack sort");
                return false;
            }
        }
        list = inst.sortByAttack(false);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getAttack() > list.get(i).getAttack()) {
                System.out.println("attack sort");
                return false;
            }
        }
        list = inst.sortByDefense(true);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getDefense() < list.get(i).getDefense()) {
                System.out.println("defense sort");
                return false;
            }
        }
        list = inst.sortByDefense(false);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getDefense() > list.get(i).getDefense()) {
                System.out.println("defense sort");
                return false;
            }
        }
        list = inst.sortByFavorite(true);
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i - 1).getFavorite() && list.get(i).getFavorite()) {
                System.out.println("favorite sort");
                return false;
            }
        }
        list = inst.sortByFavorite(false);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getFavorite() && !list.get(i).getFavorite()) {
                System.out.println("favorite sort");
                return false;
            }
        }
        list = inst.sortByHp(true);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getHp() < list.get(i).getHp()) {
                System.out.println("hp sort");
                return false;
            }
        }
        list = inst.sortByHp(false);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getHp() > list.get(i).getHp()) {
                System.out.println("hp sort");
                return false;
            }
        }
        list = inst.sortByLegendary(true);
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i - 1).isLegendary() && list.get(i).isLegendary()) {
                System.out.println("legendary sort");
                return false;
            }
        }
        list = inst.sortByLegendary(false);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).isLegendary() && !list.get(i).isLegendary()) {
                System.out.println("legendary sort");
                return false;
            }
        }
        list = inst.sortByName(true);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getName().compareTo(list.get(i).getName()) > 0) {
                System.out.println("name sort");
                return false;
            }
        }
        list = inst.sortByName(false);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getName().compareTo(list.get(i).getName()) < 0) {
                System.out.println("name sort");
                return false;
            }
        }
        list = inst.sortBySpAttack(true);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getSpAttack() < list.get(i).getSpAttack()) {
                System.out.println("spAttack sort");
                return false;
            }
        }
        list = inst.sortBySpAttack(false);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getSpAttack() > list.get(i).getSpAttack()) {
                System.out.println("spAttack sort");
                return false;
            }
        }
        list = inst.sortBySpDefense(true);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getSpDefense() < list.get(i).getSpDefense()) {
                System.out.println("spDefense sort");
                return false;
            }
        }
        list = inst.sortBySpDefense(false);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getSpDefense() > list.get(i).getSpDefense()) {
                System.out.println("spDefense sort");
                return false;
            }
        }
        list = inst.sortBySpeed(true);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getSpeed() < list.get(i).getSpeed()) {
                System.out.println("speed sort");
                return false;
            }
        }
        list = inst.sortBySpeed(false);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getSpeed() > list.get(i).getSpeed()) {
                System.out.println("speed sort");
                return false;
            }
        }
        return true;
    }

    // test getAll method of PokemonTable
    public static boolean testPokemonTableGetAll() throws IOException {
        PokemonTable inst = new PokemonTable(10);
        for (Pokemon item : testList) {
            inst.put(item.getName(), item);
        }
        LinkedList<Pokemon> list = inst.getAll();
        if (list.size() != 6)
            return false;
        for (Pokemon item : testList) {
            if (!list.contains(item)) {
                return false;
            }
        }
        return true;
    }

    // test getAll method of MyFAvorite
    public static boolean testMyFavoriteGetAll() {
        MyFavorite inst = new MyFavorite(10);
        for (Pokemon item : testList) {
            inst.put(item.getName(), item);
        }
        LinkedList<Pokemon> list = inst.getAll();
        if (list.size() != 6)
            return false;
        for (Pokemon item : testList) {
            if (!list.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
        dataTestInit();
        System.out.println(testLoading());
        System.out.println(testPokemomGetSet());

        /* test for PokemonTable class */
        loadPokemonTable();
        System.out.println(testTableClear());
        loadPokemonTable();
        System.out.println(testTableGet());
        loadPokemonTable();
        System.out.println(testTableRemove(799));
        System.out.println(testPokemonTableGetAll());

        /* test for MyFavorite class */
        loadFavorite();
        System.out.println(testTableClear());
        loadFavorite();
        System.out.println(testTableGet());
        loadFavorite();
        System.out.println(testTableRemove(6));
        System.out.println(testMyFavoriteGetAll());

        System.out.println(testSort());
    }
}
