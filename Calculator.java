/**
 * Calculator class
 */

package scalda.test;

public class Calculator {

    /*
	 * Methode main hieronder kan je verwijderen nadat het importeren gelukt is.
     */
 /*
	public static void main(String[] args){
		System.out.println("Test of de import goed werkt...");
	}
     */
 /*
	 * Werk de onderstaande methodes uit.
	 * 
	 * Gebruik enkel de optelling als expressie.
	 * 
	 * Maak gebruik van de nodige control flow structures om de bewerking te vervolledigen
	 * 
	 * Maak gebruik van gehele getallen.
     */
    public static int add(int number1, int number2) {
        //System.out.printf("Calculator::add called with %d,%d.\n",number1,number2);
        return number1 + number2;
    }

    public static int subtract(int number1, int number2) {

        return number1 + -number2;
    }

    public static int multiply(int number1, int number2) {
        int res = 0;
        while (number1 > 0) {
            //res += number2;
            res = add(res,number2);
            number1--;
        }
        return res;
    }

    /*
	 * Zorg ervoor dat number1 deelbaar is door number2
	 * 
	 * Of: wijzig de nodige types zodat je ook andere delingen kan maken.
     */
    public static int devide(int number1, int number2) {
        // HINT: misschien kan je de methode subtract hierbij gebruiken.
        
        int res = 0;

        while (number1 >= number2) {
            //number1 -= number2;
            number1 = subtract(number1, number2);
            res++;
        }

        return res;
    }

    /*
	 * Methode hieronder is voor een tweede machtsverheffing
     */
    public static int square(int number1) {
        // HINT: multiply???
        //g
        return multiply(number1, number1);
    }

    /*
	 * Methode hieronder is voor de verheffing van het grondgetal 'number1' tot een willekeurige macht, het exponent 'number2'
     */
    public static int exponentiation(int number1, int number2) {
        // HINT: multiply???

        //return (int) Math.pow(number1,number2);
        
        int res = 1;
        
        //System.out.printf("Exponentation called =, num1 = %d, num2 = %d.\n", number1,number2);
         /* System.out.printf("While looping, number2 = %d, res = %d.\n", number2,res); */ 
         
         //by
        while(number2 > 0) { res = multiply(res,number1); number2--; }
        
        
        return res;
    }

}
