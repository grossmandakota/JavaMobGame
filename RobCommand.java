
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

    public boolean execute(Player player)
    {
      String victum = getSecondWord();
        
      //player.steal(player, victum);  
      return false;
    }
}
