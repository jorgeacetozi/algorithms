package com.jorgeacetozi.algorithms.singlyLinkedList;

class SinglyLinkedList {

  Node head;

  void insertStart(int value) {
    head = this.insertStart(this.head, value);
  }

  // O(1)
  private Node insertStart(Node currentNode, int value) {
    if (currentNode == null) {
      return new Node(value);
    } else {
      Node newNode = new Node(value);
      newNode.next = currentNode;
      currentNode = newNode;
      return newNode;
    }
  }

  void insertEnd(int value) {
    head = this.insertEnd(this.head, value);
  }

  // O(N)
  private Node insertEnd(Node currentNode, int value) {
    if (currentNode == null) {
      return new Node(value);
    }
    currentNode.next = insertEnd(currentNode.next, value);
    return currentNode;
  }

  void removeItem(int value) {
    this.head = this.removeItem(this.head, value);
  }

  private Node removeItem(Node currentNode, int value) {
    if (currentNode == null) {
      return null;
    }

    if (currentNode.value == value) {
      return currentNode.next;
    }

    currentNode.next = removeItem(currentNode.next, value);
    return currentNode;
  }

}
