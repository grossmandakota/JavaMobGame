
/**
 * Write a description of class Items here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item

{
    private int numOfItem;
    private int level;
    private int individualCost;
    private String name;
    /**
     * Constructor for objects of class Items
     */
    public Item()
    {
        this(1, 1, "no name");
    }
    
    public Item(int numOfItem, int level, String name)
    {
        this.numOfItem = numOfItem;
        this.level = level;
        this.name = name;
        if(this.getName().equalsIgnoreCase("guns"))
        {
            this.setIndividualCost(200);
        }
        
        if(this.getName().equalsIgnoreCase("drugs"))
        {
            this.setIndividualCost(20);
        }
        
        if(this.getName().equalsIgnoreCase("armor"))
        {
            this.setIndividualCost(100);
        }
    }

    public int getNumItem()
    {
        return numOfItem;
    }
    
    public void setNumItem(int numOfItem)
    {
        this.numOfItem = numOfItem;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public void setLevel(int level)
    {
        this.level = level;
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
    
    public boolean isAcceptableItem()
    {
        if(this.getName().equalsIgnoreCase("guns"))
        {
            this.setIndividualCost(100);
            return true;
        }
        
        if (this.getName().equalsIgnoreCase("drugs"))
        {
            this.setIndividualCost(20);
            return true;
        }
        
        if (this.getName().equalsIgnoreCase("armor"))
        {
            this.setIndividualCost(50);
            return true;
        }
        
        else
        {
            return false;
        } 
    }
    
    public void itemValueMultiplier()
    {
        if (this.getLevel() == 2)
        {
            this.setIndividualCost(this.getIndividualCost() + 25);
        }
        
        if (this.getLevel() == 3)
        {
            this.setIndividualCost(this.getIndividualCost() + 50);
        }
    }
    
    public String toString()
    {
        return this.getName();
    }
}