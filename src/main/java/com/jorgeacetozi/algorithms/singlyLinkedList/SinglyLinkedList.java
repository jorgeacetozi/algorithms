package com.jorgeacetozi.algorithms.singlyLinkedList;

class SinglyLinkedList {

  Node head;

  // O(1)
  void insertStart(int value) {
    Node newNode = new Node(value);
    if (this.head == null) { // case 1: the list is empty
      this.head = newNode;
    } else { // case 2: the list is not empty
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  // O(N)
  void insertEnd(int value) {
    Node newNode = new Node(value);
    if (this.head == null) { // case 1: the list is empty
      this.head = newNode;
    } else { // case 2: the list is not empty
      Node currentNode = this.head;
      while (currentNode.next != null) {
        currentNode = currentNode.next;
      }
      currentNode.next = newNode;
    }
  }

  // O(1)
  void removeStart() {
    if (this.head == null) { // case 1: the list is empty
      throw new RuntimeException("The list is empty");
    }
    this.head = this.head.next; // covers case 2 and 3 (one node and more than one node)
  }

  // O(N)
  void removeEnd() {
    if (this.head == null) { // case 1: the list is empty
      throw new RuntimeException("The list is empty");
    }
    if (this.head.next == null) { // case 2: there is only one node
      this.head = null;
    } else { // case 3: there are at least two nodes
      Node previousNode = this.head;
      Node currentNode = this.head.next;
      
      while (currentNode.next != null) {
        previousNode = currentNode;
        currentNode = currentNode.next;
      }
      
      previousNode.next = null;
    }
  }

  // O(N)
  boolean removeItem(int value) {
    if (this.head == null) { // case 1: the list is empty
      throw new RuntimeException();
    }
    if (this.head.next == null) { // case 2: there is only one node
      if (this.head.value == value) {
        this.head = null;
        return true;
      } else {
        return false; // trying to remove an item that isn't in the list
      }
    } else { // case 2: there are two nodes, so we start comparing from the second
      Node previousNode = this.head;
      Node currentNode = this.head.next;

      while (currentNode != null) {
        if (currentNode.value == value) {
          previousNode.next = currentNode.next;
          return true;
        }
        previousNode = currentNode;
        currentNode = currentNode.next;
      }
      return false;
    }
  }

  // O(N)
  Node find(int value) {
    Node currentNode = this.head;
    while (currentNode != null) {
      if (currentNode.value == value) {
        return currentNode;
      }
      currentNode = currentNode.next;
    }
    return null;
  }
}
