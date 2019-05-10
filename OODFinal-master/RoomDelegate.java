
/**
 * Write a description of interface RoomDelegate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;

public interface RoomDelegate
{
    void setExit(String direction, Door door);
    String getShortDescription();
    String getlLongDescription();
    String getExitString();
    Door getExit(String direction);
    void setExits(HashMap<String, Door> exits);
    void setRoom(Room room);
}
