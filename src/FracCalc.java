import java.util.*;

public class FracCalc {

	/**
	 * Prompts user for input, passes that input to produceAnswer, then outputs the
	 * result.
	 * 
	 * @param args - unused
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter an operation.");
		String operation = "";
		operation = console.nextLine();
		while (!operation.equals("quit")) {
			double answer = produceAnswer(operation);
			System.out.println("The answer is "+answer);
			System.out.println("Please enter another operation.");
			operation = console.nextLine();
		}
		// TODO: Read the input from the user and call produceAnswer with an equation
		// Checkpoint 1: Create a Scanner, read one line of input, pass that input to
		// produceAnswer, print the result.
		// Checkpoint 2: Accept user input multiple times.
	}

	/**
	 * produceAnswer - This function takes a String 'input' and produces the result.
	 * 
	 * @param input - A fraction string that needs to be evaluated. For your
	 *              program, this will be the user input. Example: input ==> "1/2 +
	 *              3/4"
	 * @return the result of the fraction after it has been calculated. Example:
	 *         return ==> "1_1/4"
	 */
	public static double produceAnswer(String input) {
		int firstspace = input.indexOf(" ");
		String firstOperand = input.substring(0, firstspace);
		int slash = firstOperand.indexOf("/");
		int underscore=firstOperand.indexOf("_");
		String whole = firstOperand.substring(0,underscore);
		String numerator = firstOperand.substring(underscore+1,slash);
		String denominator= firstOperand.substring(slash+1,firstOperand.length());
		int x = Integer.parseInt(whole);
		int y = Integer.parseInt(numerator);
		int z = Integer.parseInt(denominator);
		double firstdec = toDecimal(x,y,z);
		String afterspace = input.substring(firstspace+1);
		int secondspace = afterspace.indexOf(" ");
		String operator = afterspace.substring(0, 1);
		String secondOperand = afterspace.substring(secondspace+1);
		slash=secondOperand.indexOf("/");
		underscore=secondOperand.indexOf("_");
		whole = secondOperand.substring(0,underscore);
		numerator = secondOperand.substring(underscore+1,slash);
		denominator= secondOperand.substring(slash+1,secondOperand.length());
		x = Integer.parseInt(whole);
		y = Integer.parseInt(numerator);
		z = Integer.parseInt(denominator);
		double seconddec=toDecimal(x,y,z);
		double answer = 0;
		if(operator.equals("+")) {
			answer = add(firstdec,seconddec);
		}
		else if(operator.equals("-")) {
			answer = sub(firstdec,seconddec);
		}
		else if(operator.equals("*")) {
			answer = mul(firstdec,seconddec);
		}
		else if(operator.equals("/")) {
			answer = div(firstdec,seconddec);
		}
		return answer;
		
		/*String afterspace = input.substring(firstspace + 1);
		int secondspace = afterspace.indexOf(" ");
		String operator = afterspace.substring(0, secondspace + 1);
		String secondOperand = afterspace.substring(secondspace + 1);
		slash = secondOperand.indexOf("/");
		underscore = secondOperand.indexOf("_");
		int wholenum = 0;
		int numeratornum = 0;
		int denominatornum = 0;
		String whole = ("");
		String numerator = ("");
		String denominator = ("");
		if (slash != -1&&underscore>0) {
			whole = secondOperand.substring(0, underscore);
			numerator = secondOperand.substring(underscore + 1, slash);
			denominator = secondOperand.substring(slash + 1, secondOperand.length());
		} else if (slash == -1) {
			whole = secondOperand;
			numerator = ("0");
			denominator = ("1");
		} else if (underscore == -1) {
			whole = ("0");
			numerator = secondOperand.substring(underscore + 1, slash);
			denominator = secondOperand.substring(slash + 1, secondOperand.length());
		}
		wholenum = Integer.parseInt(whole);
		numeratornum = Integer.parseInt(numerator);
		denominatornum = Integer.parseInt(denominator);
		secondOperand=("whole:" + wholenum + " " + "numerator:" + numeratornum + " " + "denominator:" + denominatornum );
		return secondOperand;*/
		// TODO: Implement this function to produce the solution to the input
		// Checkpoint 1: Return the second operand. Example "4/5 * 1_2/4" returns
		// "1_2/4".
		// Checkpoint 2: Return the second operand as a string representing each part.
		// Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
		// Checkpoint 3: Evaluate the formula and return the result as a fraction.
		// Example "4/5 * 1_2/4" returns "6/5".
		// Note: Answer does not need to be reduced, but it must be correct.
		// Final project: All answers must be reduced.
		// Example "4/5 * 1_2/4" returns "1_1/5".

	}

	public static double toDecimal(int a, int b,int c) {
		double x = a*c;
		double y= x + b;
		double z = y / c;
		return z;
	}
	public static double add(double a, double b) {
		double x = a+b;
		return x;
	}
	public static double sub(double a, double b) {
		double x = a-b;
		return x;
	}
	public static double mul(double a, double b) {
		double x = a*b;
		return x;
	}
	public static double div(double a, double b) {
		double x = a/b;
		return x;
	}
}
