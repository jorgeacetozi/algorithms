package com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.doublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList<K, V> {

  private Node<K, V> head, tail;
  private int size;

  public void insertStart(Node<K, V> node) {
    if (head == null) {
      head = tail = node;
    } else {
      head.setPrevious(node);
      node.setNext(head);
      node.setPrevious(null);
      head = node;
    }
    size++;
  }

  public void remove(Node<K, V> node) {
    if (head == null) { // empty list
      throw new IllegalStateException("The list is empty");
    }
    if (node.getPrevious() == null && node.getNext() == null) { // only one element in the list
      head = tail = null;
    } else if (node.getPrevious() == null) { // two or more elements and the node is the head
      head = head.getNext();
      head.setPrevious(null);
    } else if (node.getNext() == null) { // two or more elements and the node is the tail
      tail = tail.getPrevious();
      tail.setNext(null);
    } else { // two or more elements and the node is neither the head nor the tail
      Node<K, V> previous = node.getPrevious();
      Node<K, V> next = node.getNext();
      previous.setNext(next);
      next.setPrevious(previous);
    }
    size--;
  }

  public Node<K, V> removeEnd() {
    Node<K, V> lastItem = tail;
    if (head == null) {
      throw new IllegalStateException("The list is empty");
    } else if (head == tail) {
      head = tail = null;
    } else {
      tail = tail.getPrevious();
      tail.setNext(null);
    }
    size--;
    return lastItem;
  }

  public int getSize() {
    return this.size;
  }

  public void print() {
    Node<K, V> currentNode = head;
    while (currentNode != null) {
      System.out.print(currentNode + " ");
      currentNode = currentNode.getNext();
    }
    System.out.println();
  }

  public List<K> getKeys() {
    Node<K, V> currentNode = head;
    List<K> keys = new ArrayList<>();
    while (currentNode != null) {
      keys.add(currentNode.getKey());
      currentNode = currentNode.getNext();
    }
    return keys;
  }

  public K getTailKey() {
    if (tail == null) {
      throw new IllegalStateException("The list is empty");
    }
    return tail.getKey();
  }
}
