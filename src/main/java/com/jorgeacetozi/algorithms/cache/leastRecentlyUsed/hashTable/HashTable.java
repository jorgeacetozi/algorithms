package com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.hashTable;

import java.util.Optional;

public class HashTable<K, V> {

  private HashItem<K, V>[] table;
  private int size, capacity;
  private double loadFactor;

  @SuppressWarnings("unchecked")
  public HashTable(int capacity) {
    table = new HashItem[capacity];
    this.capacity = capacity;
    loadFactor = 0.75;
  }

  public void put(K key, V value) {
    int index = hashFunction(key);

    if (table[index] == null) {
      table[index] = new HashItem<>(key, value);
    } else {
      do {
        index = (index + 1) % capacity;
        if (table[index] == null) {
          table[index] = new HashItem<>(key, value);
          break;
        }
      } while (table[index] != null);
    }
    size++;
    resize();
  }

  public Optional<V> get(K key) {
    int index = hashFunction(key);
    if (table[index] == null) {
      return Optional.empty();
    } else {
      while (table[index] != null) {
        if (table[index].getKey().equals(key)) {
          return Optional.of(table[index].getValue());
        }
        index++;
      }
      return Optional.empty();
    }
  }

  public Optional<V> remove(K key) {
    int index = hashFunction(key);

    if (table[index] == null) {
      return Optional.empty();
    } else {
      while (table[index] != null) {
        if (table[index].getKey().equals(key)) {
          Optional<V> valueOptional = Optional.of(table[index].getValue());
          table[index] = null;
          size--;
          return valueOptional;
        }
      }
      return Optional.empty();
    }
  }

  public int getSize() {
    return this.size;
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    if ((double) size / capacity > loadFactor) {
      capacity = capacity * 2;
      size = 0;
      HashItem<K, V>[] oldTable = table;
      table = new HashItem[capacity];
      for (int i = 0; i < oldTable.length; i++) {
        if (oldTable[i] != null) {
          put(oldTable[i].getKey(), oldTable[i].getValue());
        }
      }
    }
  }

  private int hashFunction(K key) {
    return Math.abs(key.hashCode() % capacity);
  }
}
