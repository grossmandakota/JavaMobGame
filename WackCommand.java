
/**
 * Write a description of class WackCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WackCommand extends Command
{
    private CommandWords commandWords;

    /**
     * Constructor for objects of class WackCommand
     */
    public WackCommand() //CommandWords words was in the arguments but i dont think we need it
    {
        super("wack");
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return the sum of x and y
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()){
            String deadGuy = getSecondWord();
            player.kill(player, deadGuy);
        }

        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Wack who?");
        }
        return false;  
    }
}