package DoublyLinkedList.DoublyLinkedListAnyType;
class NodeAnyType<T> {
  T data;
  NodeAnyType<T> prev;
  NodeAnyType<T> next;

  public NodeAnyType(T data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }
}

class DoublyLinkedListAnyTypeADT<T> {
  NodeAnyType<T> head;

  public DoublyLinkedListAnyTypeADT() {
    this.head = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void insertAtFront(T data) {
    NodeAnyType<T> newNode = new NodeAnyType<>(data);
    if (isEmpty()) {
      head = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  public void insertAtEnd(T data) {
    NodeAnyType<T> newNode = new NodeAnyType<>(data);
    if (isEmpty()) {
      head = newNode;
    } else {
      NodeAnyType<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
      newNode.prev = current;
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
    newNode.prev = current;
    if (current.next != null) {
      current.next.prev = newNode;
    }
    current.next = newNode;
  }

  public void deleteAtFront() {
    if (isEmpty()) {
      System.out.println("Linked list is empty");
    } else {
      if (head.next != null) {
        head.next.prev = null;
      }
      head = head.next;
    }
  }

  public void deleteAtEnd() {
    if (isEmpty()) {
      System.out.println("Linked list is empty");
    } else if (head.next == null) {
      head = null;
    } else {
      NodeAnyType<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.prev.next = null;
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
    NodeAnyType<T> current = head;
    for (int i = 1; i < index; i++) {
      current = current.next;
    }
    current.prev.next = current.next;
    if (current.next != null) {
      current.next.prev = current.prev;
    }
  }

  public boolean search(T data) {
    NodeAnyType<T> current = head;
    while (current != null) {
      if (current.data.equals(data)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  public int getSize() {
    int count = 0;
    NodeAnyType<T> current = head;
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
      NodeAnyType<T> current = head;
      while (current != null) {
        System.out.print(current.data + " ");
        current = current.next;
      }
      System.out.println();
    }
  }
}

public class DoublyLinkedListAnyType {
  public static void main(String[] args) {
    // Test with Integer
    System.out.println("Testing with Integer:");
    DoublyLinkedListAnyTypeADT<Integer> intList = new DoublyLinkedListAnyTypeADT<>();

    intList.insertAtFront(3);
    intList.insertAtFront(2);
    intList.insertAtFront(1);

    intList.display(); // Output: 1 2 3

    intList.insertAtEnd(4);
    intList.insertAtEnd(5);

    intList.display(); // Output: 1 2 3 4 5

    intList.insertAtIndex(10, 2);

    intList.display(); // Output: 1 2 10 3 4 5

    intList.deleteAtFront();
    intList.deleteAtEnd();

    intList.display(); // Output: 2 10 3 4

    intList.deleteAtIndex(2);

    intList.display(); // Output: 2 10 4

    System.out.println("Search for 10: " + intList.search(10)); // Output: true
    System.out.println("Search for 99: " + intList.search(99)); // Output: false
    System.out.println("Size: " + intList.getSize()); // Output: 3

    System.out.println("\nTesting with String:");
    DoublyLinkedListAnyTypeADT<String> stringList = new DoublyLinkedListAnyTypeADT<>();

    stringList.insertAtFront("World");
    stringList.insertAtFront("Hello");
    stringList.insertAtEnd("!");

    stringList.display(); // Output: Hello World !

    stringList.insertAtIndex("Beautiful", 2);

    stringList.display(); // Output: Hello Beautiful World !

    System.out.println("Search for 'World': " + stringList.search("World")); // Output: true
    System.out.println("Size: " + stringList.getSize()); // Output: 4

    System.out.println("\nTesting with Double:");
    DoublyLinkedListAnyTypeADT<Double> doubleList = new DoublyLinkedListAnyTypeADT<>();

    doubleList.insertAtEnd(3.14);
    doubleList.insertAtEnd(2.71);
    doubleList.insertAtFront(1.41);

    doubleList.display(); // Output: 1.41 3.14 2.71

    System.out.println("Search for 3.14: " + doubleList.search(3.14)); // Output: true
    System.out.println("Size: " + doubleList.getSize()); // Output: 3
  }
}
