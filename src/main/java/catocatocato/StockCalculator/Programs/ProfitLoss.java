package catocatocato.StockCalculator.Programs;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class ProfitLoss extends ProgramFormat{
    public ProfitLoss(Scanner CONSOLE) {
        super(CONSOLE);
    }

    @Override
    public String getDesc() {
        return "P/L Analysis for options";
    }

    @Override
    public void runProgram() {
        System.out.println("\nRunning P/L Program; /M to return to the menu; /X to exit StockCalculator.");

        inputOptions();
    }

    private ArrayList<String> inputOptions(){

        String userInput = null;

        boolean runFlag = true;

        Stock stock = null;

        ArrayList<String> optionValues = new ArrayList<>();

        while(runFlag) {
            System.out.println("Please enter the stock ticker: ");
            userInput = promptInput();

            //gathers the stock based on user input
            try {
                //returns to menu if /M was entered
                if (userInput == null) {
                    runFlag = false;
                    break;
                }

                stock = YahooFinance.get(userInput);
                System.out.println(stock);

                //analyzes the stock if it's valid
                if(stock != null) {
                    System.out.println("\nType /B to go back; Type /C to complete entering in options");
                    System.out.println("Enter your options in the following format:");
                    System.out.println("[P (Put)/C (Call)], STRIKE PRICE, # OF CONTRACTS (Optional; Defaults to 1)");

                    //analyzes the user's inputs
                    while (true) {
                        userInput = promptInput();

                        //returns to menu if M was entered
                        if (userInput == null || userInput.equalsIgnoreCase("/c")) {
                            runFlag = false;
                            break;
                        }

                        if (userInput.equalsIgnoreCase("/b")) {
                            //returns back if /B was entered
                            break;
                        } else {
                            //analyzes the stock
                            String[] optionBuffer = userInput.split(",");

                            //checks each individual argument of the user's input and re-prompts user input if incorrect.

                            //checks if min args is reached
                            if (optionBuffer.length >= 2) {

                                //checks
                                if (optionBuffer[0].equalsIgnoreCase("c") || optionBuffer[0].equalsIgnoreCase("p")) {

                                    try {

                                        //defaults the third value to 1 if missing
                                        if(optionBuffer.length == 2){
                                            userInput += ",1";
                                        }else{
                                            Integer.parseInt(optionBuffer[2]);
                                        }

                                        Double.parseDouble(optionBuffer[1]);

                                        optionValues.add(userInput.replace(" ",""));

                                        System.out.println("Successfully added: [" + userInput + "]\n");
                                    } catch (NumberFormatException e) {
                                        System.out.println("The second/third arguments must be a number!");
                                    }
                                } else {
                                    System.out.println("You must enter 'P' or 'C' for the first argument!");
                                }

                            } else {
                                System.out.println("Missing arguments!");
                            }

                        }
                    }
                }else {
                    System.out.println("Invalid Stock Name!");
                }
            }catch (IOException e) {
                e.printStackTrace();
                System.out.println("An error occurred!");
            }
        }

        if(userInput != null){

        }

        return optionValues;
    }
}
