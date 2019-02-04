package com.jorgeacetozi.algorithms.ternarySearchTree;

class Node {
  char character;
  Object value;
  Node leftChild, middleChild, rightChild;

  Node(char character) {
    this.character = character;
  }

  @Override
  public String toString() {
    return String.valueOf(this.character);
  }
}
