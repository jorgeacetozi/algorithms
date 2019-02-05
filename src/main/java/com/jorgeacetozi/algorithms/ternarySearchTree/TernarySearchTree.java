package com.jorgeacetozi.algorithms.ternarySearchTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TernarySearchTree {

  Node root;
  List<Node> partials;
  String longestCommonPrefix;

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

  String longestCommonPrefix(List<String> strings) {
    for (String s : strings) {
      this.put(s, s);
    }
    String longest = findLongestCommonPrefix(this.root, 0, "");
    if (longest != null) {
      return longest;
    } else {
      // If there is no left or right child, we just return the smaller string in the list
      // This covers the case of 'jor', 'jorge' and 'jorgetest'
      return strings.stream().min(Comparator.naturalOrder()).get();
    }
  }

  String findLongestCommonPrefix(Node currentNode, int i, String tempPrefix) {
    if (currentNode == null) {
      return this.longestCommonPrefix;
    }

    // If the currentNode has a left or right child, that means concatenation of the characters from
    // the root to its parent node is the longest common prefix
    if (currentNode.leftChild != null || currentNode.rightChild != null) {
      this.longestCommonPrefix = tempPrefix;
      return this.longestCommonPrefix;
    } else {
      return findLongestCommonPrefix(currentNode.middleChild, ++i,
          tempPrefix + currentNode.character);
    }
  }
}
