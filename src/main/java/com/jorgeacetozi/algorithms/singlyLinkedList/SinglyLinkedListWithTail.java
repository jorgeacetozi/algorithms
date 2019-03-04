package com.jorgeacetozi.algorithms.singlyLinkedList;

class SinglyLinkedListWithTail {

  Node head, tail;

  // O(1), just update some references
  void insertStart(int value) {
    Node newNode = new Node(value);
    if (head == null) { // case 1: the list is empty
      this.head = this.tail = newNode;
    } else { // case 2: the list is not empty
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  // O(1), just update some references
  // This is the big advantage over the singly linked list without tail
  void insertEnd(int value) {
    Node newNode = new Node(value);
    if (this.head == null) { // case 1: the list is empty
      this.head = this.tail = newNode;
    } else { // case 2: the list is not empty
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }

  // O(1), just update some references
  void removeStart() {
    if (this.head == null) { // case 1: the list is empty
      throw new RuntimeException("The list is empty");
    }
    if (this.head == this.tail) { // case 2: there is only one node
      this.head = this.tail = null;
    } else {
      this.head = this.head.next; // case 3: there are two or more nodes
    }
  }

  // O(N), we have to move towards the end of the list with two pointers
  void removeEnd() {
    if (head == null) { // case 1: the list is empty
      throw new RuntimeException("The list is empty"); // the list is empty
    }
    if (head == tail) { // case 2: there is only one node
      head = tail = null;
    } else { // case 3: there are two or more nodes
      Node previousNode = this.head;
      Node currentNode = this.head.next;

      while (currentNode.next != null) {
        previousNode = currentNode;
        currentNode = currentNode.next;
      }

      previousNode.next = null;
      this.tail = previousNode;
    }
  }

  // O(N). This is trickier because the element being removed might be the last one
  // Fortunately, this isn't much used as linked lists are mainly used for stacks and (with tail or
  // circular) queues
  boolean removeItem(int value) {
    if (head == null) { // case 1: the list is empty
      throw new RuntimeException("The list is empty");
    }
    Node previousNode = null;
    Node currentNode = head;
    while (currentNode != null) { // first you find the node, then you treat each case separately
      if (currentNode.value == value) {
        if (head == tail) { // case 2: only one node
          head = tail = null;
          return true;
        } else if (currentNode == head) { // case 3: two or more nodes and the item is the head
          head = head.next;
          return true;
        } else if (currentNode == tail) { // case 4: two or more nodes and the item is the tail
          tail = previousNode;
          tail.next = null;
          return true;
        } else { // case 5: two or more nodes and the item is in between the head and the tail
          previousNode.next = currentNode.next;
          return true;
        }
      }
      previousNode = currentNode;
      currentNode = currentNode.next;
    }
    return false;
  }

  boolean find(int value) {
    Node currentNode = head;
    while (currentNode != null) {
      if (currentNode.value == value) {
        return true;
      }
      currentNode = currentNode.next;
    }
    return false;
  }
}
