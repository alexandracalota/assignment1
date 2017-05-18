package question2;

public class SinglyLinkedList {

	private Node first;
	private Node last;
	private int length;
	
	public SinglyLinkedList() {
		this.setFirst(null);
		this.setLast(null);
		this.setLength(0);
	}

	public void addNode(Node current) {
		if(first == null) {
			first = current;
			last = current;
			length = 1;
		} else {
			last.setNext(current);
			last = current;
			length++;
		}
			}
	
	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}


package question2;

public class Node {
	
	private int value;
	private Node next;
	
	public Node(int value, Node next) {
		this.setValue(value);
		this.setNext(next);
	}
	
	public Node(int value) {
		this.setValue(value);
		setNext(null);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}


package question2;

import java.util.Scanner;

public class Question2 {

	public static Node getSolution(int k, SinglyLinkedList list) {
		if (k < 0 || k > list.getLength()) {
			return null;
		}

		Node current = list.getFirst();

		for (int i = list.getLength() - k; i > 1; i--) {
			current = current.getNext();
		}

		return current;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int number;
		SinglyLinkedList list = new SinglyLinkedList();

		int k = sc.nextInt();
		
		while (sc.hasNextInt()) {
			number = sc.nextInt();
			list.addNode(new Node(number));
		}

		Node current = list.getFirst();

		while (current != null) {
			System.out.print(current.getValue() + " ");
			current = current.getNext();
		}
		
		Node sol = getSolution(k, list);

		if (sol != null)
			System.out.println(sol.getValue());
		else
			System.out.println("invalid k");

		sc.close();
	}

}