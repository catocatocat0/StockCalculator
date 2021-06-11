package catocatocato.StockCalculator.Programs;

import java.util.Scanner;

public abstract class ProgramFormat {

    protected final Scanner CONSOLE;

    public ProgramFormat(Scanner CONSOLE){
        this.CONSOLE = CONSOLE;
    }

    //returns the program's description
    public abstract String getDesc();

    //runs the program
    public abstract void runProgram();
}
