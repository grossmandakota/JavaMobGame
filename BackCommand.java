
/**
 * Write a description of class BackCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BackCommand extends Command
{
    
    public BackCommand()
    {
        super("back");
    }

    public boolean execute(Player player)
    {
        if(getSecondWord() == null && getThirdWord() == null) {
            player.setCurrentRoom(player.beenThere.lastIndexOf(Object()));
            return false;
        }
        else {
            System.out.println("I can not go back to that");
            return false;
        }
    }
}
