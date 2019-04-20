import java.util.HashMap;

/**
 * This class is used to move
 * information from one object to 
 * another and invoke a method
 * This is akin to notification in Cocoa
 * implemented in Objective-C
 *
 * @author (Rodrigo A. Obando)
 * @version (Fall 2018)
 */
public class Notification
{
    private String name; // Name of the notification
    private Object object; // Object of interest, sometimes the object that generates the notification
    private HashMap<String, Object> userInfo; // extra information sent by the object

    /**
     * Default Constructor
     */
    public Notification()
    {
        this("NotificationName");
    }
    
    public Notification(String name)
    {
        this(name, null);
    }
    
    public Notification(String name, Object object)
    {
        this(name, object, null);
    }
    
    /**
     * Designated Constructor
     */
    public Notification(String name, Object object, HashMap<String, Object> userInfo)
    {
        this.name = name;
        this.object = object;
        this.userInfo = userInfo;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Object getObject()
    {
        return object;
    }
    
    public HashMap<String, Object> getUserInfo()
    {
        return userInfo;
    }
}
