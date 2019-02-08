package com.jorgeacetozi.algorithms.singlyLinkedList;

class RecursiveSinglyLinkedList {

  Node head;

  // O(1), just update some references
  void insertStart(int value) {
    Node newNode = new Node(value);
    if (this.head == null) {
      this.head = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
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

  // O(N)
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

  void removeEnd() {
    head = this.removeEnd(this.head);
  }

  // O(N)
  private Node removeEnd(Node currentNode) {
    if (currentNode.next == null) {
      return null;
    }
    currentNode.next = removeEnd(currentNode.next);
    return currentNode;
  }

  // O(1), just update some references
  void removeStart() {
    this.head = this.head.next;
  }

  Node find(int value) {
    return this.find(this.head, value);
  }

  // O(N)
  private Node find(Node currentNode, int value) {
    if (currentNode == null) { // element not found
      return null;
    }
    if (currentNode.value == value) {
      return currentNode;
    }
    return find(currentNode.next, value);
  }
}
