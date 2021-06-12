package catocatocato.StockCalculator.Programs;

import java.util.Scanner;

/*
Test program which only prints out "Program Ran Successfully!"
 */
public class Test extends ProgramFormat{

    public Test(Scanner CONSOLE) {
        super(CONSOLE);
    }

    @Override
    public String getDesc() {
        return "Debug test program";
    }

    @Override
    public void runProgram() {
        System.out.println("Program Ran Successfully!");
    }

}
