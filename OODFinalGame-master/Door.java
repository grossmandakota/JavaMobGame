
/**
 * Write a description of class Door here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door
{
    private Room roomA;
    private Room roomB;
    private boolean closed;
    private LockDelegate lockDelegate;

    public Door()
    {

    }

    public Door(Room roomA, Room roomB)
    {
        this.roomA = roomA;
        this.roomB = roomB;
        closed = false;
        lockDelegate = null;
    }
    
    public Door getDoor()
    {
        return this;
    }
    
    /*
     * returns true if the player can open the door
     * or owns the district
     * returns false if the player does not have enough respect
     */
    public boolean openable(Player player1)
    {
       if(getRoomFromTheOtherSideOf(player1.getCurrentRoom()).getOwner() == player1)
        {
            return true;
        }
        else if(player1.hasEnough(0, 700, 0)) //loosely coupled 
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
     * Gets the  room on the other side of the door
     */
    public Room getRoomFromTheOtherSideOf(Room room)
    {
        if(room == roomA)
        {
            return roomB;
        }
        else
        {
            return roomA;
        }
    }

    /*
     * Checks to see if it is closed
     * If closed it returns true
     * If open it returns false
     */
    public boolean isClosed()
    {
        return closed;
    }

    /*
     * closes the door
     * returns an ActionResult that describes the situation
     * after the action
     * Mainly used in GameWorld to initialy close the doors
     */
    public ActionResult close()
    {
        if(isClosed())
        {
            return ActionResult.UNCHANGED_DONE;
        }
        if(lockDelegate != null)
        {
            if(lockDelegate.mayClose())
            {
                closed = true;
                return ActionResult.CHANGED_DONE; 
            }
            else
            {
                return ActionResult.UNCHANGED_NOTDONE; 
            }
        }
        else{
            closed = true;
            return ActionResult.CHANGED_DONE;
        }
    }

    /*
     * opens the door
     * returns an ActionResult that describes the situation
     * after the action 
     */
    public ActionResult open()
    {
        if(isOpen())
        {
            return ActionResult.UNCHANGED_DONE;
        }
        if(lockDelegate != null)
        {
            if(lockDelegate.mayClose())   //used Delegate and Enum types
            {
                closed = false;
                return ActionResult.CHANGED_DONE;
            }
            else
            {
                return ActionResult.UNCHANGED_NOTDONE;
            }
        }
        else{
            closed = false;
            return ActionResult.CHANGED_DONE;
        }
    }

    /*
     * makes variable called oldLock and sets 
     * the lockDelegate to oldLock
     * then returns it
     */
    public LockDelegate setDelegate(LockDelegate lockDelegate)
    {
        LockDelegate oldLock = this.lockDelegate;
        this.lockDelegate = lockDelegate;
        return oldLock;
    }
    
    /*
     * Gets the lockDelgate
     */
    public LockDelegate getDelegate()
    {
        return lockDelegate;
    }
    
    /*
     * Checks to see if it is open
     * If open it returns true
     * If closed it returns false
     */
    public boolean isOpen()
    {
        return !closed;
    }

    /*
     * Makes the door using two room 
     * and the two directions
     *
     */
    public static Door makeDoor(Room room1, Room room2, String toRoom1, String toRoom2)
    {
        Door door = new Door(room1, room2);
        room2.setExit(toRoom2, door);
        room1.setExit(toRoom1, door);

        return door;
    }
}
