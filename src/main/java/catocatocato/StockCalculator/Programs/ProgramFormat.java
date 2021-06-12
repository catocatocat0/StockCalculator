package catocatocato.StockCalculator.Programs;

import java.util.Scanner;
import static catocatocato.StockCalculator.StockCalculator.onShutdown;

public abstract class ProgramFormat {

    protected final Scanner CONSOLE;

    public ProgramFormat(Scanner CONSOLE){
        this.CONSOLE = CONSOLE;
    }

    //returns the program's description
    public abstract String getDesc();

    //runs the program
    public abstract void runProgram();

    /*
    returns and parses the user's input

    returns the user's input
    returns null if user inputs "M"
    shuts down the program if user inputs "X"
     */
    public String promptInput(){

        System.out.print("INPUT: ");
        String userInput = CONSOLE.nextLine();

        switch (userInput.toLowerCase()){

            case "/x":
                onShutdown();
                break;

            case "/m":
                userInput = null;
                break;
        }

        return userInput;
    }
}
