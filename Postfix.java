import java.util.*;

public class Postfix {
	private static final String DELIMS = "+-*/() ";
	
	private static final HashMap<String, Integer> precedenceMap = new HashMap<String, Integer>();
	static {
		precedenceMap.put("+", 1);
		precedenceMap.put("-", 1);
		precedenceMap.put("*", 2);
		precedenceMap.put("/", 2);
	};

	public boolean lowerPrecedence(String op1, String op2) { // if op1 < op2
		return precedenceMap.get(op1) < precedenceMap.get(op2);
	}

	public String infixPostfixConvert(String s) {		
		// maintain strictly increasing precedence order
		Stack<String> opStack = new Stack<String>();
		StringBuilder postfix = new StringBuilder();
		
		StringTokenizer tokens = new StringTokenizer(s, DELIMS, true);
		while (tokens.hasMoreTokens()) {
			String t = tokens.nextToken();
			if (DELIMS.indexOf(t) >= 0) {
				if (t.equals(" ")) { // keep the spaces
					continue;
				}
				if (opStack.isEmpty() || opStack.peek().equals("(")
						|| t.equals("(")) {
					opStack.push(t);
				} else if (t.equals(")")) { // pop all the operators between
											// (...) inclusively
					String op = opStack.pop();
					while (!op.equals("(")) {
						postfix.append(" ").append(op);
						op = opStack.pop();
					}
				} else {
					while (!opStack.isEmpty()
							&& !lowerPrecedence(opStack.peek(), t)) {
						postfix.append(" ").append(opStack.pop());
					}
					opStack.push(t);
				}
			} else {
				postfix.append(" ").append(t); // numbers
			}
		}
		
		while (!opStack.isEmpty()) {
			postfix.append(" ").append(opStack.pop());
		}

		return postfix.toString();
	}

	private int operate(String op, int lhs, int rhs) {
		if (op.equals("+")) {
			return lhs + rhs;
		}
		if (op.equals("*")) {
			return lhs * rhs;
		}
		if (op.equals("-")) {
			return lhs - rhs;
		}
		if (op.equals("/")) {
			return lhs / rhs;
		}
		throw new IllegalArgumentException("unrecognized operator " + op);
	}

	public int postFixEvaluate(String s) {
		Stack<String> stack = new Stack<String>();
		StringTokenizer tokens = new StringTokenizer(s, DELIMS, true);
		try {
			while (tokens.hasMoreTokens()) {
				String t = tokens.nextToken();
				if (DELIMS.indexOf(t) >= 0) {
					if (t.equals(" ")) //skip white spaces
						continue;
					int right = Integer.parseInt(stack.pop()); //may throw exceptions if the expression is not well formed
					int left = Integer.parseInt(stack.pop());
					stack.push("" + operate(t, left, right));
				} else {
					stack.push(t); //push operands
				}
			}
		} catch (NumberFormatException e) {
			throw new RuntimeException("badly formed postfix expression " + e);
		} catch (EmptyStackException ese) {
			throw new IllegalArgumentException("illegal postfix expression " + s);
		}
		int result = Integer.parseInt(stack.pop());		
		if (stack.size() > 0) {
			throw new IllegalArgumentException("illegal postfix expression " + s);
		}		
		return result;
	}

	public static void main(String[] args) {
		Postfix p = new Postfix();
		//String postfix = p.infixPostfixConvert("1 * 2*");
		//System.out.println(postfix);
		System.out.println(p.postFixEvaluate("* 2 3 * 5 4"));

	}
}
