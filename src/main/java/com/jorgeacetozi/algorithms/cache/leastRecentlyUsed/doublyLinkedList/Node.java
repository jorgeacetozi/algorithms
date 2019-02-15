package com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.doublyLinkedList;

public class Node<K, V> {

  private Node<K, V> previous, next;
  private K key;
  private V value;

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public V getValue() {
    return value;
  }
  
  public void setValue(V value) {
    this.value = value;
  }
  
  public K getKey() {
    return key;
  }

  public Node<K, V> getPrevious() {
    return previous;
  }

  public void setPrevious(Node<K, V> previous) {
    this.previous = previous;
  }
  
  public Node<K, V> getNext() {
    return this.next;
  }

  public void setNext(Node<K, V> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
