
/**
 * Write a description of class Items here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item

{
    private int numOfItem;
    private int levelOfItem;

    /**
     * Constructor for objects of class Items
     */
    public Item()
    {
        this(1, 1);
    }
    
    public Item(int numOfItem, int levelOfItem)
    {
        this.numOfItem = numOfItem;
        this.levelOfItem = levelOfItem;
    }

}
