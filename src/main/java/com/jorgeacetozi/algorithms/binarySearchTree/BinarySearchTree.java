package com.jorgeacetozi.algorithms.binarySearchTree;

class BinarySearchTree {

  Node root;

  void insert(int key, String value) {
    if (root == null) {
      this.root = new Node(key, value);
      return;
    } else {
      insertRecursive(this.root, key, value);
    }
  }

  private Node insertRecursive(Node currentNode, int key, String value) {
    if (currentNode == null) {
      return new Node(key, value);
    }
    if (key < currentNode.key) {
      currentNode.leftChild = insertRecursive(currentNode.leftChild, key, value);
    } else if (key > currentNode.key) {
      currentNode.rightChild = insertRecursive(currentNode.rightChild, key, value);
    } else {
      currentNode.value = value;
    }
    return currentNode;
  }

}
