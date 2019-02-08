package com.jorgeacetozi.algorithms.singlyLinkedList;

class SinglyLinkedListWithTail {

  Node head, tail;

  // O(1), just update some references
  void insertStart(int value) {
    Node newNode = new Node(value);
    if (head == null) { // case 1: there is only one node
      this.head = this.tail = newNode;
    } else { // case 2: there are two or more nodes
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  // O(1), just update some references
  void insertEnd(int value) {
    Node newNode = new Node(value);
    if (this.head == null) { // case 1: there is only one node
      this.head = this.tail = newNode;
    } else { // case 2: there are two or more nodes
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }

  // O(1), just update some references
  void removeStart() {
    if (this.head == this.tail) { // case 1: there is only one node
      this.head = this.tail = null;
    } else {
      this.head = this.head.next; // case 2: there are two or more nodes
    }
  }

  // O(N), we have to move towards the end of the list with two pointers
  void removeEnd() {
    if (head == tail) { // case 1: there is only one node
      head = tail = null;
    } else { // case 2: there are two or more nodes
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
}
