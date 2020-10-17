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
import java.util.Scanner;

/**
 * This class intends to launch the whole Application with the simple interface in command
 * line model to users.
 *
 * @author Zhiwei Cao, Jiahe Jin, Minghao Zhou, Liangqi Cai, Tianwei Bao, Seungjun Chong, Yunzhao Liu
 * @version 1.0
 */
public class Launch {

    private PokemonTable table; // create the PokemonTable Object
    private MyFavorite favorite; // create my favorite object

    /**
     * The default constructor intends to initialize the PokemonTable by creating the new Object for it.
     * Then, after we successfully load all data and make the object of PokemonTable, we need to pose
     * the Introduction face for users.
     */
    public Launch() throws IOException {
        this.table = new PokemonTable(); // Instantiate the PokemonTable Object
        this.favorite = new MyFavorite();// Instantiate the MyFavorite Object
        this.getStart(); // starting the app
    }

    /**
     * This method will execute all commands assigned by users by accessing all kinds of different methods.
     *
     * @param command the command being assigned from users
     */
    public void launchPad(String command) {
        // When the command we entered is "g", we will open the guidebook
        if (command.equalsIgnoreCase("g")) {
            this.guideBook();
        }
        // When the command we entered is "q", we will quit the app
        else if (command.equalsIgnoreCase("q")) {
            this.quit();
        }
        // When the command we entered is "r", we will refresh the app (NOTE: It become useless)
        else if (command.equalsIgnoreCase("r")) {
            this.refresh();
        }
        // When the command we entered is "a", we will open the viewAll method
        else if (command.startsWith("a")) {
            this.viewAll(command);
        }
        // When the command we entered is "a", we can check any Pokemon in Pokedex by entering the name
        else if (command.equalsIgnoreCase("c")) {
            Scanner input = new Scanner(System.in);
            System.out.println("What Pokemon you want to check, please enter its name: ");
            String name = input.nextLine();
            this.check(name);
        }
        // When the command we entered is "D", we can document the specific Pokemon
        else if (command.equalsIgnoreCase("d")) {
            this.document();
        }
        // When the command we entered is "n", we can check how many numbers of Pokemon in the Pokedex
        else if (command.equalsIgnoreCase("n")) {
            System.out.println("The number of Pokemon were documented: " + table.size());
        }
        // When the command we entered is "m", we can remove any Pokemon in our Pokedex
        else if (command.equalsIgnoreCase("m")) {
            this.remove();
        }
        // When the command we entered is "f", we will open the MyFavorite interface
        else if (command.equalsIgnoreCase("f")) {
            this.myFavorite();
        }
        // When the command we entered is "s", we will open the Sorting interface
        else if (command.equalsIgnoreCase("s")) {
            this.sort();
        }
        // When the command we entered is "t", we will get the list of Pokemon based on their Combat Ability
        else if (command.equalsIgnoreCase("t")) {
            LinkedList<Pokemon> pokemonList = this.table.sortByTotal(false);
            int index = 0;
            for (Pokemon pokemon : pokemonList) {
                System.out.print(index + ": ");
                System.out.println(pokemon.getName() + " [Combat Ability] " + pokemon.getAttack());
                index++;
            }
        }

        // After executing all of command lines, the new Command line will be ready
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the command you want: ");
        String newCommand = input.nextLine();
        this.launchPad(newCommand);
    }

