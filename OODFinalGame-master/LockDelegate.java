
/**
 * Write a description of interface LockDelegate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface LockDelegate
{
    void setDoor(Door door);
    boolean isLocked();
    boolean isUnlocked();
    ActionResult lock();
    ActionResult unlock();
    boolean mayOpen();
    boolean mayClose();
}
