package DoublyLinkedList.DoublyLinkedList;
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

class DoublyLinkedListADT {
    Node head;

    public DoublyLinkedListADT() {
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
            head.prev = newNode;
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
            newNode.prev = current;
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
            Node current = head;
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
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        if (current.next != null) {
            current.next.prev = current.prev;
        }
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

public class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedListADT linkedList = new DoublyLinkedListADT();

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
