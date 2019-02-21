package com.jorgeacetozi.algorithms.sorting.heapsort;

import java.util.List;

class Heapsort {

  <T extends Comparable<T>> void heapsort(List<T> list) {
    MinHeap<T> heap = new MinHeap<>(list.size());

    for (T value : list) {
      heap.put(value);
    }

    list.clear();
    while (heap.size > 0) {
      list.add(heap.remove());
    }
  }
}
