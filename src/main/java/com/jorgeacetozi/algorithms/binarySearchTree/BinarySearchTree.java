package com.jorgeacetozi.algorithms.binarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class BinarySearchTree {

  Node root;

  void insert(int key, String value) {
    this.root = insertRecursive(this.root, key, value);
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

  Optional<Node> find(int key) {
    return findRecursive(this.root, key);
  }

  private Optional<Node> findRecursive(Node currentNode, int key) {
    if (currentNode == null) {
      return Optional.empty();
    }
    if (key < currentNode.key) {
      return findRecursive(currentNode.leftChild, key);
    } else if (key > currentNode.key) {
      return findRecursive(currentNode.rightChild, key);
    } else { // item found!
      return Optional.of(currentNode);
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

  void delete(int key) {
    if (root == null) {
      throw new RuntimeException("BST is empty");
    } else {
      root = this.deleteRecursive(this.root, key);
    }
  }

  private Node deleteRecursive(Node currentNode, int key) {
    if (currentNode == null) {
      return null;
    }

    if (key < currentNode.key) {
      currentNode.leftChild = deleteRecursive(currentNode.leftChild, key);
    } else if (key > currentNode.key) {
      currentNode.rightChild = deleteRecursive(currentNode.rightChild, key);
    } else { // we found the item to be deleted
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
    }
    return currentNode;
  }

  // The predecessor is the maximum key in the left subtree of the currentNode
  private Node findPredecessor(Node currentNode) {
    return this.findMaxRecursive(currentNode.leftChild);
  }

  int getHeight() {
    return getHeight(root);
  }

  private int getHeight(Node currentNode) {
    if (currentNode == null) {
      return 0;
    }
    int height = 0;
    height++;

    int leftSubtreeHeight = height + getHeight(currentNode.leftChild);
    int rightSubtreeHeight = height + getHeight(currentNode.rightChild);

    return Math.max(leftSubtreeHeight, rightSubtreeHeight);
  }

  public int getSum() {
    return getSum(root);
  }

  private int getSum(Node currentNode) {
    if (currentNode == null) {
      return 0;
    }
    return currentNode.key + getSum(currentNode.leftChild) + getSum(currentNode.rightChild);
  }

  public List<Node> inorderTraversal() {
    return inorderTraversal(root);
  }

  private List<Node> inorderTraversal(Node currentNode) {
    List<Node> list = new ArrayList<>();
    if (currentNode == null) {
      return list;
    }
    list.addAll(inorderTraversal(currentNode.leftChild));
    list.add(currentNode);
    list.addAll(inorderTraversal(currentNode.rightChild));
    return list;
  }

  public List<Node> preorderTraversal() {
    return preorderTraversal(root);
  }

  private List<Node> preorderTraversal(Node currentNode) {
    List<Node> list = new ArrayList<>();
    if (currentNode == null) {
      return list;
    }
    list.add(currentNode);
    list.addAll(preorderTraversal(currentNode.leftChild));
    list.addAll(preorderTraversal(currentNode.rightChild));
    return list;
  }

  public List<Node> postorderTraversal() {
    return postorderTraversal(root);
  }

  private List<Node> postorderTraversal(Node currentNode) {
    List<Node> list = new ArrayList<>();
    if (currentNode == null) {
      return list;
    }
    list.addAll(postorderTraversal(currentNode.leftChild));
    list.addAll(postorderTraversal(currentNode.rightChild));
    list.add(currentNode);
    return list;
  }
}
