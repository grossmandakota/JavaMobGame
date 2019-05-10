
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
        int secondWordInt = Integer.parseInt(getSecondWord());//number of items being sold
        if(hasSecondWord())
        {
            boughtItem.setNumItem(secondWordInt); //sets second word to number of item
        }
        else
        {
            System.out.println("Input the number and name of the item you want to purchase.");
        }
        if(hasThirdWord())
        {
            boughtItem.setName(getThirdWord()); //sets third word to name of item
        }
        else
        {
            System.out.println("Input the name of the item you want to purchase.");
        }

        if(hasSecondWord() && hasThirdWord())
        {
            if(boughtItem.isAcceptableItem())//if the item is part of acceptable item choices
            {
                if(player.getCurrentRoom() == hMapOfRooms.get("shop")) //if you're in the shop
                {
                    if(player.hasEnough(boughtItem.getIndividualCost() * boughtItem.getNumItem(), 0, 0)) //if the player has enough money
                    {
                        if(player.checkWeight()) //if player weight is right
                        {
                            {
                                player.setMoney(player.getMoney() - (boughtItem.getIndividualCost() * boughtItem.getNumItem())); //set player money
                                player.addItem(boughtItem); //adds item/number of item
                                player.printStringOf(); //prints out items player owns now
                            }
                        }
                        else
                        {
                            System.out.println("You're carrying too much. Sell some things and keep your number of items below 1000.");
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
                System.out.println("Choose an acceptable item.");
            }
        }

        return false;
    }
}