    /**
     * This method intends to give users the specific introduction in all command operations.
     */
    public void getHelp() {
        System.out.println(
            "If you want to know more about Pokédex, commands below would be helpful to guide you!");
        System.out.println(
            "[a] enter a to view all Pokemon's name in the Pokédex."); // Has been Installed
        System.out.println(
            "[c] enter c to check (search) the Pokemon you want to know."); // Has been Installed
        System.out.println(
            "[d] enter d to document the Pokemon you want to add in the Pokédex."); // Has been Installed
        System.out.println("[f] enter f to view my Favorite Pokemon."); // Has been Installed
        System.out.println("[g] enter g to open the Guide Book."); // Has been installed
        System.out.println(
            "[m] enter m to remove the Pokemon which you want to remove from the Pokédex."); // Has been installed
        System.out.println(
            "[n] enter n to check the number of Pokemon documented in the Pokédex."); // Has been installed
        System.out.println("[r] enter r to refresh the page of Pokédex."); // Has been installed
        System.out.println("[s] enter s to sort out the list of Pokemon you want");
        System.out.println("[q] enter q to leave the Pokédex."); // Has been installed
        System.out.println(
            "[t] enter t to get the list of Pokemon ordered by its general Combat Ability");
        System.out.println(
            "----------------------------------------Extension Operations----------------------------------------");
        System.out.println("For [a]:");
        System.out.println(
            "        [a][a] enter aa to view all Pokemon's name with all of their attributes in the Pokédex.");
        System.out.println(
            "        [a][t] enter at to view all Pokemon's name with both type1 and type2 in the Pokédex.");
        System.out.println(
            "        [a][h] enter ah to view all Pokemon's name with their HP in the Pokédex.");
        System.out.println(
            "        [a][a][t] enter aat to view all Pokemon's name with their attack values in the Pokédex.");
        System.out.println(
            "        [a][d] enter ad to view all Pokemon's name with their defense values in the Pokédex.");
        System.out.println(
            "        [a][s][a] enter asa to view all Pokemon's name with their special attack values in the Pokédex.");
        System.out.println(
            "        [a][s][d] enter asd to view all Pokemon's name with their special defense values in the Pokédex.");
        System.out.println(
            "        [a][s] enter as to view all Pokemon's name with their speed values in the Pokédex.");
        System.out.println(
            "        [a][l] enter al to view all Pokemon's name with their legendary state in the Pokédex.");
        System.out.println(
            "        [a][f] enter af to view all Pokemon's name with their favorite state in the Pokédex.");
        System.out.println(
            "---------------------------------Extension Operations (My Favorite)---------------------------------");
        System.out.println("For [f]: ");
        System.out.println("[a] enter a to check all Pokemon in My Favorite");
        System.out.println(
            "[p] enter p to put a Pokemon in My Favorite (Note: the Pokemon must be in the Pokédex).");
        System.out.println("[m] enter m to remove a Pokemon in My Favorite.");
        System.out.println("[b] enter b to back to the menu of the Pokédex.");
        System.out.println("[q] enter q to quit the Pokédex.");
        System.out.println(
            "-------------------------------Extension Operations (Pokemon Sorting)-------------------------------");
        System.out.println("For [s]: ");
        System.out.println("[x]: the variable of [p] and [n].");
        System.out.println("     When [x] is [p], the sorted result is arranged in POSITIVE order");
        System.out.println("     When [x] is [n], the sorted result is arranged in NEGATIVE order");
        System.out.println("[y]: the types of Pokemon in the Pokédex");
        System.out.print("     ");
        table.getTypes();
        System.out.println("");
        System.out.println(
            "[a][-][x]: enter the a-x to sort the Pokemon with their attack values in [x] order.");
        System.out.println(
            "[d][-][x]: enter the d-x to sort the Pokemon with their defense values in [x] order.");
        System.out.println(
            "[s][a][-][x]: enter the sa-x to sort the Pokemon with their special attack values in [x] order.");
        System.out.println(
            "[s][d][-][x]: enter the sd-x to sort the Pokemon with their special defense values in [x] order.");
        System.out.println(
            "[s][-][x]: enter the s-x to sort the Pokemon with their speed values in [x] order.");
        System.out.println(
            "[h][-][x]: enter the h-x to sort the Pokemon with their HP values in [x] order.");
        System.out.println(
            "[c][-][x]: enter the c-x to sort the Pokemon with their combat ability values in [x] order.");
        System.out
            .println("[n][-][x]: enter the n-x to sort the Pokemon with their name in [x] order.");
        System.out.println("[t][-][y]: enter the t-y to sort the Pokemon with the same type [y].");
        System.out.println("[l] enter l to sort out the Pokemon which are legendary");
        System.out.println("[f] enter f to sort out the Pokemon which are in My Favorite");
        System.out.println("[b] enter b to back to the menu of the Pokédex");
        System.out.println("[q] enter q to quit the Pokédex");

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the command you want: ");
        String command = input.nextLine();
        this.launchPad(command);
    }



