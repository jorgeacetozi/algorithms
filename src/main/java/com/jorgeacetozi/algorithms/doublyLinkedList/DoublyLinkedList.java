package com.jorgeacetozi.algorithms.doublyLinkedList;

class DoublyLinkedList {

  Node head, tail;

  // O(1)
  void insertStart(int value) {
    Node newNode = new Node(value);
    if (head == null) { // case 1: empty list
      head = tail = newNode;
    } else { // case 2: not empty list
      newNode.next = head;
      head.previous = newNode;
      head = newNode;
    }
  }

  // O(1)
  void insertEnd(int value) {
    Node newNode = new Node(value);
    if (head == null) { // case 1: empty list
      head = tail = newNode;
    } else { // case 2: not empty list
      newNode.previous = tail;
      tail.next = newNode;
      tail = newNode;
    }
  }
}
