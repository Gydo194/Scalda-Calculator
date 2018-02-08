/*
 * Calculator core class
 */
package scalda.test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author gydo194 Calculator core class Known issues: 1. stdout and stderr mess
 * up when printing to both within short intervals.
 */
public class CalculatorCore {
    //enum State { FIRST, LAST };

    Scanner in = null;
    int first;
    int last;
    char operator;

    public CalculatorCore() {
        in = new Scanner(System.in);
        init();
    }

    /*
    private void init() {
      State state = State.FIRST; 
      while(in.hasNext()) {
        char current = this.in.next().charAt(0);
        System.out.println("current = " + current);
        if(!Character.isDigit(current))  {
            parseOperator(current);
            state = State.LAST;
        }
        else {
            this.buffer[bufpos]  = current;
            bufpos++;
        }
      } 
      //processReceivedInputs();
      bufpos = 0;
    }
     */
    private void init() {
        System.out.println("Welcome to the world's worst interactive commandline calculator!\nAuthor: Gydo194");
        System.out.println("Operators available: + (add) - (subtract) * (multiply) / (divide) ^ (power) ? (square)");
        System.out.println("Type 'exit' to exit.");

        while (true) {

            System.out.print("Calculator> ");
            //System.out.println("Value 1:");
            //this.first        = this.in.nextInt();
            //System.out.println("Operand:");
            //this.operand = this.in.next().toCharArray()[0];
            //System.out.println("Value 2");
            //this.last       = this.in.nextInt();
            String input = this.in.nextLine();
            if (input.contains("exit")) {
                System.exit(0);
            }
            //clear the screen
            if (input.contains("clear")) {
                for (int i = 0; i < 20; i++) {
                    System.out.println();
                }
            }

            String split[] = {"E", "E", "E"};

            //try to get input from user
            try {
                split = input.split(" ");
            } catch (Exception e) {
                
                //looks like this doesn't throw anything when it can't split.
                
                
                System.err.println("Could not split");

                //could not get proper input from user. Set values to default.
            }
            //cannot use finally block due to variable scope :(

            //get first value from user input
            try {
                this.first = Integer.parseInt(split[0]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                //that darn user gave invalid input AGAIN :(
                //System.err.println("Error: could not get first value; defaulting to 0");
                //split[0] = "E";
                this.first = 0;
            }

            //get operator from user input
            try {
                this.operator = split[1].toCharArray()[0];
            } catch (ArrayIndexOutOfBoundsException e) {
                //should not happen because of the default value mechanism,
                //but better be safe.
                //System.err.println("ERROR: cannot parse operator");
                //split[1] = "E"; 
                this.operator = '+';
            };

            //get last value from user input
            try {
                this.last = Integer.parseInt(split[2]);
            } catch (ArrayIndexOutOfBoundsException e) {
                //System.err.println("ERROR: cannot parse last value, defaulting to 0");
                //split[2] = "E";
                this.last = 0;
            }
            /*
                    System.out.println("Dumping array");
                    System.out.println(split);
                    System.out.printf("Dumping values: first = %d, last = %d, operand = %c.\n", this.first,this.last,this.operand);
             */

            //}catch (InputMismatchException e) {
            //        System.err.println("Could not parse input");
            //       System.exit(1);
            //   }
            //System.out.printf("Value 1: %d\nValue 2: %d\nOperand: %c\n",this.first,this.last,operand);
            if (this.first == 0 && this.last == 0 && this.operator == '+')
            //default values set, something went wrong above
            {
                System.err.println("ERROR: cannot use input.");
            } else {
                processCalculation(this.operator);
            }
        }

    }

    private void processCalculation(char request) {

        switch (request) {
            case '+':
                //System.out.println("Got +");
                //Calculator.add(this.first,this.last);
                System.out.println("Result:");
                System.out.println(Calculator.add(this.first, this.last));
                break;
            case '-':
                //System.out.println("Got -");
                System.out.println("Result:");
                System.out.println(Calculator.subtract(this.first, this.last));
                break;
            case '*':
                //System.out.println("Got *");
                System.out.println("Result:");
                System.out.println(Calculator.multiply(this.first, this.last));
                break;
            case '/':
                //System.out.println("Got /");
                System.out.println("Result:");
                System.out.println(Calculator.devide(this.first, this.last));
                break;
            case '?':
                //System.out.println("Got ?");
                System.out.println("Result:");
                System.out.println(Calculator.square(this.first));
                break;
            case '^':
                //System.out.println("Got ^");
                System.out.println("Result:");
                System.out.println(Calculator.exponentiation(this.first, this.last));
                break;
            default:
                System.out.println("calculatorCore::parseOperator(): Cannot parse operator with charcode " + (int) request);
                break;

        }

    }

}
