class NodeAnyType<T> {
  T data;
  NodeAnyType<T> next;

  public NodeAnyType(T data) {
    this.data = data;
    this.next = null;
  }
}

class SinglyCircularLinkedListAnyTypeADT<T> {
  NodeAnyType<T> head;

  public SinglyCircularLinkedListAnyTypeADT() {
    this.head = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void insertAtFront(T data) {
    NodeAnyType<T> newNode = new NodeAnyType<>(data);
    if (isEmpty()) {
      head = newNode;
      newNode.next = newNode; // Point to itself
    } else {
      NodeAnyType<T> tail = getTail();
      newNode.next = head;
      tail.next = newNode;
      head = newNode;
    }
  }

  public void insertAtEnd(T data) {
    NodeAnyType<T> newNode = new NodeAnyType<>(data);
    if (isEmpty()) {
      head = newNode;
      newNode.next = newNode; // Point to itself
    } else {
      NodeAnyType<T> tail = getTail();
      newNode.next = head;
      tail.next = newNode;
    }
  }

  public void insertAtIndex(T data, int index) {
    if (index < 1 || index > getSize() + 1) {
      System.out.println("Invalid index");
      return;
    }
    if (index == 1) {
      insertAtFront(data);
      return;
    }

    NodeAnyType<T> newNode = new NodeAnyType<>(data);
    NodeAnyType<T> current = head;
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
      NodeAnyType<T> tail = getTail();
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
      NodeAnyType<T> current = head;
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

    NodeAnyType<T> current = head;
    for (int i = 1; i < index - 1; i++) {
      current = current.next;
    }

    current.next = current.next.next;
  }

  public boolean search(T data) {
    if (isEmpty()) {
      return false;
    }

    NodeAnyType<T> current = head;
    do {
      if (current.data.equals(data)) {
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
    NodeAnyType<T> current = head;
    do {
      count++;
      current = current.next;
    } while (current != head);

    return count;
  }

  private NodeAnyType<T> getTail() {
    if (isEmpty()) {
      return null;
    }

    NodeAnyType<T> current = head;
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

    NodeAnyType<T> current = head;
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
    NodeAnyType<T> current = head;
    int count = 0;
    int maxDisplay = getSize() + 3; // Show a few extra to demonstrate circularity

    while (count < maxDisplay) {
      System.out.print(current.data + " ");
      current = current.next;
      count++;
    }
    System.out.println("...");
  }

  // Additional utility methods for generic implementation
  public T getFirst() {
    if (isEmpty()) {
      return null;
    }
    return head.data;
  }

  public T getLast() {
    if (isEmpty()) {
      return null;
    }
    return getTail().data;
  }

  public T getAtIndex(int index) {
    if (isEmpty() || index < 1 || index > getSize()) {
      return null;
    }

    NodeAnyType<T> current = head;
    for (int i = 1; i < index; i++) {
      current = current.next;
    }
    return current.data;
  }
}

public class SinglyCircularLinkedListAnyType {
  public static void main(String[] args) {
    System.out.println("=== Singly Circular Linked List Any Type Demo ===");

    // Test with Integer type
    System.out.println("\n--- Testing with Integer Type ---");
    SinglyCircularLinkedListAnyTypeADT<Integer> intList = new SinglyCircularLinkedListAnyTypeADT<>();

    // Test insertions
    System.out.println("\n--- Testing Insertions ---");
    intList.insertAtFront(3);
    intList.insertAtFront(2);
    intList.insertAtFront(1);
    intList.display(); // Output: Forward: 1 2 3

    intList.insertAtEnd(4);
    intList.insertAtEnd(5);
    intList.display(); // Output: Forward: 1 2 3 4 5

    intList.insertAtIndex(10, 3);
    intList.display(); // Output: Forward: 1 2 10 3 4 5

    // Test circular property
    System.out.println("\n--- Testing Circular Property ---");
    intList.displayCircularProperty();

    // Test deletions
    System.out.println("\n--- Testing Deletions ---");
    intList.deleteAtFront();
    intList.display(); // Output: Forward: 2 10 3 4 5

    intList.deleteAtEnd();
    intList.display(); // Output: Forward: 2 10 3 4

    intList.deleteAtIndex(2);
    intList.display(); // Output: Forward: 2 3 4

    // Test search and utility methods
    System.out.println("\n--- Testing Search and Utility Methods ---");
    System.out.println("Search for 3: " + intList.search(3)); // true
    System.out.println("Search for 10: " + intList.search(10)); // false
    System.out.println("Size: " + intList.getSize()); // 3
    System.out.println("First element: " + intList.getFirst()); // 2
    System.out.println("Last element: " + intList.getLast()); // 4
    System.out.println("Element at index 2: " + intList.getAtIndex(2)); // 3

    // Test with String type
    System.out.println("\n--- Testing with String Type ---");
    SinglyCircularLinkedListAnyTypeADT<String> stringList = new SinglyCircularLinkedListAnyTypeADT<>();

    stringList.insertAtFront("World");
    stringList.insertAtFront("Hello");
    stringList.insertAtEnd("!");
    stringList.insertAtEnd("Java");
    stringList.display(); // Output: Forward: Hello World ! Java

    stringList.displayCircularProperty();

    System.out.println("Search for 'World': " + stringList.search("World")); // true
    System.out.println("Search for 'Python': " + stringList.search("Python")); // false
    System.out.println("Size: " + stringList.getSize()); // 4

    // Test with Double type
    System.out.println("\n--- Testing with Double Type ---");
    SinglyCircularLinkedListAnyTypeADT<Double> doubleList = new SinglyCircularLinkedListAnyTypeADT<>();

    doubleList.insertAtFront(3.14);
    doubleList.insertAtEnd(2.71);
    doubleList.insertAtEnd(1.41);
    doubleList.display(); // Output: Forward: 3.14 2.71 1.41

    doubleList.displayCircularProperty();
    System.out.println("Search for 2.71: " + doubleList.search(2.71)); // true
    System.out.println("First element: " + doubleList.getFirst()); // 3.14
    System.out.println("Last element: " + doubleList.getLast()); // 1.41

    // Test edge cases
    System.out.println("\n--- Testing Edge Cases ---");
    SinglyCircularLinkedListAnyTypeADT<Integer> emptyList = new SinglyCircularLinkedListAnyTypeADT<>();
    emptyList.display();
    emptyList.deleteAtFront();
    System.out.println("Empty list size: " + emptyList.getSize());
    System.out.println("Empty list first element: " + emptyList.getFirst());

    SinglyCircularLinkedListAnyTypeADT<String> singleNodeList = new SinglyCircularLinkedListAnyTypeADT<>();
    singleNodeList.insertAtFront("Single");
    singleNodeList.display();
    singleNodeList.displayCircularProperty();
    singleNodeList.deleteAtFront();
    singleNodeList.display();
  }
}
