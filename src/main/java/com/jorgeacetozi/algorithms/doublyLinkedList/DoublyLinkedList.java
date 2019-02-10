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
    } else if (head == tail) { // case 2: only one element
      if (head.value == value) {
        head = tail = null;
        return true;
      } else {
        return false;
      }
    } else {
      Node previousNode = head;
      Node currentNode = head.next;

      while (currentNode != null) {
        if (currentNode.value == value) {
          if (currentNode == tail) { // case 3: the item is the last element in the list
            removeEnd();
          } else { // case 4: it's an element after the head and before the tail
            previousNode.next = currentNode.next;
            currentNode.next.previous = previousNode;
          }
          return true;
        }
        previousNode = currentNode;
        currentNode = currentNode.next;
      }
      return false;
    }
  }

  // O(N)
  boolean find(int value) {
    if (head == null) { // case 1: empty list
      throw new RuntimeException("The list is empty");
    } else {
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
}
