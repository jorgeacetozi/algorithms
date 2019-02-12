package com.jorgeacetozi.algorithms.hash.linearProbing;

import java.util.Optional;

class HashTableLinearProbing<K extends Comparable<K>, V> {

  HashItem<K, V>[] table;
  int capacity, size;
  double loadFactor;

  @SuppressWarnings("unchecked")
  HashTableLinearProbing(int capacity) {
    table = (HashItem<K, V>[]) new HashItem[capacity];
    this.capacity = capacity;
    loadFactor = 0.75;
  }

  void put(K key, V value) {
    int index = hashFunction(key);
    if (table[index] == null) {
      table[index] = new HashItem<K, V>(key, value);
      size++;
    } else {
      do {
        index = (index + 1) % capacity;
        if (table[index] == null) {
          table[index] = new HashItem<K, V>(key, value);
          size++;
          break;
        }
      } while (table[index] != null);
    }
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
          put(oldTable[i].key, oldTable[i].value);
        }
      }
    }
  }

  Optional<V> get(K key) {
    int index = hashFunction(key);
    if (table[index] == null) {
      return Optional.empty();
    } else {
      while (table[index] != null) {
        if (table[index].key.equals(key)) {
          return Optional.of(table[index].value);
        } else {
          index = (index + 1) % capacity;
        }
      }
    }
    return Optional.empty();
  }

  private int hashFunction(K key) {
    return Math.abs(key.hashCode() % capacity);
  }

}
