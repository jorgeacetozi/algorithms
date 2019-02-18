package com.jorgeacetozi.algorithms.cache.leastFrequentlyUsed;

import java.util.Optional;
import com.jorgeacetozi.algorithms.cache.leastFrequentlyUsed.minIndexedHeap.MinIndexedHeap;
import com.jorgeacetozi.algorithms.cache.leastFrequentlyUsed.minIndexedHeap.Node;
import com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.hashTable.HashTable;

public class LFUCache<K, V> {

  private HashTable<K, Node<K, V>> hashTable;
  private MinIndexedHeap<K, V> heap;
  private int capacity;

  public LFUCache(int capacity) {
    hashTable = new HashTable<>(capacity);
    heap = new MinIndexedHeap<K, V>(capacity);
    this.capacity = capacity;
  }

  public void put(K key, V value) {
    Optional<Node<K, V>> nodeOptional = hashTable.get(key);

    if (nodeOptional.isPresent()) {
      Node<K, V> node = nodeOptional.get();
      node.setValue(value);
      heap.updateFrequency(node);
    } else {
      if (isFull()) {
        evict();
      }
      insert(key, value);
    }
  }

  public Optional<V> get(K key) {
    Optional<Node<K, V>> nodeOptional = hashTable.get(key);

    if (nodeOptional.isPresent()) {
      Node<K, V> node = nodeOptional.get();
      heap.updateFrequency(node);
      return Optional.of(node.getValue());
    } else {
      return Optional.empty();
    }
  }

  public void printHeap() {
    heap.printHeap();
  }

  public boolean isFull() {
    return this.capacity == hashTable.getSize();
  }

  public K getNextItemToBeEvicted() {
    return heap.getMin();
  }

  private void insert(K key, V value) {
    Node<K, V> newNode = new Node<>(key, value);
    heap.insert(newNode);
    hashTable.put(key, newNode);
  }

  private void evict() {
    Node<K, V> leastFrequentlyUsed = heap.remove();
    hashTable.remove(leastFrequentlyUsed.getKey());
  }
}
