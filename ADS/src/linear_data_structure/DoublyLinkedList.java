package linear_data_structure;

import linear_data_structure.SinglyLinkedList.Node;

public class DoublyLinkedList {

	static class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node() {
			data = 0;
			next = null;
			prev = null;
		}

		public Node(int val) {
			data = val;
			next = null;
			prev = null;
		}
	}

	private Node head;

	public DoublyLinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void displayForward() {
		System.out.println("Fwd List:");
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}

	public void displayReverse() {
		if(head==null)
			return;
		System.out.println("Rev List:");
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.prev;
		}
	}

	public void addLast(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode;
			// newnode's prev to last node(trav)
			newNode.prev = trav;
		}

	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (isEmpty()) {
			head = newNode;
		} else {
			// newnode points to head
			newNode.next = head;
			// head's previous points to newnode
			head.prev = newNode;
			// newnode should be head
			head = newNode;
		}
	}

	public void addAtPosition(int val, int pos) {
		Node newNode = new Node();
		if (isEmpty()) {
			addFirst(val);
		} else {
			Node temp, trav = head;
			for (int i = 1; i <= pos - 1; i++) {
				// if pos > length add element at beyond list
				if (trav.next == null)
					break;
				trav = trav.next;
			}
			// take temp pointer to node after trav
			temp = trav.next;
			// newNode next should point to trav's next ie.temp
			newNode.next = temp;
			newNode.prev = trav;
			trav.next = newNode;

			// trav'snext point to newNode
			if (temp != null)// if adding at end next line is not required
				temp.prev = newNode;
		}
	}
	
	public void delFirst() {
			if(head==null)
				throw new RuntimeException("List is empty");
			//if list has single node,make head null
			 if(head.next==null)
				 head=null;
			//the first node will be for gc
			head=head.next;
			//second node (new node)prev should be null
			head.prev=null; 
			  
			//first position is marked for garbage collection
		
	}
	
	public void delAtPos(int pos) {
		//if pos=1,delete first node
		if(pos==1)
			delFirst();
		//if list is empty or pos<1,then throw exception
		if(head == null || pos<1)
			throw new RuntimeException("List is empty");
		//take temp pointer running behind behind trav
		Node trav=head;
		//traverse till pos(trav)
		for (int i = 1; i < pos; i++) {
			if(trav == null)
				throw new RuntimeException("Invalid position");
			trav=trav.next;
		}
		 //trav's previous node's next point to trav's next
		trav.prev.next=trav.next;
		//trav's next node's previous points trav's previous node
		if(trav.next!=null)//while deleting last node ,skip next line
		trav.next.prev=trav.prev;
		
	
	}
}
