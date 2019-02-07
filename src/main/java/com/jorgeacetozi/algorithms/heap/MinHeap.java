package com.jorgeacetozi.algorithms.heap;

import java.util.Arrays;

class MinHeap {

  int heap[];
  int heapSize;

  MinHeap() {
    this.heap = new int[10];
    Arrays.fill(this.heap, -1);
    this.heapSize = 0;
  }

  void insert(int value) {
    heap[heapSize++] = value;
    heapifyUp(heapSize - 1);
  }

  private void heapifyUp(int currentNodeIndex) {
    if (currentNodeIndex == 0) { // we reached to the root node
      return;
    }

    int parentIndex = (currentNodeIndex - 1) / 2;

    if (heap[parentIndex] > heap[currentNodeIndex]) {
      int temp = heap[parentIndex];
      heap[parentIndex] = heap[currentNodeIndex];
      heap[currentNodeIndex] = temp;
      heapifyUp(parentIndex);
    }
  }

  int remove() {
    int rootElement = heap[0];

    heap[0] = heap[heapSize - 1];
    heap[heapSize - 1] = -1;
    heapSize--;

    heapifyDown(0);
    return rootElement;
  }

  private void heapifyDown(int currentNodeIndex) {
    int leftChildIndex = 2 * currentNodeIndex + 1;
    int rightChildIndex = 2 * currentNodeIndex + 2;

    boolean hasLeftChild = leftChildIndex < heapSize;
    boolean hasRightChild = rightChildIndex < heapSize;

    if (!hasLeftChild && !hasRightChild) { // it's a leaf, so it's a valid heap
      return;
    } else if (hasLeftChild && !hasRightChild) { // there is only the left child
      if (heap[currentNodeIndex] > heap[leftChildIndex]) {
        int temp = heap[currentNodeIndex];
        heap[currentNodeIndex] = heap[leftChildIndex];
        heap[leftChildIndex] = temp;
        heapifyDown(leftChildIndex);
      }
    } else { // the node contains left and right child
      if (heap[leftChildIndex] < heap[rightChildIndex]) {
        int temp = heap[currentNodeIndex];
        heap[currentNodeIndex] = heap[leftChildIndex];
        heap[leftChildIndex] = temp;
        heapifyDown(leftChildIndex);
      } else {
        int temp = heap[currentNodeIndex];
        heap[currentNodeIndex] = heap[rightChildIndex];
        heap[rightChildIndex] = temp;
        heapifyDown(rightChildIndex);
      }
    }
  }
}
