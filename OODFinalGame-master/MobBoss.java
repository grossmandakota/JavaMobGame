
/**
 * Abstract class MobBoss - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Arrays;
import java.util.Random;
public class MobBoss
{
    // instance variables - replace the example below with your own
    private Player player;
    private String name;
    private int money;
    private int respect;
    private int henchmen;
    private boolean isAlive;
    private ArrayList<Room> ownedDistricts = new ArrayList<Room>();
    private ArrayList<Item> ownedItems = new ArrayList<Item>();
    private MobBoss bossA;
    private MobBoss bossB;
    private int dMoney;
    private int extortMoney;
    private int weight;
    
    public MobBoss()
    {
        money = 0;
        respect = 0;
        henchmen = 0;
        isAlive = true;
    }

    public MobBoss(int money, int henchmen, int respect, String name)
    {
        this.bossA = bossA;
        this.bossB = bossB;
        this.name = name;
        this.money = money;
        this.henchmen = henchmen;
        this.respect = respect;
        this.name = name;
        this.weight = 0;
        isAlive = true;
    }

    public String getName()
    {
        return this.name;
    }

    public int getMoney()
    {
        return this.money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public int getRespect()
    {
        return this.respect;
    }

    public void setRespect(int respect)
    {
        this.respect = respect;
    }

    public boolean getIsAlive()
    {
        return this.isAlive;   
    }

    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;  
    }

    public int getHenchmen()
    {
        return this.henchmen;
    }

    public void setHenchmen(int henchmen)
    {
        this.henchmen = henchmen;
    }
 
    public ArrayList<Item> getOwnedItems()
    {
        return this.ownedItems;
    }
    
    public void addItem(Item item)
    {
        for(int i = 0; i < this.ownedItems.size(); i++)
        {
            //if the item name is already in the list, it just adds to the number of items
            //instead of creating a new one
            if(item.getName().equals(this.ownedItems.get(i).getName()))
            {
                item.setNumItem(item.getNumItem() + this.ownedItems.get(i).getNumItem());
                this.ownedItems.remove(this.ownedItems.get(i));
            }
        }   
        this.ownedItems.add(item);
    }

    public void removeItem(Item item)
    {
        this.ownedItems.remove(item);
    }
    
    public ArrayList<Room> getOwnedDistricts()
    {
        return this.ownedDistricts;
    }
    
    /*
     * adds district to the owner while passing in the district(Room)
     */
    public void addDistrict(Room room)
    {
        //System.out.println(room.getShortDescription());
        this.ownedDistricts.add(room);
        room.setOwner(this);
    }

    public void removeDistrict(Room room)
    {
        this.ownedDistricts.remove(room);
    }
    
    public boolean checkWeight()
    {
        for(int i = 0; i < this.getOwnedItems().size(); i++)
        {
            //adds weight for each item in the players OwnedItems arrayList
            weight = weight + this.getOwnedItems().get(i).getNumItem();
        }
        //flag for weight
        if(weight < 1000)
        {
            return true;
        }
            
        else
        {
            return false;
        }
    }
    
    public int getWeight()
    {
        return this.weight;
    }
    
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
  
    // check if you own the district and if not then if you have enough respect to open it
    public MobBoss getBossFromTheOtherSideOf(MobBoss boss)
    {

        if(boss == bossA)
        {
            return bossB;
        }
        else
        {
            return bossA;
        }
    }
    
    //this method is simply  a flag to check and see if you have enough of whatever to do whatever command you're trying to do 
     public boolean hasEnough(int money, int respect, int henchmen)
    {
        if(this.getMoney() >= money && this.getRespect() >= respect && this.getHenchmen() >= henchmen)//if the requirements in the parameters are met by the player it returns true
        {
            return true;
        }

        else
        {
            return false;
        }
    }
    
    public void steal(Player player)
    {
        Random rand = new Random();
        int randNum = rand.nextInt(3);
        if(player.hasEnough(0, 0, 50)){
                if(randNum == 0 || randNum == 2) // there is a 2/3rd chance the robbery goes right.
                {
                    dMoney = (int)(player.getMoney()*(10.0f/100.0f)); // player takes 10% of their money they have.
                    player.setMoney(player.getMoney() + dMoney);
                    player.setRespect(player.getRespect() + 100);
                    System.out.println("The robbery was successful. You stole $" + dMoney + "and gained 100 respect.");
                }
                if(randNum == 1){
                    player.setHenchmen(player.getHenchmen() - 10);
                    System.out.println("Things did not go according to plan. You did not get any money and you lost ten henchmen!");
                    System.out.println("You now have " + player.getHenchmen() + " henchmen");
                    System.out.println("and you still have " + player.getMoney() + " money");
                }
            }
        else{
                System.out.println("You do not have enought henchmen to rob! You need 50 and you have " + player.getHenchmen());
            }
}

    
    public void kill(MobBoss killer, String victimS)
    {
        HashMap<String, MobBoss> hMapOfMB = new HashMap<String, MobBoss>();//setup hashmap
        hMapOfMB = GameWorld.getInstance().getHMapOfMB();//setup hashmap
        if(hMapOfMB.get(victimS) !=null && (hMapOfMB.get(victimS).isAlive == true))//make sure the victim exists and isnt already dead
        {
            if(killer.hasEnough(0, 800,40))
            {
                killer.setMoney(killer.getMoney() + hMapOfMB.get(victimS).getMoney());//take all of their money
                killer.setHenchmen((int)Math.round(killer.getHenchmen() + (hMapOfMB.get(victimS).getHenchmen() * .10)));//take victims henchmen
                killer.setHenchmen(killer.getHenchmen() - 10); // the henchmen who died in the process
                killer.setRespect(killer.getRespect() - 200); // you will loose respect if you wack a MobBoss
                hMapOfMB.get(victimS).isAlive = false;
                hMapOfMB.get(victimS).money = 0;
                hMapOfMB.get(victimS).respect = 0;
                hMapOfMB.get(victimS).henchmen = 0;
                System.out.println("player before: ");//debug
                for(int i = 0; i < killer.getOwnedDistricts().size(); i++)
                {
                    System.out.print(killer.getOwnedDistricts().get(i).getShortDescription() + ", ");
                }
                //System.out.println("victim before" + hMapOfMB.get(victimS).getOwnedDistricts() + hMapOfMB.get(victimS).getOwnedDistricts().size());//debug
                for(int i = 0; i< hMapOfMB.get(victimS).getOwnedDistricts().size(); i++)//loop to transfer all disticts the victim owned to the player
                {
                    killer.addDistrict(hMapOfMB.get(victimS).getOwnedDistricts().get(i));//give districts to player
                    hMapOfMB.get(victimS).removeDistrict(hMapOfMB.get(victimS).getOwnedDistricts().get(i));//take them away from the victim
                    i=i-1;//hack to counteract the list size changing 
                }
                System.out.println();
                System.out.println("player now: ");
                for(int i = 0; i < killer.getOwnedDistricts().size(); i++)
                {
                    System.out.print(killer.getOwnedDistricts().get(i).getShortDescription() + ", ");
                }
                //System.out.println("victim" + hMapOfMB.get(victimS).getOwnedDistricts() + hMapOfMB.get(victimS).isAlive);
            }
            else {
                System.out.println("You do not have enough respect or henchmen to wack " + victimS);
                System.out.println("You need atleast 800 respect and 40 henchmen");
            }
        }

        else
        {
            System.out.println("MobBoss '" + victimS + "' was not found");
        }
    }
    
    public void printStringOf()
    {
        for(int i = 0; i < this.ownedItems.size(); i++)
        {
            System.out.println(this.ownedItems.get(i).getName() + " " + this.ownedItems.get(i).getNumItem()); //prints out item player owns and number of that item.
        }
    }
    
}