package com.jorgeacetozi.algorithms.hash.chaining;

import java.util.Optional;

class HashTableChaining<K, V> {

  HashItem<K, V>[] table;
  int capacity, size;
  double loadFactor;

  @SuppressWarnings("unchecked")
  HashTableChaining(int capacity) {
    table = new HashItem[capacity];
    this.capacity = capacity;
    loadFactor = 0.75;
    size = 0;
  }

  // O(1) because we add to the head of the Singly Linked List
  void put(K key, V value) {
    int index = hashFunction(key);
    HashItem<K, V> newItem = new HashItem<>(key, value);

    if (table[index] == null) {
      table[index] = newItem;
    } else {
      newItem.next = table[index];
      table[index] = newItem;
    }
    size++;

    resize();
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    if ((double) size / capacity > loadFactor) {
      capacity = capacity * 2;
      size = 0;
      HashItem<K, V>[] oldTable = table;
      table = (HashItem<K, V>[]) new HashItem[capacity];

      for (int i = 0; i < oldTable.length; i++) {
        if (oldTable[i] != null) {
          while (oldTable[i] != null) {
            put(oldTable[i].key, oldTable[i].value);
            oldTable[i] = oldTable[i].next;
          }
        }
      }
    }
  }

  // O(N) because we have to iterate over the list and check the key
  Optional<V> get(K key) {
    int index = hashFunction(key);

    if (table[index] == null) {
      return Optional.empty();
    } else {
      HashItem<K, V> currentItem = table[index];

      while (currentItem != null) {
        if (currentItem.key.equals(key)) {
          return Optional.of(currentItem.value);
        }
        currentItem = currentItem.next;
      }
      return Optional.empty();
    }
  }

  private int hashFunction(K key) {
    return Math.abs(key.hashCode() % capacity);
  }
}
