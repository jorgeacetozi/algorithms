package com.jorgeacetozi.algorithms.hash;

class HashItem<K, V> {

  K key;
  V value;
  HashItem<K, V> next;

  HashItem(K key, V value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString() {
    return this.key.toString();
  }
}
