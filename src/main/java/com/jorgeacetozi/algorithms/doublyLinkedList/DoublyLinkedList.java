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

  // O(1)
  void removeStart() {
    if (head == null) {
      throw new RuntimeException("The list is empty"); // case 1: empty list
    } else if (head == tail) { // case 2: the list has one element
      head = tail = null;
    } else { // case 3: the list has two or more nodes
      head = head.next;
      head.previous = null;
    }
  }

  // O(1)
  void removeEnd() {
    if (head == null) {
      throw new RuntimeException("The list is empty"); // case 1: empty list
    } else if (head == tail) {
      head = tail = null;
    } else {
      tail = tail.previous;
      tail.next = null;
    }
  }

  // O(N)
  boolean removeItem(int value) {
    if (head == null) { // case 1: empty list
      throw new RuntimeException("The list is empty");
    }
    Node currentNode = head;
    while (currentNode != null) { // first you find the node, then you treat each case separately
      if (currentNode.value == value) {
        if (head == tail) { // case 2: only one node
          head = tail = null;
          return true;
        } else if (currentNode == head) { // case 3: two or more nodes and the item happens to be the head
          head = head.next;
          head.previous = null;
          return true;
        } else if (currentNode == tail) { // case 4: two or more nodes and the item happens to be the tail
          tail = tail.previous;
          tail.next = null;
          return true;
        } else { // case 5: two or more nodes and the item happens to be in between the head and the tail
          Node previous = currentNode.previous;
          Node next = currentNode.next;
          previous.next = next;
          next.previous = previous;
          return true;
        }
      }
      currentNode = currentNode.next;
    }
    return false;
  }

  // O(N)
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
