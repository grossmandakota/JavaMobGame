
/**
 * This class represents players in the game. Each player has 
 * a current location.
 * ALL action will be in this class and NOT Command
 * @author Michael Kolling modified by Rodrigo A. Obando (2018)
 * @version 1.0 (December 2002)
 */
public class Player extends MobBoss
{
    private Room currentRoom;

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
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null)
            System.out.println("There is no door!");
        else {
            setCurrentRoom(nextRoom);    //  this moves the player into another room
            System.out.println(nextRoom.getLongDescription());
        }
    }
}
