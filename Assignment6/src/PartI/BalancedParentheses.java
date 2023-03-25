package PartI;

public class BalancedParentheses {

	public static boolean isBalanced(String inString) {
		MyStack<Character> stack = new MyStack<>();
		for (int i = 0; i < inString.length(); i++) {
			char c = inString.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.empty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.empty();
	}
	
	public static void main(String[] args) {
		System.out.println("result for (()()()()) is " + isBalanced("(()()()())"));
		System.out.println("result for (((()))) is " + isBalanced("(((())))"));
		System.out.println("result for ((((((()) is " + isBalanced("((((((())"));
		System.out.println("result for ())) is " + isBalanced("()))"));
	}
}
