import java.io.*;
import java.util.*;
/**
 * Write a description of class Save here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaveCommand extends Command
{
    public SaveCommand()
    {
        super("save");
    }

    public boolean execute(Player player)
    {
        try{
            if(hasSecondWord()) {       
                String saveName = getSecondWord();
                File tempFile = new File("save.cfg");
                if(tempFile.exists() == false)
                {
                    tempFile.createNewFile();
                    FileWriter writer = new FileWriter(tempFile);
                    writer.write("Name,Money,Respect,Henchmen\n");
                    writer.write(saveName + "," + player.getMoney() + "," + player.getRespect() + "," + player.getHenchmen() + "\n");
                    // for(int i=0; i < player.getOwnedDistricts().size(); i++)
                    // {
                        
                    // }
                    writer.flush();
                    writer.close();
                }

                else
                {
                    Scanner scan = new Scanner(tempFile);
                    scan.nextLine();
                    String tmpString = "Name,Money,Respect,Henchmen\n";
                    while(scan.hasNext()){
                        String curLine = scan.nextLine();
                        String tmp[]= curLine.split(",");
                        if(tmp[0].equals(saveName))
                        {
                            //scan.nextLine();
                        }

                        else
                        {
                            tmpString += curLine + "\n";
                        }
                    }
                    tmpString += saveName + "," + player.getMoney() + "," + player.getRespect() + "," + player.getHenchmen() + "\n";
                    FileWriter writer = new FileWriter(tempFile, false);
                    writer.write(tmpString);
                    writer.flush();
                    writer.close();
                }
            }
            else {
                // if there is no second word, we don't know what to call the save...
                System.out.println("Enter a save name.");
            }
        }catch(IOException e){
            System.out.println("File not found");   
        } 
        return false;
    }
}