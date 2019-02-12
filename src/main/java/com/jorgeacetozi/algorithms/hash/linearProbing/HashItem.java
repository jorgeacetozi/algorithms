package com.jorgeacetozi.algorithms.hash.linearProbing;

class HashItem<K, V> {

  K key;
  V value;

  HashItem(K key, V value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("%s -> %s", this.key, this.value);
  }
}
