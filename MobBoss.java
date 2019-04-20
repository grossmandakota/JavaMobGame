
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
    public MobBoss()
    {
        money = 0;
        respect = 0;
        henchmen = 0;
        isAlive = true;
    }

    public MobBoss(int money, int henchmen, int respect, String name)
    {
        this.name = name;
        this.money = money;
        this.henchmen = henchmen;
        this.respect = respect;
        this.name = name;
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

    public ArrayList<Room> getOwnedDistricts()
    {
        return this.ownedDistricts;
    }

    public void addDistrict(Room room)
    {
        //System.out.println(room.getShortDescription());
        this.ownedDistricts.add(room);
    }

    public void removeDistrict(Room room)
    {
        this.ownedDistricts.remove(room);
    }

    public void steal(MobBoss thief, String victimS, int amountToSteal)
    {
        HashMap<String, MobBoss> hMapOfMB = new HashMap<String, MobBoss>();//setup hashmap
        hMapOfMB = GameWorld.getInstance().getHMapOfMB();//setup hashmap
        if(hMapOfMB.get(victimS).getMoney() >= amountToSteal)//make sure the victim has the amount of money you want to steal
        {
            thief.setMoney(thief.getMoney() + amountToSteal);//give the thief the money
            hMapOfMB.get(victimS).setMoney(hMapOfMB.get(victimS).getMoney() - amountToSteal);//take the money away from the victim
            thief.setHenchmen(thief.getHenchmen() - (int)Math.round(amountToSteal/100));//make the player lose 1 henchmen for each $100 stolen 
        }

        else
        {
            System.out.println("The victim doesn't have that much money!");
        }
        System.out.println("thief: " + thief.getMoney()+ "henchmen: "+ thief.getHenchmen() + "victim: " + hMapOfMB.get(victimS).getMoney());
    }

    public void kill(MobBoss killer, String victimS)
    {
        HashMap<String, MobBoss> hMapOfMB = new HashMap<String, MobBoss>();//setup hashmap
        hMapOfMB = GameWorld.getInstance().getHMapOfMB();//setup hashmap
        if(hMapOfMB.get(victimS) !=null && (hMapOfMB.get(victimS).isAlive == true))//make sure the victim exists and isnt already dead
        {
            //if(killer.getRespect() >= hMapOfMB.get(victimS).getRespect())
            //{
                killer.setMoney(killer.getMoney() + hMapOfMB.get(victimS).getMoney());//take all of their money
                killer.setHenchmen((int)Math.round(killer.getHenchmen() + (hMapOfMB.get(victimS).getHenchmen() * .10)));//take victims money
                hMapOfMB.get(victimS).isAlive = false;
                hMapOfMB.get(victimS).money = 0;
                hMapOfMB.get(victimS).respect = 0;
                hMapOfMB.get(victimS).henchmen = 0;
                //System.out.println(killer.getMoney());
                System.out.println("player before" + killer.getOwnedDistricts());//debug
                System.out.println("victim before" + hMapOfMB.get(victimS).getOwnedDistricts() + hMapOfMB.get(victimS).getOwnedDistricts().size());//debug
                for(int i = 0; i< hMapOfMB.get(victimS).getOwnedDistricts().size(); i++)//loop to transfer all disticts the victim owned to the player
                {
                    killer.addDistrict(hMapOfMB.get(victimS).getOwnedDistricts().get(i));//give districts to player
                    hMapOfMB.get(victimS).removeDistrict(hMapOfMB.get(victimS).getOwnedDistricts().get(i));//take them away from the victim
                    i=i-1;//hack to counteract the list size changing 
                }
                System.out.println("player" + killer.getOwnedDistricts());//debug
                System.out.println("victim" + hMapOfMB.get(victimS).getOwnedDistricts() + hMapOfMB.get(victimS).isAlive);
            //}
            //else {
             //   System.out.println("You do not have enough respect to wack" + victimS);
            //}
        }

        else
        {
            System.out.println("MobBoss '" + victimS + "' was not found");
        }
    }
}