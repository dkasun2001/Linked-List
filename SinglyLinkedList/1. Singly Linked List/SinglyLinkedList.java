package SinglyLinkedList.SinglyLinkedList;
class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedListADT {
	Node head;

	public LinkedListADT() {
		this.head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}

	public void insertAtFront(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void insertAtIndex(int data, int index) {
		if (index < 1 || index > getSize()+1) {
			System.out.println("Invalid index");
			return;
		}
		if (index == 1) {
			insertAtFront(data);
			return;
		}
		Node newNode = new Node(data);
		Node current = head;
		for (int c = 1; c < index - 1; c++){
			current = current.next;				
		}
		newNode.next = current.next;
		current.next = newNode;
	}

	public void deleteAtFront() {
		if (isEmpty()) {
			System.out.println("Linked list is empty");
		} else {
			head = head.next;
		}
	}

	public void deleteAtEnd() {
		if (isEmpty()) {
			System.out.println("Linked list is empty");
		} else if (head.next == null) {
			head = null;
		} else {
			Node current = head;
			Node previous = null;
			while (current.next != null) {
				previous = current;
				current = current.next;
			}
			previous.next = null;
		}
	}

	public void deleteAtIndex(int index) {
		if (index < 1 || index > getSize()) {
			System.out.println("Invalid index");
			return;
		}
		if (index == 1) {
			deleteAtFront();
			return;
		}
		Node current = head;
		for (int c = 1; c < index - 1; c++){
			current = current.next;				
		}
		current.next = current.next.next;
	}

	public boolean search(int data) {
		Node current = head;
		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public int getSize() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Linked list is empty");
		} else {
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
		}
	}
}

public class SinglyLinkedList {
	public static void main(String[] args) {
		LinkedListADT linkedList = new LinkedListADT();

		linkedList.insertAtFront(3);
		linkedList.insertAtFront(2);
		linkedList.insertAtFront(1);

		linkedList.display(); // Output: 1 2 3

		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);

		linkedList.display(); // Output: 1 2 3 4 5

		linkedList.insertAtIndex(10, 2);

		linkedList.display(); // Output: 1 2 10 3 4 5

		linkedList.deleteAtFront();
		linkedList.deleteAtEnd();

		linkedList.display(); // Output: 2 10 3 4
		
		linkedList.deleteAtIndex(2);

		linkedList.display(); // Output: 2 10 4
	}
}
