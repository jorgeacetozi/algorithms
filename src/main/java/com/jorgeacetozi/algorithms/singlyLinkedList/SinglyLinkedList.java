package com.jorgeacetozi.algorithms.singlyLinkedList;

class SinglyLinkedList {

  Node head;

  void insertStart(int value) {
    head = this.insertStart(this.head, value);
  }

  // O(1)
  private Node insertStart(Node currentNode, int value) {
    if (head == null) {
      return new Node(value);
    } else {
      Node newNode = new Node(value);
      newNode.next = this.head;
      this.head = newNode;
      return newNode;
    }
  }

}
