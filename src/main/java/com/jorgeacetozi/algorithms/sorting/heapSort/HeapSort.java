package com.jorgeacetozi.algorithms.sorting.heapSort;

import java.util.ArrayList;
import java.util.List;

class HeapSort<T extends Comparable<T>> {

  MinHeap<T> heap;
  int capacity;

  HeapSort(int capacity) {
    heap = new MinHeap<>(capacity);
    this.capacity = capacity;
  }

  List<T> sort(List<T> input) {
    for (T value : input) {
      heap.put(value);
    }

    List<T> sortedList = new ArrayList<>(capacity);
    while (heap.size > 0) {
      sortedList.add(heap.remove());
    }
    return sortedList;
  }
}
