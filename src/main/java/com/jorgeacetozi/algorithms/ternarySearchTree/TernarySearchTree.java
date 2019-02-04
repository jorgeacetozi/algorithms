package com.jorgeacetozi.algorithms.ternarySearchTree;

import java.util.ArrayList;
import java.util.List;

class TernarySearchTree {

  Node root;
  List<Node> partials;

  void put(String key, Object value) {
    root = putRecursive(this.root, key, value, 0);
  }

  private Node putRecursive(Node currentNode, String key, Object value, int i) {
    // stop condition
    if (i == key.length()) {
      return currentNode;
    }

    char currentCharacterFromKey = key.charAt(i);

    if (currentNode == null) {
      currentNode = new Node(currentCharacterFromKey);
    }

    if (currentCharacterFromKey == currentNode.character) {
      if (key.length() - 1 == i) {
        currentNode.value = value;
      }
      currentNode.middleChild = putRecursive(currentNode.middleChild, key, value, ++i);
    } else if (currentCharacterFromKey < currentNode.character) {
      currentNode.leftChild = putRecursive(currentNode.leftChild, key, value, i);
    } else if (currentCharacterFromKey > currentNode.character) {
      currentNode.rightChild = putRecursive(currentNode.rightChild, key, value, i);
    }
    return currentNode;
  }

  List<Node> findPartials(String prefix) {
    this.partials = new ArrayList<>();
    return autocomplete(this.root, prefix, 0);
  }

  List<Node> autocomplete(Node currentNode, String prefix, int i) {
    if (currentNode == null) {
      return this.partials;
    }

    if (i == prefix.length()) {
      return traverse(currentNode);
    }

    char currentCharacterFromPrefix = prefix.charAt(i);

    if (currentCharacterFromPrefix == currentNode.character) {
      autocomplete(currentNode.middleChild, prefix, ++i);
    } else if (currentCharacterFromPrefix < currentNode.character) {
      autocomplete(currentNode.leftChild, prefix, i);
    } else if (currentCharacterFromPrefix > currentNode.character) {
      autocomplete(currentNode.rightChild, prefix, i);
    }
    return this.partials;
  }

  private List<Node> traverse(Node currentNode) {
    if (currentNode == null) {
      return null;
    }

    traverse(currentNode.leftChild);
    traverse(currentNode.middleChild);
    traverse(currentNode.rightChild);
    if (currentNode.value != null)
      this.partials.add(currentNode);
    return partials;
  }
}
