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
    
    public Room createWorld()
    {
    Room districtS = new Room("the south district");
    Room districtSE = new Room("the southeast district");
    Room districtSW = new Room("the southwest district");
    Room districtE = new Room("the east district");
    Room districtW = new Room("the west district");
    Room shop = new Room("the shop");
    Room districtNE = new Room("the nothreast district");
    Room districtN = new Room("the north district");
    Room districtNW = new Room("the northwest district");

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
                if(GameWorld.getInstance().getHMapOfMB().get("Tony").getIsAlive() == false && GameWorld.getInstance().getHMapOfMB().get("James").getIsAlive() == false && GameWorld.getInstance().getHMapOfMB().get("Henry").getIsAlive() == false)
        {
            finished = true;
        }
            }
        }
        System.out.println("You have won! You are now the Mob Boss!");
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
