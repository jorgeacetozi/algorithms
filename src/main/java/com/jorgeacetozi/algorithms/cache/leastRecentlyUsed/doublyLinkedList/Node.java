package com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.doublyLinkedList;

public class Node<V> {

  private Node<V> previous, next;
  private V value;

  public Node(V value) {
    this.value = value;
  }

  public V getValue() {
    return value;
  }

  public Node<V> getPrevious() {
    return previous;
  }

  public void setPrevious(Node<V> previous) {
    this.previous = previous;
  }

  public void setNext(Node<V> next) {
    this.next = next;
  }

  public Node<V> getNext() {
    return this.next;
  }

  @Override
  public String toString() {
    return value.toString();
  }

  public void setValue(V value) {
    this.value = value;
  }
}
