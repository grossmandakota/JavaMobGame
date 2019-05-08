
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

    /*
     * This allows the player to go back to the 
     * previous room 
     */
    public boolean execute(Player player)
    {
        if(getSecondWord() == null && getThirdWord() == null) {
            player.back(player);//stack push and pop
            return false;
        }
        else {
            System.out.println("I can not go back to that");
            return false;
        }
    }
}