    /**
     * This method intends to pose the initial page for users including the Welcome page, basic
     * command operation introduction.
     */
    public void getStart() {
        for (int i = 0; i < 3; i++) {
            System.out.println(
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        System.out.println("");
        System.out.println("");
        System.out.println(
            "                                         WELCOME TO POKEDEX                                         ");
        System.out.println(
            "                                      (Click Enter to continue)                                     ");
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            System.out.println(
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
        Scanner input = new Scanner(System.in);
        String enter = input.nextLine();
        if (enter.isEmpty()) {
            System.out.println("Welcome to Pokédex!");
            System.out.println("[g] enter g to open the Guide Book.");
            System.out.println("[f] enter f to view my Favorite Pokemon.");
            System.out.println("[c] enter c to Check (search) the Pokemon you want to know.");
            System.out.println("[d] enter d to document the Pokemon you want to add in Pokédex.");
            System.out.println("[a] enter a to view all Pokemon in Pokédex.");
            System.out.println("[q] enter q to leave the Pokédex.");
            System.out.println("Please enter the command you want:");
            String command = input.nextLine();
            this.launchPad(command); // go to launchPad method to execute command.
        }

    }

    /**
     * This method intends to guide users in Pokédex. It should include all information about the
     * application.
     */
    public void guideBook() {
        System.out.println(
            "[Mission] Pokédex is committed to Pokemon Lovers. It helps to search, check, and document all Pokemon.");
        System.out.println("[Authors] [Data Wranglers]       Minghao Zhou Liangqi Cai");
        System.out.println("          [Back End Developers]  Tianwei Bao Seungjun Chong");
        System.out.println("          [Front End Developers] Zhiwei Cao Jiahe Jin");
        System.out.println("          [Test Engineer]        Yunzhao Liu");
        System.out.println("[Versions] 1.0");
        System.out.println("[Update Date] 2020/9/25");
        System.out.println("[Source] https://www.kaggle.com/abcsds/pokemon");
        System.out.println(
            "[Next Generation] To rich the Pokemon quantities and varieties in future, we hope to build the");
        System.out.println(
            "                  Sharing Platform to allow users upload new Pokemon in our data set where new");
        System.out.println(
            "                  Pokemon will be updated synchronously. To complete the Pokédex, we are happy");
        System.out.println("                  to receive our users' feedbacks! Thank you!");
        System.out.println(
            "-----------------------------------------[User Operations]-----------------------------------------");
        this.getHelp();
    }

    /**
     * This method intends to quit the application.
     */
    public void quit() {
        try {
            Runtime.getRuntime().exit(0);
        } catch (Exception e) {
            System.out
                .println("Sorry, the Pokédex failed to exit, please directly close the window!");
        }
    }

    /**
     * This method intends to clear the screen and restart the application by entering getStart() method.
     */
    public void refresh() {
        try {
            Runtime.getRuntime().exec("clear"); // It does not work well.
            this.getStart(); //restart the application
        } catch (Exception e) {
            System.out
                .println("Sorry, the screen can not be refreshed due to some Unknown reason!");
            System.out.println("Please, try to close the application!");
            System.out.println("Please enter the q to exit!");
            Scanner input = new Scanner(System.in);
            String quit = input.nextLine();
            if (quit.equalsIgnoreCase("q")) {
                this.quit(); // quit the class
            }
        }
    }

    /**
     * This method intends to print out the all Pokemon within the PokemonTable. By entering the
     * second command with [a], like [ax] where the [x] is the second command, users can get the
     * specific values of pokemon with its name. When users just enter the [a], all Pokemon's name
     * will be output. When users enter [a][a], all Pokemon's name with all of other attributes will
     * be output together.
     *
     * @param command the command being assigned from users
     */
    public void viewAll(String command) {
        // When the command is just [a]
        // All Pokemon's name
        if (command.equalsIgnoreCase("a")) {
            System.out.println("All of Pokemon listed below are in Pokédex!");
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.print(": ");
                System.out.println(pokemon.getName());
                index++;
            }
        }

        // When the command is just [a][a]
        // All Pokemon's name with all of their attributes
        else if (command.equalsIgnoreCase("aa")) {
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.println(": " + pokemon.getName());
                System.out.println(pokemon.getAttributes());
                index++;
            }
        }

        // When the command is just [a][t]
        // All Pokemon's name with both of their types
        else if (command.equalsIgnoreCase("at")) {
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.print(": ");
                if (pokemon.getType2().equalsIgnoreCase("Not Documented Yet!")) {
                    System.out.println(pokemon.getName());
                    System.out.println("[Type] " + pokemon.getType1());
                    System.out.println("");
                } else {
                    System.out.println(pokemon.getName());
                    System.out
                        .println("[Type] " + pokemon.getType1() + " and " + pokemon.getType2());
                    System.out.println("");
                }
                index++;
            }
        }

        // When the command is just [a][h]
        // All Pokemon's name with their HP
        else if (command.equalsIgnoreCase("ah")) {
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.println(": " + pokemon.getName());
                System.out.println("[HP] " + pokemon.getHp());
                System.out.println("");
                index++;
            }
        }

