 package linear_data_structure;

import java.util.Scanner;

public class CircularQueue {

	private int size;
	private int[] queue;
	private int front;
	private int rear;

	public CircularQueue(int size) {
		queue = new int[size];
		front = -1;
		rear = -1;
	}

	public boolean isEmpty() {
		if(front == rear && front == -1) {
		return true;
		}
		else
			return false;
	}

	public boolean isFull() {
		if ((front == -1 && rear == queue.length - 1) || (front == rear && front != -1))
		{
			return true;
		}
		else
			return false;
	}

	public void enQueue(int element) {
		if (isFull())
			throw new RuntimeException("Queue is Full");
		rear = (rear + 1) % queue.length;
		queue[rear] = element;
	}

	public void deQueue() {
		if (isEmpty())
			throw new RuntimeException("Queue is Empty");
		front = (front + 1) % queue.length;
		if (front == rear) {
			front = -1;
			rear = -1;
		}
	}

	public int peek() {
		if (isEmpty())
			throw new RuntimeException("Queue is empty");
		int index = (front + 1) % queue.length;
		return queue[index];
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty nothing to display");
			return;
		} else {
			int current = front;
			while (current != rear) {
				current = (current + 1) % queue.length;
				System.out.println(queue[current] + " ");
			}
		}  
	}
	
	public int size() {
		return size-(front-rear);
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			CircularQueue queue = new CircularQueue(4);
			boolean exit = false;
			while (!exit) {
				System.out.println("1.Show the contenet of circulat queue");
				System.out.println("2.Enqueue the data in the circular queue");
				System.out.println("3.Access the data from circular queue");
				System.out.println("4.Check how many elements in cicrular queue");
				System.out.println("5.Check to see if the circular queue is full");
				System.out.println("6.Check to see if cicrular queue is empty");
				System.out.println("0.exit");

				try {
					System.out.println("Enter your choice ");
					switch (sc.nextInt()) {

					case 1:
						queue.display();
						break;

					case 2:
						System.out.println("Enter the element");
						int element = sc.nextInt();
						queue.enQueue(element);
						break;

					case 3:
						int val = queue.peek();
						queue.deQueue();
						System.out.println("Popped : " + val);
						break;

					case 4:
					System.out.println("size of queue is :"+queue.size());
						break;

					case 5:
						if(queue.isFull())
							System.out.println("queue is full");
						else
							System.out.println("Queue is not full");
						break;

					case 6:
						if(queue.isEmpty())
							System.out.println("queue is empty");
						else
							System.out.println("queue is not empty");
						break;

					case 7:
						exit = true;
						break;

					default:
						System.out.println("");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Please try");
				}
			}
		}
	}
}
