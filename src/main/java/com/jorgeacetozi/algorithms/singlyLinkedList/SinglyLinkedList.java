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
    Node previousNode = null;
    Node currentNode = head;
    while (currentNode != null) {
      if (currentNode.value == value) {
        if (head.next == null) { // case 2: only one node
          head = null;
          return true;
        } else if (currentNode == head) { // case 3: two or more nodes and it's the head
          head = head.next;
          return true;
        } else { // case 4: two or more nodes and it's not the head. As there is no tail here, we
                 // treat the cases of removing a node from the middle of the list and the last node
                 // equally
          previousNode.next = currentNode.next;
          return true;
        }
      }
      previousNode = currentNode;
      currentNode = currentNode.next;
    }
    return false;
  }

  // O(N)
  boolean find(int value) {
    Node currentNode = this.head;
    while (currentNode != null) {
      if (currentNode.value == value) {
        return true;
      }
      currentNode = currentNode.next;
    }
    return false;
  }
}
