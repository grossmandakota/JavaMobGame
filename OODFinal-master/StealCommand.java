
/**
 * Write a description of class StealCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StealCommand extends Command
{

    public StealCommand()
    {
        super("steal");
    }

    public boolean execute(Player player)
    {
        // if(hasSecondWord()){
        // String deadGuy = getSecondWord();
        // player.steal(player, deadGuy);
        // }
        //System.out.println(hasSecondWord() +"" + hasThirdWord()); //debugging third word parser
        if(hasThirdWord()){
            String deadGuy = getSecondWord();
            int amount = Integer.parseInt(getThirdWord());
            player.steal(player, deadGuy, amount);
        }

        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Steal how much and from who?");
        }
        return false;  
    }
}
