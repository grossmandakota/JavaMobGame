
/**
 * This class represents players in the game. Each player has 
 * a current location.
 * ALL action will be in this class and NOT Command
 * @author Michael Kolling modified by Rodrigo A. Obando (2018)
 * @version 1.0 (December 2002)
 */
import java.util.ArrayList;

public class Player extends MobBoss
{
    private Room currentRoom;
    private Door door;
    public ArrayList<Room> beenThere = new ArrayList<Room>();
    
    /**
     * Constructor for objects of class Player
     */
    public Player(Room startingRoom)
    {
        setMoney(25000);
        setRespect(500);
        setHenchmen(30);
        setIsAlive(true);
        currentRoom = startingRoom;
        this.addDistrict(currentRoom); // let's the player own the south district when they start the game
    }

    /**
     * Return the current room for this player.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    // public ArrayList<Room> addBeenThere(Room room)
    // {
        // beenThere.add(getCurrentRoom());
    // }
    
    /**
     * Set the current room for this player.
     */
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }
    
    /**
     * Try to walk in a given direction. If there is a door
     * this will change the player's location.
     */
    public void walk(String direction)
    {
        // Try to leave current room.
        Door door = currentRoom.getExit(direction);

        if (door == null)
            System.out.println("There is no door on " + direction);
        else {
            if(door.isOpen())
            {
            Room nextRoom = door.getRoomFromTheOtherSideOf(getCurrentRoom());    
            setCurrentRoom(nextRoom);    //  this moves the player into another room
            System.out.println(nextRoom.getLongDescription());
        }
        else {
            System.out.println("The door on " + direction + " is closed.");
        }
        }
    }
    
    public void open(String direction)
    {
        Door door = currentRoom.getExit(direction);

        if (door == null)
            System.out.println("There is no door on " + direction);
        else {
            door.open();
            System.out.println("The door on " + direction + " is open.");
        }
    
    }
    
    // public boolean ownedByTony()
    // {
        // if(this.getDoor() == door1)
        // {
            // return true;
        // }
        // return false;
    // }
    
    // public boolean ownedByJames()
    // {
        // return false;
    // }
    
    // public boolean ownedByHenry()
    // {
        // return false;
    // }
}
