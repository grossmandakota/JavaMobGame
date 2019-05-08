/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.
 * 
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018)
 * @version 1.1 (December 2002)
 */
import java.io.*;
import java.util.*;
   
class Game 
{
    private Parser parser; // reading commands from the user 
    private Player player;
    private Door door;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        player = new Player(GameWorld.getInstance().getEntrance());
        parser = new Parser();
    }

    public Stack<Room> getStack(Stack<Room> stack)
    {
        return stack;
    }
    
    public Room createWorld()
    {
    Room districtS = new Room("in the south district");
    Room districtSE = new Room("in the southeast district");
    Room districtSW = new Room("on the southwest district");
    Room districtE = new Room("in the east district");
    Room districtW = new Room("in the west district");
    Room shop = new Room("in the shop");
    Room districtNE = new Room("in the nothreast district");
    Room districtN = new Room("in the north district");
    Room districtNW = new Room("in the northwest district");

    return districtS;
    }
     /**

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {         
        printWelcome();

        boolean finished = false;
        while(! finished) {
            Command command = parser.getCommand();
            if(command == null) {
                System.out.println("I don't understand...");
            } else {
                player.stack.push(player.getCurrentRoom()); //adds to the rooms to the stack
                finished = command.execute(player);
                System.out.println(player.getMoney());// quit return true
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("As far back as you can remember, you always wanted to be a gangster. Now's your chance.");
        System.out.println("You start in the south district with $" + player.getMoney() + ", " + player.getRespect() + " respect, and " + player.getHenchmen() + " henchmen. Good luck.");
        System.out.println("\nType 'help' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }
}
