package com.jorgeacetozi.algorithms.cache.leastRecentlyUsed.hashTable;

class HashItem<K, V> {
  
  private K key;
  private V value;
  
  HashItem(K key, V value) {
    this.key = key;
    this.value = value;
  }
  
  @Override
  public String toString() {
    return String.format("%s: %s", key, value);
  }

  K getKey() {
    return key;
  }

  V getValue() {
    return value;
  }
}
