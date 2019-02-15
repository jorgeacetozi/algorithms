package com.jorgeacetozi.algorithms.cache.leastRecentlyUsed;

import java.util.List;
import java.util.Optional;
import com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.doublyLinkedList.DoublyLinkedList;
import com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.doublyLinkedList.Node;
import com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.hashTable.HashTable;

class LRUCache<K, V> {

  private HashTable<K, Node<V>> hashTable;
  private DoublyLinkedList<V> doublyLinkedList;
  private int capacity;

  public LRUCache(int capacity) {
    hashTable = new HashTable<>(capacity);
    doublyLinkedList = new DoublyLinkedList<>();
    this.capacity = capacity;
  }

  public Optional<V> get(K key) {
    Optional<Node<V>> optionalNode = hashTable.get(key);

    if (optionalNode.isPresent()) {
      Node<V> node = optionalNode.get();
      updateRecentlyUsed(node);
      return Optional.of(node.getValue());
    } else {
      return Optional.empty();
    }
  }

  public void put(K key, V value) {
    Optional<Node<V>> nodeOptional = hashTable.get(key);

    if (!nodeOptional.isPresent()) {
      if (isCacheFull()) {
        evict(key);
      }
      insert(key, value);
    } else {
      Node<V> node = nodeOptional.get();
      node.setValue(value);
      updateRecentlyUsed(node);
    }
  }

  public List<V> getCurrentOrder() {
    return doublyLinkedList.toList();
  }

  public void print() {
    doublyLinkedList.print();
  }

  public int getSize() {
    return hashTable.getSize();
  }

  private void evict(K key) {
    doublyLinkedList.removeEnd();
    hashTable.remove(key);
  }

  private void insert(K key, V value) {
    Node<V> newNode = new Node<>(value);
    doublyLinkedList.insertStart(newNode);
    hashTable.put(key, newNode);
  }

  private void updateRecentlyUsed(Node<V> node) {
    doublyLinkedList.remove(node);
    doublyLinkedList.insertStart(node);
  }

  private boolean isCacheFull() {
    return this.capacity == hashTable.getSize();
  }

  public V getNextItemToBeEvicted() {
    return doublyLinkedList.getTailValue();
  }
}
