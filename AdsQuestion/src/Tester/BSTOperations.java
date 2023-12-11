package Tester;

import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void inOrderTraversal() {
        System.out.print("Inorder Traversal: ");
        inOrderTraversalRec(root);
        System.out.println();
    }

    private void inOrderTraversalRec(TreeNode root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.data + " ");
            inOrderTraversalRec(root.right);
        }
    }

    public void preOrderTraversal() {
        System.out.print("Preorder Traversal: ");
        preOrderTraversalRec(root);
        System.out.println();
    }

    private void preOrderTraversalRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversalRec(root.left);
            preOrderTraversalRec(root.right);
        }
    }

    public void postOrderTraversal() {
        System.out.print("Postorder Traversal: ");
        postOrderTraversalRec(root);
        System.out.println();
    }

    private void postOrderTraversalRec(TreeNode root) {
        if (root != null) {
            postOrderTraversalRec(root.left);
            postOrderTraversalRec(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class BSTOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert into the BST: ");
                    int dataToInsert = scanner.nextInt();
                    bst.insert(dataToInsert);
                    break;
                case 2:
                    bst.inOrderTraversal();
                    break;
                case 3:
                    bst.preOrderTraversal();
                    break;
                case 4:
                    bst.postOrderTraversal();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Insert data into the BST");
        System.out.println("2. Show contents using Inorder traversal");
        System.out.println("3. Show contents using Preorder traversal");
        System.out.println("4. Show contents using Postorder traversal");
        System.out.println("5. Exit");
    }
}
