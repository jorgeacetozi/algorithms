package com.jorgeacetozi.algorithms.hash.linearProbing;

import java.util.Optional;

class HashTableLinearProbing<K extends Comparable<K>, V> {

  HashItem<K, V>[] table;
  int capacity, size;

  @SuppressWarnings("unchecked")
  HashTableLinearProbing(int capacity) {
    table = (HashItem<K, V>[]) new HashItem[capacity];
    this.capacity = capacity;
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
