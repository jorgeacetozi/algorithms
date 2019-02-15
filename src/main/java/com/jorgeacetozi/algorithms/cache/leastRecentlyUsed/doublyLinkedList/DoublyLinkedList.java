package com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.doublyLinkedList;

public class DoublyLinkedList<V> {

  private Node<V> head, tail;
  private int size;

  public void insertStart(Node<V> node) {
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

  public void remove(Node<V> node) {
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
      Node<V> previous = node.getPrevious();
      Node<V> next = node.getNext();
      previous.setNext(next);
      next.setPrevious(previous);
    }
    size--;
  }

  public void removeEnd() {
    if (head == null) {
      throw new IllegalStateException("The list is empty");
    } else if (head == tail) {
      head = tail = null;
    } else {
      tail = tail.getPrevious();
      tail.setNext(null);
    }
    size--;
  }

  public int getSize() {
    return this.size;
  }

  public void print() {
    Node<V> currentNode = head;
    while (currentNode != null) {
      System.out.print(currentNode + " ");
      currentNode = currentNode.getNext();
    }
    System.out.println();
  }
}
