package linear_data_structure;

import java.util.Scanner;

public class SinglyLinkedList {
    //Node is a static member of SinglyLinked List
	static class Node{
		private int data;
		private Node next;
		
	   public Node() {
		   data=0;
		   next=null;
	   }
	   public Node(int value) { 
		   data=value;
		   next=null;  
	   }
	}
	private Node head;
	
	public SinglyLinkedList() {
		head=null;
	}
	
	void display()
	{
		System.out.println("List:");
		Node trav=head;
		while(trav!=null) {
			System.out.println(trav.data);
			trav=trav.next;
		}
		
	}
	void addLast(int value) {
		Node newNode=new Node(value);
		if(head==null) {
			head=newNode;
		}
		else {
		Node trav=head;
		while(trav.next!=null) {
			trav=trav.next;
		}	
			trav.next=newNode;
		
		}
		
	 }
	
	void addFirst(int val) {
		Node newNode= new Node(val);
		newNode.next=head;
		
		head=newNode;
		 
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
                 if(trav.next == null)
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
		if(head==null)
			throw new RuntimeException("List is empty");
		head=head.next;
		//first position is marked for garbage collection
	}
	
	public void delAll() {
		head = null;
	}
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
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
			if(trav == null)
				throw new RuntimeException("Invalid position");
			temp=trav;
			trav=trav.next;
		}
		//trav is node to be deleted &temp is node before that
		temp.next=trav.next;
		//trav node will be garbage collected 
	
	}
	
	public void delLast() {
		if(isEmpty()) 
			throw new RuntimeException("List is empty");
		
		else {
		Node temp=null,trav=head;
		
		while(trav.next != null)
		{
			temp=trav;
			trav=trav.next;
		}
		//when last node is deleted then second last node will be null
		temp.next=null;
		}
	}
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
		SinglyLinkedList list = new SinglyLinkedList();
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
			
			System.out.println("Enter your choice:");
			try {
				switch (sc.nextInt()) {
				case 1:
					list.display();
					break;
                
				case 2:
					System.out.println("Enter the element to add");
					int val=sc.nextInt();
					list.addLast(val);
					break;
				
				case 4:
					list.isEmpty();
					System.out.println("List is empty");
					break;
					
				case 5:
					System.out.println("Enter the element");
					int value=sc.nextInt();
					System.out.println("Enter a position");
					int pos=sc.nextInt();
					list.addPosition(value, pos);
					break;
				
				case 6:
					list.delFirst();
					break;
					
				case 7:
					System.out.println("Enter position");
					int position=sc.nextInt();
					list.delAtPos(position);
					break;
				
				case 8:
					list.delLast();
					break;
					
				case 9:
					list.delAll();
					break;
					
				default:
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
