class Node {
  int data;
  Node prev;
  Node next;

  public Node(int data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }
}

class DoublyCircularLinkedListADT {
  Node head;

  public DoublyCircularLinkedListADT() {
    this.head = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void insertAtFront(int data) {
    Node newNode = new Node(data);
    if (isEmpty()) {
      head = newNode;
      newNode.next = newNode;
      newNode.prev = newNode;
    } else {
      Node tail = head.prev;
      newNode.next = head;
      newNode.prev = tail;
      head.prev = newNode;
      tail.next = newNode;
      head = newNode;
    }
  }

  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (isEmpty()) {
      head = newNode;
      newNode.next = newNode;
      newNode.prev = newNode;
    } else {
      Node tail = head.prev;
      newNode.next = head;
      newNode.prev = tail;
      tail.next = newNode;
      head.prev = newNode;
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
    newNode.prev = current;
    current.next.prev = newNode;
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
      Node tail = head.prev;
      head = head.next;
      head.prev = tail;
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
      Node tail = head.prev;
      Node newTail = tail.prev;
      newTail.next = head;
      head.prev = newTail;
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
    for (int i = 1; i < index; i++) {
      current = current.next;
    }

    current.prev.next = current.next;
    current.next.prev = current.prev;
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

  public void displayReverse() {
    if (isEmpty()) {
      System.out.println("Linked list is empty");
      return;
    }

    Node current = head.prev; // Start from tail
    System.out.print("Reverse: ");
    do {
      System.out.print(current.data + " ");
      current = current.prev;
    } while (current != head.prev);
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
}

public class DoublyCircularLinkedList {
  public static void main(String[] args) {
    DoublyCircularLinkedListADT linkedList = new DoublyCircularLinkedListADT();

    System.out.println("=== Doubly Circular Linked List Demo ===");

    // Test insertions
    System.out.println("\n--- Testing Insertions ---");
    linkedList.insertAtFront(3);
    linkedList.insertAtFront(2);
    linkedList.insertAtFront(1);
    linkedList.display(); // Output: Forward: 1 2 3

    linkedList.insertAtEnd(4);
    linkedList.insertAtEnd(5);
    linkedList.display(); // Output: Forward: 1 2 3 4 5
    linkedList.displayReverse(); // Output: Reverse: 5 4 3 2 1

    linkedList.insertAtIndex(10, 3);
    linkedList.display(); // Output: Forward: 1 2 10 3 4 5

    // Test circular property
    System.out.println("\n--- Testing Circular Property ---");
    linkedList.displayCircularProperty();

    // Test deletions
    System.out.println("\n--- Testing Deletions ---");
    linkedList.deleteAtFront();
    linkedList.display(); // Output: Forward: 2 10 3 4 5

    linkedList.deleteAtEnd();
    linkedList.display(); // Output: Forward: 2 10 3 4

    linkedList.deleteAtIndex(2);
    linkedList.display(); // Output: Forward: 2 3 4

    // Test search
    System.out.println("\n--- Testing Search ---");
    System.out.println("Search for 3: " + linkedList.search(3)); // true
    System.out.println("Search for 10: " + linkedList.search(10)); // false

    // Test size
    System.out.println("\n--- Testing Size ---");
    System.out.println("Size: " + linkedList.getSize()); // 3

    // Test edge cases
    System.out.println("\n--- Testing Edge Cases ---");
    DoublyCircularLinkedListADT emptyList = new DoublyCircularLinkedListADT();
    emptyList.display();
    emptyList.deleteAtFront();

    DoublyCircularLinkedListADT singleNodeList = new DoublyCircularLinkedListADT();
    singleNodeList.insertAtFront(100);
    singleNodeList.display();
    singleNodeList.deleteAtFront();
    singleNodeList.display();
  }
}
