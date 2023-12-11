package linear_data_structure;

import java.util.Stack;

public class Expression {
    public static int calc(int a, int b, char operator) {
    	switch (operator) {
		case '$':return (int)Math.pow(a, b);
		case '/':return a / b;
		case '%':return a % b;
		case '*':return a * b;
		case '+':return a + b; 
		case '-':return a - b;
		}
    	return 0;
    }
	public static int solvePostfix(String post) {
		// stack of operands
		Stack<Integer> s=new Stack<Integer>();
		//traverse from left to right
		for (int i = 0; i < post.length(); i++) {
			// get each sym from expression
			char sym=post.charAt(i);
			//if sym is operand
			if(Character.isDigit(sym)) {
				//convert it to int & push on stack
				// e.g '5'-toString()-"5" -praseInt()-5
				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			}
			else {
				//pop two elements from stack
				int b=s.pop();
			    int a=s.pop();
			    //calculate result of two operands
			    int c=  calc(a, b, sym);
			    //push that result onto the stack
			    s.push(c);
			}
		}
		// repeat for all sums in expression
		//pop final result from stack return
		return s.pop();
	}
	
	public static int solvePrefix(String pre) {
		// stack of operands
		Stack<Integer> s=new Stack<Integer>();
		//traverse from right to left
		for (int i = pre.length()-1; i >=0; i-- ) {
			// get each sym from expression
			char sym=pre.charAt(i);
			//if sym is operand
			if(Character.isDigit(sym)) {
				//convert it to int & push on stack
				// e.g '5'-toString()-"5" -praseInt()-5
				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			}
			else {
				//pop two elements from stack
				int a=s.pop();
			    int b=s.pop();
			    //calculate result of two operands
			    int c=  calc(a, b, sym);
			    //push that result onto the stack
			    s.push(c);
			}
		}
		// repeat for all sums in expression
		//pop final result from stack return
		return s.pop();
	}

	public static void main(String[] args) {
		String postfix = "59+4862/-*-173-$+";
		String prefix ="+-+59*4-8/62$1-73";
		int result = solvePostfix(postfix);
		System.out.println("Result:" + result);
		int res = solvePrefix(prefix);
		System.out.println("Result:" + res);
		
	}
}
