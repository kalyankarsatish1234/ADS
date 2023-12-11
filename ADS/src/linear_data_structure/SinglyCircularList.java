package linear_data_structure;

import java.util.Scanner;

public class SinglyCircularList {

	static class Node {
		// node class field
		private int data;
		private Node next;

		// node class method
		public Node() {
			data = 0;
			next = null;
		}

		public Node(int val) {
			data = val;
			next = null;
		}

	}

	// list class field
	private Node head;

	// list class method
	public SinglyCircularList() {
		head = null;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void display() {

		if (isEmpty())
			throw new RuntimeException("List is empty");

		else {
			System.out.println("List:  ");
			Node trav = head;

			do {
				System.out.println(trav.data);
				trav = trav.next;
			} while (trav != head);
		}
	}

	public void addLast(int val) {
		// create a new node init it
		// traverse till last node (trav) i.e the node whose next contains head
		// newnode's next points head
		// last node(trav) next points to new node
		Node newNode = new Node(val);
		if (isEmpty()) {
			head = newNode;
			newNode.next = head;
		} else {

			Node trav = head;
			while (trav.next != head)
				trav = trav.next;
			newNode.next = head;
			trav.next = newNode;
		}
	}
	
	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (isEmpty()) {
			head = newNode;
			newNode.next = head;
		} else {

			Node trav = head;
			while (trav.next != head)
				trav = trav.next;
			newNode.next = head;
			trav.next = newNode;
			head=newNode;
		}
	}
	public void addPosition(int value,int pos) {
		//if list is empty, add node at the start
		//if pos<=1,add node at the start
		if(head == null || pos<=1) {
			addFirst(value);
		}
		else {
			//create a new node
			Node newNode = new Node(value);
			//traverse till position -1 (trav)
			Node trav=head;
			for (int i = 1; i <=pos-1; i++) { 
				//if pos > length add element at beyons=d list
                 if(trav.next == head)
                	 break;
				trav=trav.next;
			}
			//newNode next should point to trav's next
			newNode.next=trav.next;
			//trav'snext point to newNode 
			trav.next=newNode;
			
		}
			
	}
	
	public void delFirst() {
		if(isEmpty())
			throw new RuntimeException("List is empty"); 
		//if list has single node,then make head null
		if(head.next == head)
			head=null;
		//traverse till last node(trav)
		Node trav=head;
		while(trav.next !=head)
			trav=trav.next;
		
		//take head to the next(2nd)  node
		head=head.next;
		
		// the last node (trav)next should be to new head
		trav.next=head; 
	}
	public void delAtPos(int pos) {
		//if pos=1,delete first node
		if(pos==1)
			delFirst();
		//if list is empty or pos<1,then throw exception
		if(head == null || pos<1)
			throw new RuntimeException("List is empty");
		//take temp pointer running behind behind trav
		Node temp=null,trav=head;
		//traverse till pos(trav)
		for (int i = 1; i < pos; i++) {
			if(trav == head)
				throw new RuntimeException("Invalid position");
			temp=trav;
			trav=trav.next;
		}
		//trav is node to be deleted &temp is node before that
		temp.next=trav.next;
		//trav node will be garbage collected 
	
	}
	
	public void delAll() {
		head.next=null;
		head=null;
		
	}
	
	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			SinglyCircularList list=new SinglyCircularList();
			boolean exit=false;
			while(!exit) {
				
				System.out.println("1.Show the content of linked list");
				System.out.println("2.Insert the data in the linked list");
				System.out.println("3.Check how many elements are there in the linked list.");
				System.out.println("4.Check to see if linked list is empty.");
				System.out.println("5.Add element at Specific Position");
				System.out.println("6.Delete element at first position");
				System.out.println("7.Delete at specific position");
				System.out.println("8.Delete at last position");
				System.out.println("9.Delete all element");
				
				System.out.println("Enter your choice");
				try {
					switch (sc.nextInt()) {
					case 1:
						list.display();
						break;
					case 2:
						System.out.println("Enter the element");
						int val=sc.nextInt();
						list.addFirst(val);
						break;
					case 3:
						break;
					
					case 4:
						list.isEmpty();
						break;
						
					case 5:
						System.out.println("Enter the element");
						int value=sc.nextInt();
						System.out.println("Enter the position");
						int pos=sc.nextInt();
						list.addPosition(value, pos);
						break;
					
					case 6:
						list.delFirst();
						break;
					
					case 7:
						System.out.println("Enter a position");
						int position=sc.nextInt();
						list.delAtPos(position);
						break;
					
					case 8:
						break;
					
					case 9:
						list.delAll();
						break;

					default:
						break;
					}
				}catch (Exception e) {
				   e.printStackTrace();
				}
			}
		}
	}
}
