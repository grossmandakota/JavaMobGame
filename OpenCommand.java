
/**
 * Write a description of class OpenCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenCommand extends Command
{
    

    /**
     * Constructor for objects of class OpenCommand
     */
    public OpenCommand()
    {
        super("open");
    }
    
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {       
           
            String direction = getSecondWord();
            player.open(direction);
        }
        
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Open what");
        }
        return false;
    }
}
