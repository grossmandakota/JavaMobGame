
/**
 * Write a description of class RecruitCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecruitCommand extends Command
{
    // instance variables - replace the example below with your own
    private CommandWords commandWords;

    public RecruitCommand()
    {
        super("recruit");
    }

    public boolean execute(Player player)
    {
        int secondWordInt = Integer.parseInt(getSecondWord());

        if(getSecondWord() != null)
            if(player.hasEnough((200 * secondWordInt), 0, 0))
                {
                    player.setHenchmen(player.getHenchmen() + secondWordInt);
                    player.setMoney(player.getMoney() - (200 * secondWordInt));
                    System.out.println("You have recruited " + getSecondWord() + " henchmen for $" + player.getMoney());
                }
            
            else
            {
                System.out.println("You don't have enough money for that.");
            }
        else
        {
            System.out.println("You must enter 'recruit' followed by a number.");
        }
            return false;
    }

}
