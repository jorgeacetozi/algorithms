package com.jorgeacetozi.algorithms.doublyLinkedList;

class DoublyLinkedList {

  Node head, tail;

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
}
