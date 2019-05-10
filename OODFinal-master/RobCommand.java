
/**
 * Write a description of class RobCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
public class RobCommand extends Command
{
    private int dMoney;
    private int extortMoney;
    private CommandWords commandWords;

    public RobCommand()
    {
        super("rob");
    }

    /*
     * This allows the player to rob districts.
     * This adds money and respect to the player.
     * Careful, you can loose henchmen in a random chance that 
     * everything goes sour
     */
    public boolean execute(Player player)
    {
       Random rand = new Random();
        int randNum = rand.nextInt(3);
        if(hasSecondWord())
        {
                if(randNum == 0 || randNum == 2)
                {
                    dMoney = (int)(player.getMoney()*(10.0f/100.0f));
                    player.setMoney(player.getMoney() + dMoney);
                    player.setRespect(player.getRespect() + 100);
                }
                if(randNum == 1){
                    player.setHenchmen(player.getHenchmen() - 10);
                    System.out.println("Things did not go according to plan. You did not get any money and you lost ten henchmen!");
                    System.out.println("You now have " + player.getHenchmen() + "henchmen");
                    System.out.println("and you still have " + player.getMoney() + "money");
                }
        }
        else {
        System.out.println("Rob what?");
        }
        return false;
    }
}
