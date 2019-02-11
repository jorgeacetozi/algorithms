package com.jorgeacetozi.algorithms.hash;

class HashTableChaining<K extends Comparable<K>, V> {

  HashItem<K, V>[] table;
  int capacity;
  int size;

  @SuppressWarnings("unchecked")
  HashTableChaining(int capacity) {
    table = (HashItem<K, V>[]) new HashItem[capacity];
    this.capacity = capacity;
  }

  void put(K key, V value) {
    int index = hash(key);
    HashItem<K, V> newItem = new HashItem<>(key, value);

    if (table[index] == null) {
      table[index] = newItem;
    } else {
      newItem.next = table[index];
      table[index] = newItem;
    }
    size++;
  }

  private int hash(K key) {
    return key.hashCode() % capacity;
  }
}
