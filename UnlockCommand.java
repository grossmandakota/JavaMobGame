
/**
 * Write a description of class UnlockCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UnlockCommand extends Command
{

    public UnlockCommand()
    {
        super("unlock");
    }

    public boolean execute(Player player)
    {
    if(hasSecondWord()) {       
            String direction = getSecondWord();
            player.Unlock(direction);
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Can not unlock that");
        }
        return false;
    
    }
}
