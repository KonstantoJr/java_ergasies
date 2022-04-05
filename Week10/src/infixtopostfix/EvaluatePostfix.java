package infixtopostfix;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class EvaluatePostfix {
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	public static String evaluate(String postfix_expression) {
		String res = new String("");
		Stack<Double> stack = new Stack<>();
		String number = new String("");
		for(int i = 0 ; i<postfix_expression.length() ; i++) {
			char c = postfix_expression.charAt(i);
			if (c == ' ') {
				double f = Double.parseDouble(number);
				number = "";
				stack.push(f);
			}
			else if(Character.isDigit(c) || c == '_' || c == '.'){
				if (c == '_') c = '-';
				number +=c;
			}
			else {
				if (number.length() !=0) {
					double f = Double.parseDouble(number);
					number = "";
					stack.push(f);	
				}
				double val1 = stack.pop();
				double val2 = stack.pop();
				
				switch(c) {
				case '+':
					stack.push(round((val2 + val1) , 3));
					break;
				case '-':
					stack.push(round((val2 - val1) , 3));
					break;
				case '/':
					if (val1 == 0) return "Division with 0 is not defined";
					else stack.push(round((val2 / val1) , 3));
					break;
				case '*':
					stack.push(round((val2 * val1),3));
					break;
				case '^':
					stack.push(round((Math.pow(val2, val1)),3));
					break;
				}
			}
		}
		if (stack.size() == 0 && number.length() !=0) {
			res = number;
		}
		else if (stack.size() == 1) res = String.valueOf(stack.pop());
		return res;
	}
}
