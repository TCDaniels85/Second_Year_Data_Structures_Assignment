package mypkg;
import java.util.Scanner;  //import Scanner class to obtain user input as String


/**
 * Main class, this program converts an expression entered by the user from infix to postfix notation.
 * Acknowledgements: references to array and stack source code lecture notes (Gaber, 2019) and 
 * references to the java class libraries (Oracle, 2021)
 * 
 * @author Thomas Christopher Daniels
 *
 */
public class Converter {
	InfixConversion conversion;
	Scanner scanner;
	String infixExp;
	/**
	 * Converter constructor, contains if statements to validate the user input then runs the InfixConversion class
	 * to convert the user expression to postFix.
	 */
	public Converter() 
	{
		conversion = new InfixConversion();		
		System.out.println("**Infix to postfix expression converter**\r\n"
				+ "Please note that the infix expression can be a maximum of 20 characters, \r\n"
				+ "cannot contain numbers and is limited to the operators +, -, /, and *.\r\n"
				+ "Type the word exit, to exit the program.\n");
		//Local variable set to true to enable the do while loop to keep the program running
		boolean running = true;
		do {
		System.out.println("\nPlease enter the infix expression to be converted to postfix:");
		scanner = new Scanner(System.in);
		infixExp = scanner.nextLine();
		//if statements to validate user input
		if (infixExp.equals("")) {	//Checks the user has entered an expression
			System.out.println("Please enter an expression!\n");
		} else if (!conversion.checkParentheses(infixExp)) {
			System.out.println("Please ensure expression does not have any missing parentheses!\n");
		} else if(infixExp.length() > 20) {
			System.out.println("Your infix expression is more than 20 characters long!\n");
		} else if(conversion.containsNumbers(infixExp)) {
			System.out.println("Your expression contains numbers, please only use letters!\n");
		} else if (infixExp.equalsIgnoreCase("exit")){
			running = false;	// sets running to false to allow user to exit the program
			System.out.println("Goodbye");
		} else {			
			conversion.convert(infixExp);
		}
		
		} while (running);
		
		
	}
/**
 *Class iInstantiates an instance of itself, allows for use of non static methods/classes
 * in the constructor.
 */
	public static void main(String[] args) {
		new Converter();

	}
	
	
	
}
