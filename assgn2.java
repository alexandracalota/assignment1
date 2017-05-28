
public class Node {
	private int key;
	private Node leftSon;
	private Node rightSon;

	public Node(int key) {
		this.key = key;
		leftSon = null;
		rightSon = null;
	}

	public void insertNode(int key, int parentKey, String position) {

		if (this.key == parentKey) {
			switch (position) {
			case "L":
				if (leftSon == null) {
					leftSon = new Node(key);
				}
				break;
			case "R":
				if (rightSon == null) {
					rightSon = new Node(key);
				}
				break;
			}
		} else {
			if (leftSon != null)
				leftSon.insertNode(key, parentKey, position);
			if (rightSon != null)
				rightSon.insertNode(key, parentKey, position);
		}
	}
	
	public void printTree() {
		System.out.print(key + " ( ");
		
		if (leftSon != null)
			leftSon.printTree();
		else
			System.out.print("- ");
		if (rightSon != null)
			rightSon.printTree();
		else
			System.out.print("- )");
		System.out.print(" )");
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(Node leftSon) {
		this.leftSon = leftSon;
	}

	public Node getRightSon() {
		return rightSon;
	}

	public void setRightSon(Node rightSon) {
		this.rightSon = rightSon;
	}
}



import java.util.Scanner;
import java.util.Stack;

public class Main {

	/******************** Question 2 ********************/
	public static Node lowestCommonAncestor(int key1, int key2, Node root) {
		if (root == null)
			return null;

		if (root.getKey() == key1 || root.getKey() == key2)
			return root;

		Node left = lowestCommonAncestor(key1, key2, root.getLeftSon());
		Node right = lowestCommonAncestor(key1, key2, root.getRightSon());

		if (left != null && right != null)
			return root;
		else if (left != null)
			return left;
		else
			return right;
	}
	
	
	/******************** Question 1 ********************/
	public static Boolean auxQ1(Stack<Node> parents, int key, Node root) {
		if (root == null)
			return false;

		if (root.getKey() == key)
			return true;

		if (auxQ1(parents, key, root.getLeftSon()) || auxQ1(parents, key, root.getRightSon())) {
			parents.add(root);
			return true;
		}

		return false;
	}

	public static void printAncestors(int key, Node root) {

		Stack<Node> parents = new Stack<Node>();

		auxQ1(parents, key, root);

		System.out.print("Ancestors: ");

		for (Node n : parents) {
			System.out.print(n.getKey() + " ");
		}

		System.out.println();
	}
	
	/******************** Main ********************/
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numberOfNodes = sc.nextInt();

		System.out.println("Number of nodes: " + numberOfNodes);

		Node root = new Node(sc.nextInt());

		System.out.println("Root: " + root.getKey());

		for (int i = 1; i < numberOfNodes; i++) {
			int key = sc.nextInt();
			int parentKey = sc.nextInt();
			String position = sc.next();

			root.insertNode(key, parentKey, position);
		}
		
		root.printTree();

		System.out.println("Question 1 -----");
		
		int key = sc.nextInt();

		printAncestors(key, root);

		System.out.println("Question 2 -----");
		
		int key1 = sc.nextInt();
		int key2 = sc.nextInt();
		
		System.out.println(lowestCommonAncestor(key1, key2, root).getKey());
		
		sc.close();
	}

}
