
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
     * This method kills the mobBoss that is selected if the player meets the requirements 
     * After it is executed the player will own new districts, more henchmen, loose respect and gain money.
     * the kill method is in MobBoss
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