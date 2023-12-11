package linear_data_structure;

import java.util.Scanner;

public class Queue {
	private int[] queue;
	private int front, rear, capacity;

	public Queue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		front = 0;
		rear = 0;
	}

	public void enqueue(int element) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		queue[rear] = element;
		rear++;
		System.out.println("Element is added to queue");
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int element = queue[front];
		front++;
		return element;
	}

	public boolean isFull() {
		return rear == capacity;
	}

	public boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	public int size() {
		return rear - front;
	}

	public void dispaly() {
		System.out.println("Queue: \n");
		for (int i = front; i < rear; i++) {
			System.out.print(queue[i] + " ");
			System.out.print(" ");
		}
	}
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			
			System.out.println("Enter the size of queue");
			int size=sc.nextInt();
			
			Queue queue = new Queue(size);
			
			boolean exit=false;
			while(!exit) {
				System.out.println(" \n Enter your choice: \n 1.Show the queue \n 2.Store data in queue \n 3.Access data from queue \n 4.Check the size of queue \n 5.Check if queue is full \n 6.Check if queue is empty \n 7.exit");
			  try {
				  switch (sc.nextInt()) {
				case 1:
					queue.dispaly();
					break;
					
				case 2:
					System.out.println("Enter the element");
                    int element=sc.nextInt();
                    queue.enqueue(element);
                  
				    break;
				    
				case 3:
					queue.dequeue();
				    break;
				    
				case 4:
					System.out.println("Size of queue is "+ queue.size()); 
				    break;
				   
				case 5:
					System.out.println("Is queue full"+queue.isFull());
				    break;
				    
				case 6:
					System.out.println("Is queue is empty"+queue.isEmpty());
				    break;
				    
				case 7:
					exit=true;
					break;
					
				default:
					System.out.println();
					break;
				}
				  
			  }catch (Exception e) {
				e.printStackTrace();  
				System.out.println("Please try");
			}
			}
		}
	}
}
