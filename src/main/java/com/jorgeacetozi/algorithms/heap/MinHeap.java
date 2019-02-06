package com.jorgeacetozi.algorithms.heap;

class MinHeap {

  int heap[];
  int heapSize;

  MinHeap() {
    this.heap = new int[10];
    this.heapSize = 0;
  }

  public void insert(int value) {
    heap[heapSize++] = value;
    fixUp(heapSize - 1);
  }

  private void fixUp(int i) {
    int parentIndex = (i - 1) / 2;

    if (parentIndex >= 0 && heap[parentIndex] > heap[i]) {
      int temp = heap[parentIndex];
      heap[parentIndex] = heap[i];
      heap[i] = temp;
      fixUp(parentIndex);
    }
  }
}
