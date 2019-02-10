package com.jorgeacetozi.algorithms.doublyLinkedList;

class Node {
  Node previous, next;
  int value;

  Node(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}
