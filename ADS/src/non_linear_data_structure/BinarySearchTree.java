package non_linear_data_structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



public class BinarySearchTree {
	static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node() {
			this.data = 0;
			this.left = null;
			this.right = null;
		}

		public Node(int val) {
			this.data = val;
			this.left = null;
			this.right = null;
		}

		

		public int getData() {
			return data;
		}
	}
	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(int val) {
		Node newNode = new Node(val);
		if (root == null)
			root = newNode;
		else {
			Node trav = root;
			while (true) {
				if (val < trav.data) {
					if (trav.left != null)
						trav = trav.left;
					else {
						trav.left = newNode;
						break;
					}
				} else {//if(val>=trav.data)
					if (trav.right != null) {
                        trav=trav.right;
                        }
                        else {
                        	trav.right=newNode;
                        	break;
                        }
					}
				}
			}
		}
	public void preorder(Node trav) {
		if(trav == null)
			return;
		System.out.print(trav.data + " ,");
		preorder(trav.left);
		preorder(trav.right);
		
	}
	public void preorder() {
		System.out.print("PRE: " );
		preorder(root);
		System.out.println();
	}
	
	public void inorder(Node trav) {
		if(trav == null)
			return;
 		inorder(trav.left);
 		System.out.print(trav.data + " ,");
 		inorder(trav.right);
		
	}
	public void inorder() {
		System.out.print("IN: " );
		inorder(root);
		System.out.println();
	}
	
	public void postorder(Node trav) {
		if(trav == null)
			return;
 		postorder(trav.left);		
 		postorder(trav.right);
 		System.out.print(trav.data + " ,");
 		
	}
	public void postorder() {
		System.out.print("POST: " );
		postorder(root);
		System.out.println();
	}
	//for delete all elements we follow postorder traversal 
	public void deleteAll(Node root) {
		if(root==null)
			return;
		deleteAll(root.left);
		deleteAll(root.right);
//		root.left=null;
//		root.right=null;
		root=null;
		
	}
	
	public void deleteAll() {
		deleteAll(root);
		root=null;
	}
	
	public int height(Node trav) {
		if(trav == null)
			return -1;
		int hl=height(trav.left);
		int hr=height(trav.right);
		int max=hl > hr ? hl : hr ;
		return max+1;
	}
	public int height() {
		return height(root);
	}
	
	public void preorderNonRecursive() {
		System.out.print("PRE: ");
		Stack<Node> s = new Stack<>();
		Node trav=root;
		while(trav!=null || !s.isEmpty()){
			while(trav!= null) {
				System.out.print(trav.data+ " ,");
				if(trav.right!=null)
					s.push(trav.right);
				trav=trav.left;
				
			}
			if(!s.isEmpty())
				trav=s.pop();
		}
	}
	
	public Node bfs(int key) {
		Queue<Node> q = new LinkedList<>();
		Node trav;
		q.offer(root);
		while(!q.isEmpty()) {
			trav=q.poll();
			if(key == trav.data)
				return trav;
			if(trav.left!=null)
				q.offer(trav.left);
			if(trav.right!=null)
				q.offer(trav.right);
		}
		return null;
	}
		
		public Node dfs(int key) {
			Stack<Node> q = new Stack<>();
			Node trav;
			q.push(root);
			while(!q.isEmpty()) {
				trav=q.pop();
				if(key == trav.data)
					return trav;
				if(trav.left!=null)
					q.push(trav.left);
				if(trav.right!=null)
					q.push(trav.right);
			}
			return null;
		
	}
		public Node binSearch(int key) {
			Node trav=root;
			while(trav!=null) {
				if(key == trav.data)
					return trav;
				if(key < trav.data)
					trav=trav.left;
				else
					trav=trav.right;
			}
			return null;
		}
		
		public Node[] binSearchWithParent(int key) {
			Node trav = root, parent=null;
			while(trav!=null) {
				if(key == trav.data)
					return new Node[] {trav,parent};
				parent=trav;
				if(key < trav.data)
					trav=trav.left;
				if(key > trav.data)
					trav= trav.right;
				
			}
			return new Node[] {null,null}; 
		}
		
	public void delete(int val) {
		Node trav,parent;
		//find the node to be deleted along with its parent
		Node[] arr=binSearchWithParent(val);
		trav=arr[0];
		trav=arr[1];
		//if node is not found ,throw exception
		if(trav == null)
			throw new RuntimeException("Node not found");
		//if node has left as well as right child 
		if(trav.left!=null && trav.right!=null) {
			//find its successor with its parent
			parent=trav;//here we make trav to parent
			Node succ=trav.right;
			while(succ.left!=null) {
				parent=succ;
				succ=succ.left;
			}
		  //overwrite data of node with successor data
			trav.data=succ.data;
			//mark successor node to be deleted
			trav=succ;
			
		}
		//if node has right child (or node doesn't have right child)
		if(trav.left==null) {
			if(trav==root)
				root=trav.right;
			else if(trav== parent.left)
				parent.left=trav.right;
			else
				parent.right=trav.right;
		}
		
		//if node has left child (or node doesn't have right child)
				if(trav.right==null) {
					if(trav==root)
						root=trav.left;
					else if(trav== parent.left)
						parent.left=trav.left;
					else
						parent.right=trav.left;
				}
	}
		
	
	public static void main(String[] args) {
		BinarySearchTree tree =  new BinarySearchTree();
		Scanner sc =new Scanner(System.in);
		tree.add(13);
		tree.add(12);
		tree.add(5);
		tree.add(8);
		tree.add(9);
		tree.add(16);
		tree.add(20);
		tree.add(10);
		tree.add(11);
		tree.add(7);
		tree.add(6);
		tree.add(14);
		tree.add(4);
		tree.preorder();
		tree.inorder();
	    tree.postorder();
	    tree.preorderNonRecursive();
	    
	    System.out.println("\n Enter element to search:");
	    
	    int val = sc.nextInt();
	    Node temp=tree.bfs(val);
	    if(temp == null)
	    	System.out.println("Element is not found");
	    else
	    	System.out.println("BFS: "+temp.data);
	    
	    temp=tree.dfs(val);
	    if(temp == null)
	    	System.out.println("Element is not found");
	    else
	    	System.out.println("DFS: "+temp.data);
	    
	    temp=tree.binSearch(val);
	    if(temp == null)
	    	System.out.println("Element is not found");
	    else
	    	System.out.println("BIN: "+temp.data);
	    Node[] arr=tree.binSearchWithParent(val);
	    if(arr[0]==null)
	    	System.out.println("BS:Not found");
	    else if(arr[1]==null)
	    	System.out.println("BS: Found"+ arr[0].getData()+"with parent:" + arr[1]);
	    
	    else
	    	System.out.println("BS: Found " + arr[0].getData() + "with parent:" + arr[1].getData());
	    System.out.println("HEIGHT: " + tree.height());
	    tree.deleteAll();
	    System.out.println("HEIGHT: " + tree.height());
	    tree.inorder();
		
		System.out.println("Enter the element to delete");
		int value=sc.nextInt();
		tree.delete(value);
	}
	}


	
	

