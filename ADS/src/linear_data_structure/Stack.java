package linear_data_structure;

import java.util.Scanner;

public class Stack {

	private int maxSize;
	private int top;
	private int[] stackArray;

	public Stack(int size) {
		this.maxSize = size;
		stackArray = new int[maxSize];
		top = -1;

	}

	public void push(int element) throws RuntimeException {
		if (top < maxSize - 1) {
			stackArray[++top] = element;
		} else {
			System.out.println("Stack is full,You can not add another element");
		}
	}

	public int pop() throws RuntimeException {
		if (!isEmpty()) {
			return  stackArray[top--];
		} else {
			System.out.println("Stack is empty.you can not remove element from stack");
			return 0;
		}

	}

	public int peek() throws RuntimeException{
		if (!isEmpty()) {
			return stackArray[top];
		} else {
			System.out.println("Stack is empty.cannot peek");
			return 0;
		}
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public static void main(String[] args) {
		
		Stack stack = new Stack(5);
		try(Scanner sc = new Scanner(System.in))
		{
		boolean exit= false;
		
		while(!exit)
		{
			System.out.println("Enter your choice : \n 1.Push Element \n 2.Pop Element \n 3.Peek Element \n 4.Display Element ");
	       switch (sc.nextInt()) {
		case 1://push
			 System.out.println("Enter the element to push");
			 int pushelement=sc.nextInt();
			 stack.push(pushelement);
			break;
		
		case 2://pop
			int val=stack.peek();
			int popElement=stack.pop();
			System.out.println("Popped:"+val);
			break;
			
		case 3:
			int topElement=stack.peek();
			if(topElement!=-1) {
				System.out.println("Top element"+topElement);
			}
           break;
           
		case 4:
			if(stack.isEmpty()) {
				System.out.println("Stack is empty.Nothing to display");
			}else {
				System.out.println("Element in the stack:");
			for(int i=stack.top;i>=0;i--) {
				System.out.println(stack.stackArray[i]);
			}
			}
			break;
		
	case 0:
		exit=true;
		break;
		
	default:
			System.out.println("Invalid Choice");
			break;
		}	
		}
		
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("Please try");
	}
}
}
