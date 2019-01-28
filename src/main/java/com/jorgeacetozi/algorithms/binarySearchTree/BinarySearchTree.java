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

  Node find(int key) {
    return this.findRecursive(this.root, key);
  }

  private Node findRecursive(Node currentNode, int key) {
    if (currentNode == null) {
      return null;
    }
    if (currentNode.key == key) {
      return currentNode;
    } else if (key < currentNode.key) {
      return findRecursive(currentNode.leftChild, key);
    } else {
      return findRecursive(currentNode.rightChild, key);
    }
  }

  Node findMin() {
    return this.findMinRecursive(this.root);
  }

  private Node findMinRecursive(Node currentNode) {
    if (currentNode.leftChild == null) {
      return currentNode;
    }
    return findMinRecursive(currentNode.leftChild);
  }

  Node findMax() {
    return this.findMaxRecursive(this.root);
  }

  private Node findMaxRecursive(Node currentNode) {
    if (currentNode.rightChild == null) {
      return currentNode;
    }
    return findMaxRecursive(currentNode.rightChild);
  }
}
