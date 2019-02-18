package com.jorgeacetozi.algorithms.cache.leastFrequentlyUsed.minIndexedHeap;

public class Node<K, V> implements Comparable<Node<K, V>> {

  private K key;
  private V value;
  private Integer frequency;

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
    this.frequency = 0;
  }

  @Override
  public int compareTo(Node<K, V> another) {
    return this.frequency.compareTo(another.getFrequency());
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public Integer getFrequency() {
    return frequency;
  }

  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }

  @Override
  public String toString() {
    return String.format("%s %s %d", this.key, this.value, this.frequency);
  }
}
