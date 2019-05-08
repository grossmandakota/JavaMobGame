
/**
 * Write a description of class BuyCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;

public class BuyCommand extends Command
{
    private CommandWords commandWords;

    public BuyCommand()
    {
        super("buy");
    }

    public boolean execute(Player player)
    {
        HashMap<String, Room> hMapOfRooms = new HashMap<String, Room>();//setup hashmap
        hMapOfRooms = GameWorld.getInstance().getHMapOfRooms();
        Item boughtItem = new Item();
        int secondWordInt = Integer.parseInt(getSecondWord());
        if(hasSecondWord())
        {
            boughtItem.setNumItem(secondWordInt);
        }
        else
        {
            System.out.println("Input the number and name of the item you want to purchase.");
        }
        if(hasThirdWord())
        {
            boughtItem.setName(getThirdWord());
        }
        else
        {
            System.out.println("Input the name of the item you want to purchase.");
        }

        if(hasSecondWord() && hasThirdWord())
        {
            if(boughtItem.isAcceptableItem())
            {
                if(player.getCurrentRoom() == hMapOfRooms.get("shop"))
                {
                    if(player.hasEnough(boughtItem.getIndividualCost() * boughtItem.getNumItem(), 0, 0))
                    {

                        {
                            player.setMoney(player.getMoney() - (boughtItem.getIndividualCost() * boughtItem.getNumItem()));
                            player.addItem(boughtItem);
                            player.printStringOf();
                        }
                    }
                    else
                    {
                        System.out.println("You don't have enough money for that.");
                    }
                }
                else
                {
                    System.out.println("You can only make purchases in the trading district.");
                }
            }

            else
            {
                System.out.println("That ain't it");
            }
        }

        return false;
    }
}
