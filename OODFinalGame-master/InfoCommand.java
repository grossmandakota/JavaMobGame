
/**
 * Write a description of class InfoCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InfoCommand extends Command
{
    // instance variables - replace the example below with your own
    private CommandWords commandWords;

    /**
     * Constructor for objects of class InfoCommand
     */
    public InfoCommand()
    {
        super("info");
    }

    public boolean execute(Player player)
    {
        if(getSecondWord() == null)
        {
            System.out.println("Player information: ");
            System.out.println("Owned Districts: ");
            for(int i = 0; i < player.getOwnedDistricts().size(); i++)
            {
                System.out.print(player.getOwnedDistricts().get(i).getShortDescription() + ", ");
            }
            System.out.println("\nItems owned: ");
            player.printStringOf();
            System.out.println("Player respect: " + player.getRespect() + " player money: " + player.getMoney() + " player henchmen: " + player.getHenchmen());
        }
        return false;
    }
}
