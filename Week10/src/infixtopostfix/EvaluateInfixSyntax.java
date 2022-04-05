package infixtopostfix;

public class EvaluateInfixSyntax {
	public static String evaluatesyntax(String expression) {
		char error = checksyntax(expression);
		switch (error) {
		case '0':
			return "Correct";
		case '1':
			return "Cannot have operator after operator";
		case '2':
			return "No number found after operator";
		case '3':
			return "Parenthesis never closes";
		case '4':
			return "Closing parenthesis without opening one";
		default:
			return "Correct";
		}
	}
	public static char checksyntax(String expression) {
		String new_expression = InfixToPostfix.negative_numbers(expression);
		int open_par = 0;
		for (int i =0 ; i<new_expression.length() ; i++) {
			char c = new_expression.charAt(i);
			if (c == '(') open_par +=1;
			else if (c == ')') open_par -= 1;
			else if (isOperator(c)) {
				if(i<new_expression.length()-1) {
					char next = new_expression.charAt(i+1);
					if(isOperator(next))return '1';
					else if (next =='_') {
						if(i<new_expression.length()-2) {
							char ch = new_expression.charAt(i+2);
							if (!Character.isDigit(ch)) return '2';
						}
						else return '2';
					}
				}
				else return '2';
			}
			
			
		}
		if (open_par > 0) return '3';
		else if (open_par < 0) return '4';
		return '0';
	}
	public static boolean isOperator(char c) {
		String operators = new String("+-/*^");
		for (int i = 0 ; i<operators.length() ; i++) {
			if (c == operators.charAt(i)) return true;
		}
		return false;
	}
}
