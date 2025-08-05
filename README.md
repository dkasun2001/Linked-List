# Linked List Data Structures in Java

This repository contains comprehensive implementations of various linked list data structures in Java, developed as part of Computer Programming 2 coursework.

## 📚 Overview

This project demonstrates different types of linked list implementations, showcasing fundamental data structure concepts and their practical applications. Each implementation includes both integer-specific and generic (any type) versions to illustrate Java generics usage.

## 🗂️ Project Structure

```
Linked List/
├── SinglyLinkedList/
│   ├── 1. Singly Linked List/
│   │   └── SinglyLinkedList.java
│   ├── 2. Singly Any Type Linked List/
│   │   └── SinglyLLAnyType.java
│   ├── 3. Singly Circular Linked List/
│   │   └── SinglyCircularLinkedList.java
│   └── 4. Singly Circular Any Type Linked List/
│       └── SinglyCircularLinkedListAnyType.java
│
└── DoublyLinkedList/
    ├── 1. Doubly Linked List/
    │   └── DoublyLinkedList.java
    ├── 2. Doubly Linked List Any Type/
    │   └── DoublyLinkedListAnyType.java
    ├── 3. Doubly Circular Linked List/
    │   └── DoublyCircularLinkedList.java
    └── 4. Doubly Circular Linked List Any Type/
        └──DoublyCircularLinkedListAnyType.java
```

## 🔗 Implementations

### Singly Linked Lists

#### 1. Basic Singly Linked List

- **File**: `SinglyLinkedList/1. Singly Linked List/SinglyLinkedList.java`
- **Description**: Basic implementation with integer data
- **Features**:
  - Insert at front, rear, and specific positions
  - Delete operations
  - Search functionality
  - Display methods

#### 2. Generic Singly Linked List

- **File**: `SinglyLinkedList/2. Singly Any Type Linked List/SinglyLLAnyType.java`
- **Description**: Generic implementation supporting any data type
- **Features**: Same as basic version but with type safety using Java generics

#### 3. Singly Circular Linked List

- **File**: `SinglyLinkedList/3. Singly Circular Linked List/SinglyCircularLinkedList.java`
- **Description**: Circular implementation where the last node points to the first
- **Features**:
  - Circular traversal
  - No null pointers in the chain
  - Enhanced for cyclic operations

#### 4. Generic Singly Circular Linked List

- **File**: `SinglyLinkedList/4. Singly Circular Any Type Linked List/SinglyCircularLinkedListAnyType.java`
- **Description**: Generic version of circular singly linked list

### Doubly Linked Lists

#### 1. Basic Doubly Linked List

- **File**: `DoublyLinkedList/1. Doubly Linked List/DoublyLinkedList.java`
- **Description**: Bidirectional linked list with integer data
- **Features**:
  - Forward and backward traversal
  - Efficient insertion/deletion at both ends
  - Previous and next node references

#### 2. Generic Doubly Linked List

- **File**: `DoublyLinkedList/2. Doubly Linked List Any Type/DoublyLinkedListAnyType.java`
- **Description**: Generic implementation of doubly linked list

#### 3. Doubly Circular Linked List

- **File**: `DoublyLinkedList/3. Doubly Circular Linked List/DoublyCircularLinkedList.java`
- **Description**: Circular doubly linked list implementation
- **Features**:
  - Bidirectional circular traversal
  - First node's previous points to last node
  - Last node's next points to first node

#### 4. Generic Doubly Circular Linked List

- **File**: `DoublyLinkedList/4. Doubly Circular Linked List Any Type/DoublyCircularLinkedListAnyType.java`
- **Description**: Generic version of circular doubly linked list

## 🚀 Common Operations

All implementations typically support the following operations:

- **Insertion**:

  - `insertAtFront(data)` - Insert at the beginning
  - `insertAtRear(data)` - Insert at the end
  - `insertAtPosition(data, position)` - Insert at specific position

- **Deletion**:

  - `deleteAtFront()` - Remove first element
  - `deleteAtRear()` - Remove last element
  - `deleteAtPosition(position)` - Remove element at position
  - `deleteByValue(data)` - Remove element by value

- **Search & Access**:

  - `search(data)` - Find element
  - `get(index)` - Get element at index
  - `indexOf(data)` - Get index of element

- **Utility**:
  - `isEmpty()` - Check if list is empty
  - `size()` - Get number of elements
  - `display()` - Print all elements
  - `reverse()` - Reverse the list

## 💻 How to Compile and Run

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line interface or Java IDE

### Compilation

```bash
# Navigate to the specific implementation directory
cd "SinglyLinkedList/1. Singly Linked List"

# Compile the Java file
javac SinglyLinkedList.java

# Run the program
java SinglyLinkedList
```

### Example Usage

```java
// Create a new linked list
LinkedListADT list = new LinkedListADT();

// Insert elements
list.insertAtFront(10);
list.insertAtRear(20);
list.insertAtPosition(15, 1);

// Display the list
list.display(); // Output: 10 -> 15 -> 20

// Search for an element
boolean found = list.search(15); // returns true

// Delete an element
list.deleteByValue(15);
list.display(); // Output: 10 -> 20
```

## 🎯 Learning Objectives

This project demonstrates:

1. **Data Structure Fundamentals**:

   - Understanding node-based data structures
   - Pointer/reference manipulation
   - Memory management concepts

2. **Algorithm Implementation**:

   - Insertion and deletion algorithms
   - Search algorithms
   - Traversal techniques

3. **Java Programming Concepts**:

   - Object-oriented programming
   - Generic programming
   - Package organization
   - Abstract Data Types (ADT)

4. **Complexity Analysis**:
   - Time complexity of different operations
   - Space complexity considerations
   - Trade-offs between different implementations

## 📊 Time Complexity

| Operation       | Singly LL | Doubly LL | Circular LL |
| --------------- | --------- | --------- | ----------- |
| Insert at Front | O(1)      | O(1)      | O(1)        |
| Insert at Rear  | O(n)      | O(1)\*    | O(n)        |
| Delete at Front | O(1)      | O(1)      | O(1)        |
| Delete at Rear  | O(n)      | O(1)\*    | O(n)        |
| Search          | O(n)      | O(n)      | O(n)        |
| Access by Index | O(n)      | O(n)      | O(n)        |

\*Assuming tail pointer is maintained

## 🤝 Contributing

This is an educational project. Feel free to:

- Suggest improvements
- Add more test cases
- Optimize existing implementations
- Add documentation

## 📝 License

This project is created for educational purposes as part of Computer Programming 2 coursework.

## 📞 Contact

For questions or suggestions regarding this implementation, please refer to the course materials or contact the instructor.

---

**Note**: This project demonstrates various linked list implementations for educational purposes. Each implementation includes comprehensive methods for manipulation and traversal of the data structure.
