
/**
 * Write a description of class Singleton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Singleton<E>
{
    // instance variables - replace the example below with your own
    private E instance;

    /**
     * Constructor for objects of class Singleton
     */
    public Singleton()
    {
        
    }

    
    public E getInstance()
    {
        if(instance==null)
        {
            instance = (E)new Object(); 
        }
        return instance;
    }
}
