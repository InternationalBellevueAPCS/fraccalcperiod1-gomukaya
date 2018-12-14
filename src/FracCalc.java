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
		while (!operation.equals("quit")) {// fencepost loop that stops when quit is entered
			String answer = produceAnswer(operation);
			System.out.println("The answer is " + answer + ".");
			System.out.println("Please enter another operation.");
			operation = console.nextLine();
		}

	}

	public static String produceAnswer(String input) {
		int firstspace = input.indexOf(" ");
		String firstOperand = input.substring(0, firstspace);
		int slash1 = firstOperand.indexOf("/");
		int underscore1 = firstOperand.indexOf("_");
		String whole = "";
		String numerator = "";
		String denominator = "";
		if (slash1 == -1) { // when there is no fraction
			whole = firstOperand;
			numerator = ("0");
			denominator = ("0");
		} else if (slash1 != -1 && underscore1 == -1) {
			whole=("0");
			numerator = firstOperand.substring(0,slash1);
			denominator = firstOperand.substring(slash1+1,firstOperand.length());
		}else {
			whole = firstOperand.substring(0, underscore1);
			numerator = firstOperand.substring(underscore1 + 1, slash1);
			denominator = firstOperand.substring(slash1 + 1, firstOperand.length());
		}
		int x = Integer.parseInt(whole);
		int y = Integer.parseInt(numerator);
		int z = Integer.parseInt(denominator);
		double firstdec = toDecimal(x, y, z);
		String afterspace = input.substring(firstspace + 1);
		int secondspace = afterspace.indexOf(" ");
		String operator = afterspace.substring(0, 1);
		String secondOperand = afterspace.substring(secondspace + 1);
		int slash2 = secondOperand.indexOf("/");
		int underscore2 = secondOperand.indexOf("_");
		if (slash2 == -1 && underscore2 == -1) {
			whole = secondOperand;
			numerator = ("0");
			denominator = ("0");
		} else if (slash2 != -1 && underscore2 == -1) {
			whole=("0");
			numerator = secondOperand.substring(0,slash2);
			denominator = secondOperand.substring(slash2+1,secondOperand.length());
		} else {
			whole = secondOperand.substring(0, underscore2);
			numerator = secondOperand.substring(underscore2 + 1, slash2);
			denominator = secondOperand.substring(slash2 + 1, secondOperand.length());
		}
		x = Integer.parseInt(whole);
		y = Integer.parseInt(numerator);
		z = Integer.parseInt(denominator);
		double seconddec = toDecimal(x, y, z);
		double answer = 0;
		if (operator.equals("+")) {
			answer = add(firstdec, seconddec);
		} else if (operator.equals("-")) {
			answer = sub(firstdec, seconddec);
		} else if (operator.equals("*")) {
			answer = mul(firstdec, seconddec);
		} else if (operator.equals("/")) {
			answer = div(firstdec, seconddec);
		}
		String simplified = "" + answer;
		if (operator.equals("*")) {
			simplified = fraction(answer);
		} else if (operator.equals("/")) {
			simplified = fraction(answer);
		}

		return simplified;
	}

	public static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}

	public static double toDecimal(int a, int b, int c) {
		double x = a * c;
		double y = x + b;
		double z = y / c;
		return z;
	}

	public static double add(double a, double b) {// adds the two decimals
		double x = a + b;
		return x;
	}

	public static double sub(double a, double b) {// subtracts the two decimals
		double x = a - b;
		return x;
	}

	public static double mul(double a, double b) {// multiplies the two decimals
		double x = a * b;
		return x;
	}

	public static double div(double a, double b) {// divides the two decimals
		double x = a / b;
		return x;
	}

	public static String fraction(double x) {// converts the decimal into a fraction
		String str = "";
		if (x == 0) {
			str = "0";
		} else if (x != 0) {
			String a = "" + x;
			String s[] = a.split("\\.");
			int b = s[0].length();
			int denominator = (int) Math.pow(10, b);
			int numerator = (int) (x * denominator);
			int gcd = getGCD(numerator, denominator);
			str = simplify((numerator / gcd), (denominator / gcd));
		}
		return str;
	}

	public static int getGCD(int n1, int n2) {// gets the greatest common denominator
		if (n2 == 0) {
			return n1;
		}
		return getGCD(n2, n1 % n2);
	}

	public static String simplify(int num, int den) {// simplifies the fraction
		int x = num / den;
		int y = num % den;
		String s;
		if (x < 1 && x > 0) {
			s = "" + num + "/" + den;
		} else if (x == 0) {
			s = "0";
		} else {
			s = "" + x + "_" + y + "/" + den;
		}
		return s;
	}
}
