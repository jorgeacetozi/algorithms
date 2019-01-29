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

  Node delete(int key) {
    return this.deleteRecursive(this.root, key);
  }

  private Node deleteRecursive(Node currentNode, int key) { // FUMA PRO PAPAI FUMA MENINA!!!!!!
    if (key == currentNode.key) {
      // case 1 - no children
      if (currentNode.leftChild == null && currentNode.rightChild == null) {
        return null;
      }
      // case 2 - one child
      if (currentNode.leftChild != null && currentNode.rightChild == null) {
        return currentNode.leftChild;
      }
      if (currentNode.leftChild == null && currentNode.rightChild != null) {
        return currentNode.rightChild;
      }
      // case 3 - two children
      if (currentNode.leftChild != null && currentNode.rightChild != null) {
        Node predecessor = findPredecessor(currentNode);
        int tempKey = currentNode.key;
        Object tempValue = currentNode.value;
        currentNode.key = predecessor.key;
        currentNode.value = predecessor.value;
        predecessor.key = tempKey;
        predecessor.value = tempValue;
        this.deleteRecursive(currentNode.leftChild, tempKey); // Note that this call is on the left
                                                              // subtree!
        return currentNode;
      }
    } else if (key < currentNode.key) {
      currentNode.leftChild = deleteRecursive(currentNode.leftChild, key);
    } else {
      currentNode.rightChild = deleteRecursive(currentNode.rightChild, key);
    }
    return currentNode;
  }

  // The predecessor is the maximum key in the left subtree of the currentNode
  private Node findPredecessor(Node currentNode) {
    return this.findMaxRecursive(currentNode.leftChild);
  }
}
