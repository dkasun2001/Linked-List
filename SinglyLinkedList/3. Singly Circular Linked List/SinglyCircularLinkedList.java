class Node {
  int data;
  Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class SinglyCircularLinkedListADT {
  Node head;

  public SinglyCircularLinkedListADT() {
    this.head = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void insertAtFront(int data) {
    Node newNode = new Node(data);
    if (isEmpty()) {
      head = newNode;
      newNode.next = newNode; // Point to itself
    } else {
      Node tail = getTail();
      newNode.next = head;
      tail.next = newNode;
      head = newNode;
    }
  }

  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (isEmpty()) {
      head = newNode;
      newNode.next = newNode; // Point to itself
    } else {
      Node tail = getTail();
      newNode.next = head;
      tail.next = newNode;
    }
  }

  public void insertAtIndex(int data, int index) {
    if (index < 1 || index > getSize() + 1) {
      System.out.println("Invalid index");
      return;
    }
    if (index == 1) {
      insertAtFront(data);
      return;
    }

    Node newNode = new Node(data);
    Node current = head;
    for (int i = 1; i < index - 1; i++) {
      current = current.next;
    }

    newNode.next = current.next;
    current.next = newNode;
  }

  public void deleteAtFront() {
    if (isEmpty()) {
      System.out.println("Linked list is empty");
      return;
    }

    if (head.next == head) { // Only one node
      head = null;
    } else {
      Node tail = getTail();
      head = head.next;
      tail.next = head;
    }
  }

  public void deleteAtEnd() {
    if (isEmpty()) {
      System.out.println("Linked list is empty");
      return;
    }

    if (head.next == head) { // Only one node
      head = null;
    } else {
      Node current = head;
      while (current.next.next != head) {
        current = current.next;
      }
      current.next = head;
    }
  }

  public void deleteAtIndex(int index) {
    if (isEmpty()) {
      System.out.println("Linked list is empty");
      return;
    }

    if (index < 1 || index > getSize()) {
      System.out.println("Invalid index");
      return;
    }

    if (index == 1) {
      deleteAtFront();
      return;
    }

    Node current = head;
    for (int i = 1; i < index - 1; i++) {
      current = current.next;
    }

    current.next = current.next.next;
  }

  public boolean search(int data) {
    if (isEmpty()) {
      return false;
    }

    Node current = head;
    do {
      if (current.data == data) {
        return true;
      }
      current = current.next;
    } while (current != head);

    return false;
  }

  public int getSize() {
    if (isEmpty()) {
      return 0;
    }

    int count = 0;
    Node current = head;
    do {
      count++;
      current = current.next;
    } while (current != head);

    return count;
  }

  private Node getTail() {
    if (isEmpty()) {
      return null;
    }

    Node current = head;
    while (current.next != head) {
      current = current.next;
    }
    return current;
  }

  public void display() {
    if (isEmpty()) {
      System.out.println("Linked list is empty");
      return;
    }

    Node current = head;
    System.out.print("Forward: ");
    do {
      System.out.print(current.data + " ");
      current = current.next;
    } while (current != head);
    System.out.println();
  }

  public void displayCircularProperty() {
    if (isEmpty()) {
      System.out.println("Linked list is empty");
      return;
    }

    System.out.println("Demonstrating circular property:");
    Node current = head;
    int count = 0;
    int maxDisplay = getSize() + 3; // Show a few extra to demonstrate circularity

    while (count < maxDisplay) {
      System.out.print(current.data + " ");
      current = current.next;
      count++;
    }
    System.out.println("...");
  }

  // Additional utility methods
  public int getFirst() {
    if (isEmpty()) {
      System.out.println("List is empty");
      return -1;
    }
    return head.data;
  }

  public int getLast() {
    if (isEmpty()) {
      System.out.println("List is empty");
      return -1;
    }
    return getTail().data;
  }

  public int getAtIndex(int index) {
    if (isEmpty() || index < 1 || index > getSize()) {
      System.out.println("Invalid index or empty list");
      return -1;
    }

    Node current = head;
    for (int i = 1; i < index; i++) {
      current = current.next;
    }
    return current.data;
  }
}

public class SinglyCircularLinkedList {
  public static void main(String[] args) {
    System.out.println("=== Singly Circular Linked List Demo ===");

    SinglyCircularLinkedListADT list = new SinglyCircularLinkedListADT();

    // Test insertions
    System.out.println("\n--- Testing Insertions ---");
    list.insertAtFront(3);
    list.insertAtFront(2);
    list.insertAtFront(1);
    list.display(); // Output: Forward: 1 2 3

    list.insertAtEnd(4);
    list.insertAtEnd(5);
    list.display(); // Output: Forward: 1 2 3 4 5

    list.insertAtIndex(10, 3);
    list.display(); // Output: Forward: 1 2 10 3 4 5

    // Test circular property
    System.out.println("\n--- Testing Circular Property ---");
    list.displayCircularProperty();

    // Test deletions
    System.out.println("\n--- Testing Deletions ---");
    list.deleteAtFront();
    list.display(); // Output: Forward: 2 10 3 4 5

    list.deleteAtEnd();
    list.display(); // Output: Forward: 2 10 3 4

    list.deleteAtIndex(2);
    list.display(); // Output: Forward: 2 3 4

    // Test search and utility methods
    System.out.println("\n--- Testing Search and Utility Methods ---");
    System.out.println("Search for 3: " + list.search(3)); // true
    System.out.println("Search for 10: " + list.search(10)); // false
    System.out.println("Size: " + list.getSize()); // 3
    System.out.println("First element: " + list.getFirst()); // 2
    System.out.println("Last element: " + list.getLast()); // 4
    System.out.println("Element at index 2: " + list.getAtIndex(2)); // 3

    // Test edge cases
    System.out.println("\n--- Testing Edge Cases ---");
    SinglyCircularLinkedListADT emptyList = new SinglyCircularLinkedListADT();
    emptyList.display();
    emptyList.deleteAtFront();
    System.out.println("Empty list size: " + emptyList.getSize());
    System.out.println("Empty list first element: " + emptyList.getFirst());

    SinglyCircularLinkedListADT singleNodeList = new SinglyCircularLinkedListADT();
    singleNodeList.insertAtFront(42);
    singleNodeList.display();
    singleNodeList.displayCircularProperty();
    singleNodeList.deleteAtFront();
    singleNodeList.display();
  }
}
