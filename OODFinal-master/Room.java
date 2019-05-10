import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018)
 * @version 1.0 (February 2002)
 */

class Room 
{
    private String description;
    private HashMap<String, Door> exits;        // stores exits of this room.
    private boolean isPlayerHere;
    private RoomDelegate delegate;
    private MobBoss owner;
    
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court 
     * yard".
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Door>();
        owner = null;
    }
    
    public MobBoss getOwner() {
        return owner;
    }
    
    public void setOwner(MobBoss owner) {
        this.owner = owner;
    }

    /*
     * Returns weather the player is in 
     * the room or not
     */
    public void isPlayerInRoom(Player player)
    {
        if (this == player.getCurrentRoom()){
            isPlayerHere = true;
        }
        
        else
        {
            isPlayerHere = false;
        }
    }
    
    /**
     * Define an exit from this room.
     */
    public void setExit(String direction, Door door) 
    {
        exits.put(direction, door);
    }

    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of this room, in the form:
     *     You are in the kitchen.
     *     Exits: north west
     */
    public String getLongDescription()
    {
        return "You are in " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        for(String exitName : exits.keySet())
        {
            returnString += " " + exitName;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Door getExit(String direction) 
    {
        return exits.get(direction);
    }
}

