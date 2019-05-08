
/**
 * This class represents players in the game. Each player has 
 * a current location.
 * ALL action will be in this class and NOT Command
 * @author Michael Kolling modified by Rodrigo A. Obando (2018)
 * @version 1.0 (December 2002)
 */
import java.util.*;

public class Player extends MobBoss
{
    private Room currentRoom;
    private Door door;
    private MobBoss boss;
    public Stack<Room> stack = new Stack<Room>();
    
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
    
    /*
     * this method allows the player to open doors
     * if they have enough respect. If the payer does and 
     * if the player does not already own the district
     * then the player can open the door
     */
    public void open(String direction)
    {
        Door door = currentRoom.getExit(direction);

        if (door == null)
        {
            System.out.println("There is no door on " + direction);
        }
        else {
            if(door.openable(this))
            {
            ActionResult result = door.open();
            switch(result)
            {
                case UNCHANGED_DONE:
                System.out.println("The door on " + direction + " was already open.");
                break;
                case CHANGED_DONE:
                System.out.println("The door on " + direction + " is open.");
                break;
                case UNCHANGED_NOTDONE:
                System.out.println("The door on " + direction + " is still closed.");
                break;
            }
        }
        else 
        {
            System.out.println("You can not open the door. You have " + this.getRespect() + " respect and you need 700");
        }
        }  
    }
    
    /*
     * The player will be allowed to unlock 
     * locked doors
     */
    public void Unlock(String direction)
    {
        Door door = currentRoom.getExit(direction);

        if (door == null)
            System.out.println("There is no door on " + direction);
        else {
            LockDelegate theLock = door.getDelegate();
            if(theLock != null)
            {
                ActionResult result = theLock.unlock();
                switch(result)
                {
                    case UNCHANGED_DONE:
                    System.out.println("The door on " + direction + " was already unlocked.");
                    break;
                    case CHANGED_DONE:
                    System.out.println("The door on " + direction + " is unlocked.");
                    break;
                    case UNCHANGED_NOTDONE:
                    System.out.println("The door on " + direction + " is still locked.");
                    break;
                }
            }
            else
            {
                System.out.println("The door on " + direction + " does not have a lock.");
            }
        }  
    }
    
    /*
     * The player can go back to the 
     * previous room 
     * contains one bug/feature!
     * Even though it sets current room it does not acually set it
     */
    public void back(Player player)
    {
    Room Croom = stack.pop();    
    player.setCurrentRoom(Croom);
    //System.out.println(player.getCurrentRoom().getLongDescription());
    System.out.println(stack.pop().getLongDescription());
    }
}
