package com.jorgeacetozi.algorithms.cache.leastRecentlyUsed;

import java.util.List;
import java.util.Optional;
import com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.doublyLinkedList.DoublyLinkedList;
import com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.doublyLinkedList.Node;
import com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.hashTable.HashTable;

class LRUCache<K, V> {

  private HashTable<K, Node<K, V>> hashTable;
  private DoublyLinkedList<K, V> doublyLinkedList;
  private int capacity;

  public LRUCache(int capacity) {
    hashTable = new HashTable<>(capacity);
    doublyLinkedList = new DoublyLinkedList<>();
    this.capacity = capacity;
  }

  public Optional<V> get(K key) {
    Optional<Node<K, V>> optionalNode = hashTable.get(key);

    if (optionalNode.isPresent()) {
      Node<K, V> node = optionalNode.get();
      updateRecentlyUsed(node);
      return Optional.of(node.getValue());
    } else {
      return Optional.empty();
    }
  }

  public void put(K key, V value) {
    Optional<Node<K, V>> nodeOptional = hashTable.get(key);

    if (!nodeOptional.isPresent()) {
      if (isFull()) {
        evict();
      }
      insert(key, value);
    } else {
      Node<K, V> node = nodeOptional.get();
      node.setValue(value);
      updateRecentlyUsed(node);
    }
  }

  public List<K> getLRUKeys() {
    return doublyLinkedList.getKeys();
  }

  public void print() {
    doublyLinkedList.print();
  }

  public int getSize() {
    return hashTable.getSize();
  }

  public boolean isFull() {
    return this.capacity == hashTable.getSize();
  }

  public K getNextKeyToBeEvicted() {
    return doublyLinkedList.getTailKey();
  }

  private void evict() {
    Node<K, V> tail = doublyLinkedList.removeEnd();
    hashTable.remove(tail.getKey());
  }

  private void insert(K key, V value) {
    Node<K, V> newNode = new Node<>(key, value);
    doublyLinkedList.insertStart(newNode);
    hashTable.put(key, newNode);
  }

  private void updateRecentlyUsed(Node<K, V> node) {
    doublyLinkedList.remove(node);
    doublyLinkedList.insertStart(node);
  }
}
