
/**
 * Write a description of class SellCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;
public class SellCommand extends Command
{
    private CommandWords commandWords;

    public SellCommand()
    {
        super("sell");
    }

    public boolean execute(Player player)
    {
        HashMap<String, Room> hMapOfRooms = new HashMap<String, Room>();//setup hashmap
        hMapOfRooms = GameWorld.getInstance().getHMapOfRooms();
        int secondWordInt = Integer.parseInt(getSecondWord());
        //if the player is in the shop
        if(player.getCurrentRoom() == hMapOfRooms.get("shop"))
        {
            //cycles through the list of players items
            for(int i = 0; i < player.getOwnedItems().size(); i++)
            {
                Item tempItem = player.getOwnedItems().get(i);
                //if the third word the user inputs has the same name as an item
                if(getThirdWord().equalsIgnoreCase(tempItem.getName()))
                {
                    //item count for player decreases depending on how many you sold
                    tempItem.setNumItem(tempItem.getNumItem() - secondWordInt);
                    //if there are 0 items
                    if(tempItem.getNumItem() < 0)
                    {
                        player.removeItem(tempItem);
                        player.printStringOf();
                    }
                    //if there are still items left
                    else
                    {
                        player.setMoney(player.getMoney() + (tempItem.getIndividualCost() * secondWordInt));
                        player.printStringOf();
                    }
                }
            }
        }
        else
        {
            System.out.println("You have to be in the trading district to sell items.");
        }
        return false;
    }
}
