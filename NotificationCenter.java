import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.reflect.Method;

/**
 * The Notification Center is designed
 * after the NSNotificationCenter in
 * Cocoa (MacOS)
 *
 * @author (Rodrigo A. Obando)
 * @version (Fall 2018)
 */
public class NotificationCenter
{
    private HashMap<String, ArrayList<ObserverEntry>> observers; // this contains the observers by Notification name
    private static NotificationCenter instance = null; // this is the only instance of the Notification Center (Singleton)
    private Queue<NCCommand> commandQueue;

    /**
     * Default Constructor
     * It is private because it implements the Singleton pattern
     */
    private NotificationCenter()
    {
        observers = new HashMap<String, ArrayList<ObserverEntry>>();
        commandQueue = new LinkedList<NCCommand>();
    }

    /**
     * This is the method to gain access
     * to the only instance of the class
     * It uses lazy instantiation
     */
    public static NotificationCenter getInstance()
    {
        if(instance == null)
        {
            instance = new NotificationCenter();
        }
        return instance;
    }

    /**
     * Inner class ObserverEntry
     * It is used to store information
     * about an observer.
     * It overrides the equals method to
     * be able to have the same observer
     * but for multiple 'callbacks'
     */
    private class ObserverEntry
    {
        Object observer;
        String method;

        ObserverEntry (Object observer, String method)
        {
            this.observer = observer;
            this.method = method;
        }

        public boolean equals(Object other)
        {
            return this.observer.equals(((ObserverEntry)other).observer) && this.method.equals(((ObserverEntry)other).method);
        }
    }

    /**
     * Adds an observer for a given notification name
     */
    public void addObserver(String notificationName, Object observer, String methodName)
    {
        ArrayList<ObserverEntry> entryList = observers.get(notificationName);
        if(entryList == null)
        {
            entryList = new ArrayList<ObserverEntry>();
            observers.put(notificationName, entryList);
        }
        entryList.add(new ObserverEntry(observer, methodName));
    }
    
    /**
     * Queues an add observer command
     */
    public void queueAddObserver(String notificationName, Object observer, String methodName)
    {
        commandQueue.offer(new AddObserver(notificationName, observer, methodName));
    }

    /**
     * Removes an observer for a given notification name
     */
    public void removeObserver(String notificationName, Object observer, String methodName)
    {
        ArrayList<ObserverEntry> entryList = observers.get(notificationName);
        if(entryList != null)
        {
            boolean result = entryList.remove(new ObserverEntry(observer, methodName));
            if(entryList.size() == 0)
            {
                observers.remove(notificationName);
            }
        }

    }
    
    /**
     * Queues an add observer command
     */
    public void queueRemoveObserver(String notificationName, Object observer, String methodName)
    {
        commandQueue.offer(new RemoveObserver(notificationName, observer, methodName));
    }

    public void processQueue()
    {
        while(commandQueue.peek() != null)
        {
            NCCommand command = commandQueue.poll();
            command.execute();
        }
    }
    
    /**
     * Posts a notification to the NotificationCenter
     * It sends notifications to all observers/subscribers
     * to this notification
     */
    public void postNotification(Notification notification)
    {
        ArrayList<ObserverEntry> entryList = observers.get(notification.getName());
        if(entryList != null)
        {
            for(ObserverEntry observerEntry : entryList)
            {
                sendNotification(notification, observerEntry);
            }
            processQueue();
        }
    }
    
    /**
     * Sends a notification to an observer
     * It uses Reflection to invoke the appropriate
     * method stored in the ObserverEntry object
     */
    private void sendNotification(Notification notification, ObserverEntry observerEntry)
    {
        Class cls = observerEntry.observer.getClass();
        Method method = null;
        try
        {
            method = cls.getDeclaredMethod(observerEntry.method, Class.forName("Notification"));
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("sendNotification: " + e);
            return;
        }
        catch(NoSuchMethodException e)
        {
            System.out.println("sendNotification: " + e);
            return;
        }
        try
        {
            method.invoke(observerEntry.observer, notification);
        }
        catch(IllegalAccessException e)
        {
            System.out.println("sendNotification: " + e);
        }
        catch(java.lang.reflect.InvocationTargetException e)
        {
            System.out.println("sendNotification: " + e);
        }
    }

    private abstract class NCCommand
    {
        protected String notificationName;
        protected Object observer;
        protected String methodName;
        
        NCCommand(String notificationName, Object observer, String methodName)
        {
            this.notificationName = notificationName;
            this.observer = observer;
            this.methodName = methodName;
        }
        
        abstract void execute();
    }
    
    private class AddObserver extends NCCommand
    {
        AddObserver(String notificationName, Object observer, String methodName)
        {
            super(notificationName, observer, methodName);
        }
        
        void execute()
        {
            addObserver(notificationName, observer, methodName);
        }
    }

    private class RemoveObserver extends NCCommand
    {
        RemoveObserver(String notificationName, Object observer, String methodName)
        {
            super(notificationName, observer, methodName);
        }
        
        void execute()
        {
            removeObserver(notificationName, observer, methodName);
        }
    }
}
