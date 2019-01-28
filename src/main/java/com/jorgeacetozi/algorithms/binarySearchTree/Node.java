package com.jorgeacetozi.algorithms.binarySearchTree;

class Node {
  int key;
  Object value;
  Node leftChild;
  Node rightChild;

  Node(int key, Object value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("Key: %d | Value: %s", this.key, this.value);
  }
}
