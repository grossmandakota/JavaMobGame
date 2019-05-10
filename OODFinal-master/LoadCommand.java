import java.io.*;
import java.util.*;
/**
 * Write a description of class Load here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoadCommand extends Command
{
    public LoadCommand()
    {
        super("load");
    }

    public boolean execute(Player player)
    {
        try{
            if(hasSecondWord()) {       
                String saveName = getSecondWord();
                File tempFile = new File("save.cfg");
                if(tempFile.exists() == false)
                {
                    System.out.println("No saves present");
                    return false;   
                }
                Scanner scan = new Scanner(tempFile);
                scan.nextLine();
                while(scan.hasNext()){//iterate through all saves
                    String tmp[]= scan.nextLine().split(",");
                    if(saveName.equals(tmp[0]))
                    {
                        player.setMoney(Integer.parseInt(tmp[1]));
                        player.setRespect(Integer.parseInt(tmp[2]));
                        player.setHenchmen(Integer.parseInt(tmp[3]));
                        /*
                        System.out.println(tmp[0]);
                        System.out.println(tmp[1]);
                        System.out.println(tmp[2]);
                        System.out.println(tmp[3]);
                         */
                        for(int i=4; i < tmp.length; i++)
                        {
                            
                        }
                        System.out.println("Save " + "'"+saveName+"' loaded");
                        return false;
                    }
                }
                System.out.println("Save not found");
            }
            // if third word is a drection
            else {
                // if there is no second word, we don't know what save to load...
                System.out.println("What save do you want to load?");
            }
        }catch(IOException e){
            System.out.println("File not found");   
        }
        return false;
    }
}