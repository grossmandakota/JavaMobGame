
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
    private int individualCost;
    private String name;
    /**
     * Constructor for objects of class Items
     */
    public Item()
    {
        this(1, 1, "no name");
    }
    
    public Item(int numOfItem, int levelOfItem, String name)
    {
        this.numOfItem = numOfItem;
        this.levelOfItem = levelOfItem;
        this.name = name;
    }

    public int getNumItem()
    {
        return numOfItem;
    }
    
    public void setNumItem(int numOfItem)
    {
        this.numOfItem = numOfItem;
    }
    
    public int getLevelOfItem()
    {
        return levelOfItem;
    }
    
    public void setLevelOfItem(int levelOfItem)
    {
        this.levelOfItem = levelOfItem;
    }
    
    public int getIndividualCost()
    {
        return individualCost;
    }
    
    public void setIndividualCost(int individualCost)
    {
        this.individualCost = individualCost;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
}
