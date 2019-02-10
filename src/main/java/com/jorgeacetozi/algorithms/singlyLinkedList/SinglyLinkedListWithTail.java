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
    } else if (head == tail) { // case 2: the list has only one node
      if (head.value == value) {
        head = tail = null;
        return true;
      } else {
        return false;
      }
    } else { // case 3: the list has two or more nodes and the item is in the middle of the list
      Node previousNode = this.head;
      Node currentNode = this.head.next;

      while (currentNode != null) {
        if (currentNode.value == value) {
          if (currentNode.next == null) { // case 4: the item is the last element of the list
            this.tail = previousNode;
          }
          previousNode.next = currentNode.next;
          return true;
        }
        previousNode = currentNode;
        currentNode = currentNode.next;
      }
      return false;
    }
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
