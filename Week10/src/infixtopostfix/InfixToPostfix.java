package infixtopostfix;
import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String expression) {
    	String new_expression = negative_numbers(expression);
		String result = new String("");
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < new_expression.length();i++) {
			char c = new_expression.charAt(i);
			
			if (Character.isDigit(c) || c == '_' || c == '.') {
				result +=c;
				if(i <new_expression.length() - 1) {
					if(!Character.isDigit(new_expression.charAt(i+1)) && new_expression.charAt(i+1) !='.' ) result +=' ';
				}
			}
			else if (c == '(')stack.push(c);
			else if (c == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					//result += ' ';
					result += stack.pop();
				}
					stack.pop();
				
			}
			else {
				 while (!stack.isEmpty() && priority(c)
                         <= priority(stack.peek())) {
					 //result += ' ';
					 result += stack.pop();
				 }
             stack.push(c);
			}
		}
		while(!stack.isEmpty()) {
			if(stack.peek() == '(')
				return "Invalid Expression";
			//result += ' ';
			result += stack.pop();
		}
		System.out.println("Infix: " + new_expression);
    	return result;
    }
    private static int priority(Character ch) {
        switch(ch) {
        case'+':
        case'-':
            return 1;
        case '*':
        case'/':
            return 2;
        case'^':
            return 3;
        }
        return -1;
    }
    protected static String negative_numbers(String expression) {
    	boolean negative_value = true;
    	String new_expression = new String("");
    	for (int i = 0; i < expression.length();i++) {
    		char t = expression.charAt(i);
    		if (negative_value && t == '-') t = '_';
    		else if (t == ')' || Character.isDigit(t)) negative_value = false;
    		else negative_value = true;
    		new_expression += t;
    	}
    	return new_expression;
    }
}