        // When the command is just [a][a][t]
        // All Pokemon's name with their attack values
        else if (command.equalsIgnoreCase("aat")) {
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.println(": " + pokemon.getName());
                System.out.println("[ATTACK] " + pokemon.getAttack());
                System.out.println("");
                index++;
            }
        }

        // When the command is just [a][d]
        // All Pokemon's name with their defense values
        else if (command.equalsIgnoreCase("ad")) {
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.println(": " + pokemon.getName());
                System.out.println("[DEFENSE] " + pokemon.getDefense());
                System.out.println("");
                index++;
            }
        }

        // When the command is just [a][s][a]
        // All Pokemon's name with their special attack values
        else if (command.equalsIgnoreCase("asa")) {
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.println(": " + pokemon.getName());
                System.out.println("[SPECIAL ATTACK] " + pokemon.getSpAttack());
                System.out.println("");
                index++;
            }
        }

        // When the command is just [a][s][d]
        // All Pokemon's name with their special defense values
        else if (command.equalsIgnoreCase("asd")) {
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.println(": " + pokemon.getName());
                System.out.println("[SPECIAL DEFENSE] " + pokemon.getSpDefense());
                System.out.println("");
                index++;
            }
        }

        // When the command is just [a][s]
        // All Pokemon's name with their speed values
        else if (command.equalsIgnoreCase("as")) {
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.println(": " + pokemon.getName());
                System.out.println("[SPEED] " + pokemon.getSpeed());
                System.out.println("");
                index++;
            }
        }

        // When the command is just [a][l]
        // All Pokemon's name with their legendary states
        // Output "LEGENDARY" if they are, "NOT" if they are not
        else if (command.equalsIgnoreCase("al")) {
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.println(": " + pokemon.getName());
                System.out.println("[LEGENDARY] " + pokemon.isLegendary());
                System.out.println("");
                index++;
            }
        }

        // When the command is just [a][f]
        // All Pokemon's name with their favorite states
        // Output "FAVORITE" if they are, "NOT" if they are not
        else if (command.equalsIgnoreCase("af")) {
            int index = 1;
            for (Pokemon pokemon : this.table.getAll()) {
                System.out.print(index);
                System.out.println(": " + pokemon.getName());
                System.out.println("[FAVORITE] " + pokemon.getFavorite());
                System.out.println("");
                index++;
            }
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("Sorry, the " + command + " operation does not existed!");
            System.out.println("Please try enter the other command you want: ");
            String newCommand = input.nextLine();
            this.launchPad(newCommand);
        }
    }

    /**
     * This method intends to get all specific attributes (information) of the Pokemon by searching
     * its name.
     *
     * @param name the name of Pokemon searched
     */
    public void check(String name) {
        if (table.containsKey(name)) {
            Pokemon searchedPokemon = (Pokemon) table.get(name);
            System.out.println(searchedPokemon.getAttributes());
        } else {
            System.out.println("The " + name + " does not exist in the Pokédex!");
            System.out.println("[Pokédex] Please try other commands:");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            this.launchPad(command);
        }

    }

    /**
     * This method intends to help users add their own Pokemon into the PokemonTable
     *
     * @return true if the Pokemon is successfully added, false if the Pokemon is not added
     */
    public boolean document() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the name of Pokemon you want to document: ");
            String name = input.nextLine();
            if (table.containsKey(name)) {
                System.out
                    .println("Failed Documented, because the name of Pokemon has already existed!");
                System.out.println("Please enter the other commands you want: ");
                String command = input.nextLine();
                this.launchPad(command);
            }
            System.out.println("Please enter the type1 of Pokemon you want to document: ");
            String type1 = input.nextLine();
            System.out.println(
                "Please enter the type2 of Pokemon you want to document, if not, just leave bank by click Enter: ");
            String type2 = input.nextLine();
            System.out.println("Please enter the HP of Pokemon you want to document: ");
            String hp = input.nextLine();
            int hpInt = Integer.parseInt(hp);
            System.out.println("Please enter the attack value of Pokemon you want to document: ");
            String attack = input.nextLine();
            int attackInt = Integer.parseInt(attack);
            System.out.println("Please enter the defense value of Pokemon you want to document: ");
            String defense = input.nextLine();
            int defenseInt = Integer.parseInt(defense);
            System.out
                .println("Please enter the special attack value of Pokemon you want to document: ");
            String spAttack = input.nextLine();
            int spAttackInt = Integer.parseInt(spAttack);
            System.out.println(
                "Please enter the special defense value of Pokemon you want to document: ");
            String spDefense = input.nextLine();
            int spDefenseInt = Integer.parseInt(spDefense);
            System.out.println("Please enter the speed value of Pokemon you want to document: ");
            String speed = input.nextLine();
            int speedInt = Integer.parseInt(speed);
            int total = attackInt + defenseInt + spAttackInt + spDefenseInt + speedInt;

            Pokemon newPokemon =
                new Pokemon(name, type1, type2, hpInt, attackInt, defenseInt, spAttackInt,
                    spDefenseInt, speedInt, total, false, false);
            table.put(newPokemon.getName(), newPokemon); // put the new Pokemon In
            System.out.println("Successfully Documented!");
            return true;
        } catch (Exception e) {
            System.out
                .println("Failed Documented! Please enter correct values for each attribute!");
            return false;
        }


    }

    /**
     * This method intends to remove the Pokemon assigned by the users.
     */
    public void remove() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of Pokemon you want to remove: ");
        String name = input.nextLine();
        if (this.table.containsKey(name)) {
            this.table.remove(name);
            System.out.println("The " + name + " has been removed successfully!");
        } else {// When the name can not be found
            System.out.println("Sorry, " + name + " was not found in the Pokédex!");
        }

    }

    /**
     * This method is only used by MyFavorite table where the command will be loaded at here
     *
     * @param command the command being assigned from users
     */
    public void myPad(String command) {
        Scanner input = new Scanner(System.in);
        if (command.equalsIgnoreCase("a")) {
            if (this.favorite.size() == 0) {
                System.out.println("Please try to use [p] to put the pokemon you liked in here!");
            } else {
                System.out.println("All of Pokemon listed below are in My Favorite!");
                int index = 1;
                for (Pokemon pokemon : this.favorite.getAll()) {
                    System.out.print(index);
                    System.out.print(": ");
                    System.out.println(pokemon.getName());
                    index++;
                }
            }
        } else if (command.equalsIgnoreCase("p")) {
            System.out.println("What the name of Pokemon you want to add in My Favorite: ");

            String name = input.nextLine();
            if (table.containsKey(name) && !favorite.containsKey(name)) {
                favorite.put(name, table.get(name));
                System.out.println(name + " was successfully added in My Favorite!");
            } else {
                System.out.println("The Pokemon " + name + " can not be added in My Favorite!");
                System.out.println("It might be not in the Pokédex OR has already in My Favorite.");
            }
        } else if (command.equalsIgnoreCase("m")) {
            System.out.println("What the name of Pokemon you want to remove from My Favorite: ");
            String name = input.nextLine();
            if (favorite.containsKey(name)) {
                ((Pokemon) table.get(name)).setFavorite(false); // remove the Pokemon
                favorite.remove(name);
                System.out.println("The " + name + " was successfully removed from My Favorite!");
            } else {
                System.out.println("The Pokemon " + name + " can not be removed from My Favorite!");
                System.out.println("It might be not in My Favorite.");
            }
        } else if (command.equalsIgnoreCase("b")) {
            this.launchPad("r");
        } else if (command.equalsIgnoreCase("q")) {
            this.launchPad("q");
        } else {
            System.out.println(command + " might not work, please try other commands.");
            String newCommand = input.nextLine();
            this.myPad(newCommand);
        }

        System.out.println("[Favorite] Please enter the command you want: ");
        String newCommand = input.nextLine();
        this.myPad(newCommand);
    }

    /**
     * This method intends to open the users' own favorite interface.
     */
    public void myFavorite() {
        for (int i = 0; i < 2; i++) {
            System.out.println(
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        System.out.println("");
        System.out.println("");
        System.out.println(
            "                                    WELCOME TO MY FAVORITE TABLE                                    ");
        System.out.println("");
        for (int i = 0; i < 2; i++) {
            System.out.println(
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
        System.out.println("[a] enter a to check all Pokemon in My Favorite");
        System.out.println(
            "[p] enter p to put a Pokemon in My Favorite (Note: the Pokemon must be in the Pokédex)");
        System.out.println("[m] enter m to remove a Pokemon in My Favorite");
        System.out.println("[b] enter b to back to the menu of the Pokédex");
        System.out.println("[q] enter q to quit the Pokédex");
        Scanner input = new Scanner(System.in);
        String enter = input.nextLine();
        this.myPad(enter);
    }

    /**
     * This method intends to open the sorting interface for users, which allows users to sort the Pokemon
     * based on their attributes.
     */
    public void sort() {
        for (int i = 0; i < 2; i++) {
            System.out.println(
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        System.out.println("");
        System.out.println("");
        System.out.println(
            "                                       WELCOME TO POKEMON SORTING                                       ");
        System.out.println("");
        for (int i = 0; i < 2; i++) {
            System.out.println(
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
        System.out.println("[x]: the variable of [p] and [n].");
        System.out.println("     When [x] is [p], the sorted result is arranged in POSITIVE order");
        System.out.println("     When [x] is [n], the sorted result is arranged in NEGATIVE order");
        System.out.println("[y]: the types of Pokemon in the Pokédex");
        System.out.print("     ");
        table.getTypes();
        System.out.println("");
        System.out.println(
            "[a][-][x]: enter the a-x to sort the Pokemon with their attack values in [x] order.");
        System.out.println(
            "[d][-][x]: enter the d-x to sort the Pokemon with their defense values in [x] order.");
        System.out.println(
            "[s][a][-][x]: enter the sa-x to sort the Pokemon with their special attack values in [x] order.");
        System.out.println(
            "[s][d][-][x]: enter the sd-x to sort the Pokemon with their special defense values in [x] order.");
        System.out.println(
            "[s][-][x]: enter the s-x to sort the Pokemon with their speed values in [x] order.");
        System.out.println(
            "[h][-][x]: enter the h-x to sort the Pokemon with their HP values in [x] order.");
        System.out.println(
            "[c][-][x]: enter the c-x to sort the Pokemon with their combat ability values in [x] order.");
        System.out
            .println("[n][-][x]: enter the n-x to sort the Pokemon with their name in [x] order.");
        System.out.println("[t][-][y]: enter the t-y to sort the Pokemon with the same type [y].");
        System.out.println("[l] enter l to sort out the Pokemon which are legendary");
        System.out.println("[f] enter f to sort out the Pokemon which are in My Favorite");
        System.out.println("[b] enter b to back to the menu of the Pokédex");
        System.out.println("[q] enter q to quit the Pokédex");
        System.out.println("Please enter the Command you want: ");
        Scanner input = new Scanner(System.in);
        String enter = input.nextLine();
        this.mySort(enter);

    }

    /**
     * This method is only used by Sort command [s]
     *
     * @param command the command being assigned from users
     */
    public void mySort(String command) {
        try {
            if (command.contains("-")) {
                String[] commandList = command.split("-", 2);
                String command1 = commandList[0];
                String command2 = commandList[1];
                if (command1.equalsIgnoreCase("a") && command2.equalsIgnoreCase("p")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByAttack(true);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(pokemon.getName() + " [Attack] " + pokemon.getAttack());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("a") && command2.equalsIgnoreCase("n")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByAttack(false);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(pokemon.getName() + " [Attack] " + pokemon.getAttack());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("d") && command2.equalsIgnoreCase("p")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByDefense(true);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out
                            .println(pokemon.getName() + " [Defense] " + pokemon.getDefense());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("d") && command2.equalsIgnoreCase("n")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByDefense(false);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out
                            .println(pokemon.getName() + " [Defense] " + pokemon.getDefense());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("sa") && command2.equalsIgnoreCase("p")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortBySpAttack(true);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(
                            pokemon.getName() + " [Special Attack] " + pokemon.getSpAttack());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("sa") && command2.equalsIgnoreCase("n")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortBySpAttack(false);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(
                            pokemon.getName() + " [Special Attack] " + pokemon.getSpAttack());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("sd") && command2.equalsIgnoreCase("p")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortBySpDefense(true);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(
                            pokemon.getName() + " [Special Defense] " + pokemon.getSpDefense());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("sd") && command2.equalsIgnoreCase("n")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortBySpDefense(false);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(
                            pokemon.getName() + " [Special Defense] " + pokemon.getSpDefense());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("s") && command2.equalsIgnoreCase("p")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortBySpeed(true);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(pokemon.getName() + " [Speed] " + pokemon.getSpeed());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("s") && command2.equalsIgnoreCase("n")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortBySpeed(false);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(pokemon.getName() + " [Speed] " + pokemon.getSpeed());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("h") && command2.equalsIgnoreCase("p")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByHp(true);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(pokemon.getName() + " [HP] " + pokemon.getHp());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("h") && command2.equalsIgnoreCase("n")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByHp(false);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(pokemon.getName() + " [HP] " + pokemon.getHp());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("c") && command2.equalsIgnoreCase("p")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByTotal(true);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out
                            .println(pokemon.getName() + " [Combat Ability] " + pokemon.getTotal());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("c") && command2.equalsIgnoreCase("n")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByTotal(false);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out
                            .println(pokemon.getName() + " [Combat Ability] " + pokemon.getTotal());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("n") && command2.equalsIgnoreCase("p")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByName(true);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(pokemon.getName());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("n") && command2.equalsIgnoreCase("n")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByName(false);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out.println(pokemon.getName());
                        index++;
                    }
                } else if (command1.equalsIgnoreCase("t")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByType(command2);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        if (!pokemon.getType2().equalsIgnoreCase("Not Documented Yet!")) {
                            System.out.println(
                                pokemon.getName() + " [Type] " + pokemon.getType1() + " AND "
                                    + pokemon.getType2());
                        } else {
                            System.out.println(pokemon.getName() + " [Type] " + pokemon.getType1());
                        }
                        index++;
                    }
                }
            } else {
                if (command.equalsIgnoreCase("b")) {
                    this.launchPad("r");
                } else if (command.equalsIgnoreCase("q")) {
                    this.launchPad("q");
                } else if (command.equalsIgnoreCase("l")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByLegendary(true);
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out
                            .println(pokemon.getName() + " [Legendary] " + pokemon.isLegendary());
                        index++;
                    }
                } else if (command.equalsIgnoreCase("f")) {
                    LinkedList<Pokemon> pokemonList = this.table.sortByFavorite(true);
                    if (pokemonList.size() == 0) {
                        System.out.println("No Pokemon has been added in My Favorite.");
                        System.out.println("Do you want to open My Favorite to add [Y] or [N]?");
                        Scanner input = new Scanner(System.in);
                        String toDo = input.nextLine();
                        if (toDo.equalsIgnoreCase("Y")) {
                            this.launchPad("f");
                        }
                    }
                    int index = 1;
                    for (Pokemon pokemon : pokemonList) {
                        System.out.print(index + ": ");
                        System.out
                            .println(pokemon.getName() + " [Favorite] " + pokemon.getFavorite());
                        index++;
                    }
                }
            }

            System.out.println("[Pokemon Sorting] Please enter the command you want: ");
            Scanner input = new Scanner(System.in);
            String newCommand = input.nextLine();
            this.mySort(newCommand);

        } catch (Exception e) {
            System.out.println("Sorry, " + command
                + " seems does not work! And the Pokédex can not sort the result!");
            System.out.println("[Pokemon Sorting] Please try other command!");
            Scanner input = new Scanner(System.in);
            String enter = input.nextLine();
            this.mySort(enter);
        }
    }



    /**
     * The entry point of our java program
     *
     * @param args array of sequence of characters (Strings) that are passed to the "main" function
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("If you want to launch the Pokédex [y] or [n]: ");
        String command = input.nextLine();
        if (command.equalsIgnoreCase("y")) {
            try {
                Launch start = new Launch();
            } catch (IOException e) {
                System.out.println("The Pokédex is unable to launch!");
            }
        } else if (command.equalsIgnoreCase("n")) {
            Runtime.getRuntime().exit(0);
        }

    }

}
