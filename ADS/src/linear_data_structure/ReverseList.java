package linear_data_structure;

public class ReverseList {

	static class Node {
		private int data;
		private Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int value) {
			data = value;
			next = null;
		}
	}

	private Node head;

	public ReverseList() {
		head = null;
	}

	void addLast(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode;

		}

	}

	void display() {
		System.out.println("List:");
		Node trav = head;
		while (trav != null) {
			System.out.print(trav.data + " -> ");
			trav = trav.next;
		}
		System.out.println(" ");
	}

	public void reverse() {
		Node oldhead=head,temp;
		head=null;
		
		while(oldhead!=null) {
		//delete first(temp) from old  list
		temp=oldhead;
		oldhead=oldhead.next;
		
		//add first(temp) to new list
		temp.next=head;
		head=temp;
		
	}
	}
		public int findMid()
		{
			Node fast=head,slow=head;
			while(fast != null && fast.next != null) {
				slow=slow.next;
				fast=fast.next.next;
				
			}
			return slow.data;
		}


	public static void main(String[] args) {
		ReverseList list = new ReverseList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.display();
		//list.reverse();
		list.display();
		
		System.out.println("Middle: " + list.findMid());

	}
}
