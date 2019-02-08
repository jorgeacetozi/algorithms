package com.jorgeacetozi.algorithms.singlyLinkedList;

class SinglyLinkedListWithTail {

  Node head, tail;

  // O(1), just update some references
  void insertStart(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      this.head = this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  // O(1), just update some references
  void insertEnd(int value) {
    Node newNode = new Node(value);
    if (this.head == null) {
      this.head = this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }

}
