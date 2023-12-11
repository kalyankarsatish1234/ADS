package queue;

import java.util.Scanner;
public class CircularQueue {
	private int[] arr;
	private int front, rear;
	private final int SIZE;
	public CircularQueue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = -1;
		rear = -1;
	}
	
	public void push(int data) {
		//1. reposition rear (inc)
		rear = (rear + 1) % SIZE;
		//2. add data(element) at rear index
		arr[rear] = data;
	}
	
	public void pop() {
		//1. reposition front (inc)
		front = (front + 1) % SIZE;
		//
		if(front == rear)
			front = rear = -1;
	}
	
	public int peek() {
		// 1. read data from front end (front + 1 index)
		return arr[(front + 1) % SIZE];
	}
	
	public boolean isEmpty() {
		return rear == front && rear == -1;
	}
	
	public boolean isFull() {
		return (front == -1 && rear == SIZE -1) || (rear == front && rear != -1);
	}



		public static void main(String[] args) 
		{
			// TODO Auto-generated method stub
			int choice, data;
			CircularQueue q = new CircularQueue(4);
			
			Scanner sc = new Scanner(System.in);
			do
			{
				System.out.println("0. Exit");
				System.out.println("1. Push");
				System.out.println("2. Pop");
				System.out.println("3. Peek");
				System.out.println("Enter your choice : ");
				choice = sc.nextInt();
				
				switch(choice)
				{
					case 1: //push
						if(q.isFull())
							System.out.println("Queue is full");
						else
						{
							System.out.println("Enter data to added into queue : ");
							data = sc.nextInt();
							q.push(data);
						}
						break;
					case 2: //pop
						if(q.isEmpty())
							System.out.println("Queue is empty");
						else
							q.pop();
						break;
					case 3:// peek
						if(q.isEmpty())
							System.out.println("Queue is empty");
						else
							System.out.println("Peeked Data :  " + q.peek());
						break;
				}
				
			}while(choice != 0);
			
			
			
			sc.close();
		}

	}

	








