package catocatocato.StockCalculator.Programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    //stores programs into a hashmap
    private final HashMap<String, ProgramFormat> PROGRAMS;

    public Menu(Scanner CONSOLE){
        this.PROGRAMS = new HashMap<>();

        //adds programs with their identifier
        PROGRAMS.put("TEST", new Test(CONSOLE));
    }

    /*
    Gathers a list of every program's description and their command name and returns a string

    returns a string which contains all the cmd names and program's descriptions
     */
    public String menuOptions(){
        StringBuilder menuOutput = new StringBuilder();

        //loops through each program and gathers their descriptions
        ArrayList<String> programNames = new ArrayList<>(PROGRAMS.keySet());

        for(String programName : programNames){
            menuOutput.append(programName + ": " + PROGRAMS.get(programName).getDesc() + "\n");
        }

        return menuOutput.toString();
    }

    /*
    matches the user's input to a program and runs that program

    command - the user's inputted command name
     */
    public void matchProgram(String command){
        //upper-cases the command
        command = command.toUpperCase();

        //checks if user inputted a valid program
        if(PROGRAMS.containsKey(command)){

            PROGRAMS.get(command).runProgram();
        }else{
            System.out.println("Invalid program! '" + command + "' does not exist.");
        }
    }
}
