
/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy
{
    private String name;
    private int money;
    private int henchmen;
    private int respect;
     
    public Enemy() 
    {
        name = name;
        money = 0;
        henchmen = 0;
        respect = 0;
    }

    public Enemy(int money, int henchmen, int respect, String name) // for MobBosses
    {
        this.name = name;
        this.money = money;
        this.henchmen = henchmen;
        this.respect = respect;
    }

    public String getName()
    {
        return this.name;
    }
    
    public int getHenchmen()
    {
        return this.henchmen;
    }
    
    public int getMoney()
    {
        return this.money;
    }
    
    public int getRespect()
    {
        return this.respect;
    }
    
    // public void kill(MobBoss killer, Enemy victim)
    // {
        // killer.setMoney(killer.getMoney() + victim.getMoney());
        // killer.setHenchmen((int)Math.round(killer.getHenchmen() + (victim.getHenchmen() * .10)));
        // //what happens to MB who is killed
        // victim.setIsAlive(false);
        // victim.setMoney(0);
        // victim.setRespect(0);
        // victim.setHenchmen(0);
        // for(int i = 0; i >= victim.getOwnedDistricts().size(); i++)
        // {
            // killer.addDistrict(victim.getOwnedDistricts().get(i));
        // }
    // }
}
