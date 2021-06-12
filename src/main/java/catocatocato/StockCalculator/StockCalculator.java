package catocatocato.StockCalculator;

import catocatocato.StockCalculator.FileManagement.FileManagement;
import catocatocato.StockCalculator.Programs.Menu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StockCalculator {

    //initializes input and file management systems
    private final FileManagement FILE_SYSTEM;
    private final Scanner CONSOLE;
    private final Menu MENU;

    public StockCalculator(){

        this.FILE_SYSTEM = new FileManagement();
        this.CONSOLE = new Scanner(System.in);
        this.MENU = new Menu(CONSOLE);

        //runs the start up method before main loop
        onStartup();
        mainLoop();
    }

    public static void main(String[] args){

        //constructs the main
        new StockCalculator();
    }

    //executes on start of the program
    public void onStartup(){

        //this initializes and selects the configuration file
        try {
            File config = FILE_SYSTEM.selectAndInitializeFile("System", "config");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Was not able to create the config file!");
        }

    }

    //looping features of the program go here
    public void mainLoop(){

        //changing this variable to false ends the program
        boolean keepAlive = true;

        String selection;

        //runs the program
        while(keepAlive){

            //gives the user control options
            System.out.println("\n----Type (/X) to exit the program. Type (/M) to return to the menu----\n");

            System.out.println("Type the following commands to start its corresponding program:");
            System.out.println("---------------------------------------------------------------");

            //displays all the programs
            System.out.println(MENU.menuOptions());

            //display the menu for the user
            System.out.print("INPUT: ");
            selection = CONSOLE.nextLine();

            if(selection.equalsIgnoreCase("/x")){
                keepAlive = false;
            }else{

                //runs the program if the user doesn't input X
                MENU.matchProgram(selection);
            }

        }

        //executes once the program ends
        onShutdown();
    }


    //executes on shut down
    public static void onShutdown(){

        System.out.println("Shutting down program....");

        System.exit(1);
    }
}
