
/**
 * Write a description of class ExtortCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExtortCommand extends Command
{
    // instance variables - replace the example below with your own
    private int dMoney;
    private int extortMoney;
    private CommandWords commandWords;
    
    /**
     * Constructor for objects of class ExtortCommand
     */
    public ExtortCommand()
    {
        super("extort");
    }

     public boolean execute(Player player)
    {
        if(hasSecondWord())
        {
            for(int i=0; i < player.getOwnedDistricts().size(); i++)
            {
                if(player.getCurrentRoom() == player.getOwnedDistricts().get(i))
                {
                    dMoney = (int)(player.getMoney()*(10.0f/100.0f));
                    player.setMoney(player.getMoney() + dMoney);
                    player.setRespect(player.getRespect() + 100);
                }
                else {
                    System.out.println("You do not own that district");
                }
            }
        }
        else {
        System.out.println("extort what?");
        }
        return false;
    }
}
