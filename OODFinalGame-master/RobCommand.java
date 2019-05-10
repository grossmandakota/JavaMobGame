
/**
 * Write a description of class RobCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RobCommand extends Command
{
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
        if(hasSecondWord())
        {
            player.steal(player);
        }

        else {
            System.out.println("Rob what?");
        }
        return false;
    }
}
