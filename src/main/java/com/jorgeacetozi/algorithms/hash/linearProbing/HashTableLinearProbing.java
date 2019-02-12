package com.jorgeacetozi.algorithms.hash.linearProbing;

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
        index++;
        if (table[index] == null) {
          table[index] = new HashItem<K, V>(key, value);
          size++;
          break;
        }
      } while (table[index] != null);
    }
  }

  private int hashFunction(K key) {
    return Math.abs(key.hashCode() % capacity);
  }

}
