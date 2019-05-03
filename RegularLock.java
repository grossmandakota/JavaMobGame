
/**
 * Write a description of class RegularLock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RegularLock implements LockDelegate
{
    private boolean locked;
    private Door door;
    
    
    public RegularLock()
    {
        locked = false;
    }
    
    public void setDoor(Door doorA)
    {
        this.door = doorA;
    }
    
    public boolean isLocked()
    {       
        return locked;
    }
    
    public boolean isUnlocked()
    {
        return !locked;
    }
    
    public ActionResult lock()
    {
        if(isUnlocked())
        {
            locked = true;
            return ActionResult.CHANGED_DONE;
        }
        else
        {
            return ActionResult.UNCHANGED_DONE;
        }
    }
    
    public ActionResult unlock()
    {
    
        if(isLocked())
        {
            locked = false;
            return ActionResult.CHANGED_DONE;
        }
        else
        {
            return ActionResult.UNCHANGED_DONE;
        }
    }
    
    /* See if the player owns the district on the other side of the door
     * and if they hae enough respect to open it
     * 
     */
    
    /*
     * to see if the player can open the door
     * false=locked true=unlocked
     */
    public boolean mayOpen() //who and what side(plaeyr, room)
    //  also in the lockDelagate
    {
        if(isLocked())
        {
            return false; 
        }
        else 
        {
            return true;
        }
    }
    
    /* This method allows the player to see 
     *  if they are able to close the door.
     *  The only case that is cannot is if the door has a deadbolt
     */ 
    public boolean mayClose()
    {
        if(isLocked())
        {
            return true; // unless there is a deadbolt then it would be false 
        }
        else
        {
            return true;
        }
    }
}
