import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018)
 * @version 1.1 (December 2002)
 */

class Parser 
{

    private CommandWords commands;  // holds all valid command words

    public Parser() 
    {
        this(new CommandWords());
    }
    
    public Parser(CommandWords commands)
    {
        this.commands = commands;
    }

    public Command getCommand() 
    {
        String inputLine = "";   // will hold the full input line
        String word1;
        String word2;
        String word3;

        System.out.print("> ");     // print prompt

        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: "
                                + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);  // "you are good" ->  word1->"you" word2->"are" word3->"good"

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // get second word
        else
            word2 = null;
        if(tokenizer.hasMoreTokens())           // get third word
            word3 = tokenizer.nextToken();
        else
            word3 = null;
        // note: we just ignore the rest of the input line.

        Command command = commands.get(word1);
        if(command != null) {
            command.setSecondWord(word2);   // third word will not be put in command
        }
        
        //System.out.println("w2: " +word2+ " w3: " +word3);//debugging third word parser
        if(command != null && word2 != null) {
            command.setThirdWord(word3);   // dont know if it works
        }
        return command;
    }

    /**
     * Print out a list of valid command words.
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
