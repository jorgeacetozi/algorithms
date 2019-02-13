package com.jorgeacetozi.algorithms.heap;

import java.util.Arrays;

class GenericMinHeap<T extends Comparable<T>> {

  T[] heap;
  int heapSize;

  @SuppressWarnings("unchecked")
  GenericMinHeap() {
    this.heap = (T[]) new Comparable[10];
    Arrays.fill(this.heap, -1);
    this.heapSize = 0;
  }

  void insert(T value) {
    heap[heapSize++] = value;
    heapifyUp(heapSize - 1);
  }

  private void heapifyUp(int currentNodeIndex) {
    if (currentNodeIndex == 0) { // we reached to the root node
      return;
    }

    int parentIndex = (currentNodeIndex - 1) / 2;

    if (heap[parentIndex].compareTo(heap[currentNodeIndex]) > 0) {
      T temp = heap[parentIndex];
      heap[parentIndex] = heap[currentNodeIndex];
      heap[currentNodeIndex] = temp;
      heapifyUp(parentIndex);
    }
  }

  T remove() {
    T rootElement = heap[0];

    heap[0] = heap[heapSize - 1];
    heap[heapSize - 1] = null;
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
      if (heap[currentNodeIndex].compareTo(heap[leftChildIndex]) > 0) {
        T temp = heap[currentNodeIndex];
        heap[currentNodeIndex] = heap[leftChildIndex];
        heap[leftChildIndex] = temp;
        heapifyDown(leftChildIndex);
      }
    } else { // the node contains left and right child
      if (heap[leftChildIndex].compareTo(heap[rightChildIndex]) < 0) {
        T temp = heap[currentNodeIndex];
        heap[currentNodeIndex] = heap[leftChildIndex];
        heap[leftChildIndex] = temp;
        heapifyDown(leftChildIndex);
      } else {
        T temp = heap[currentNodeIndex];
        heap[currentNodeIndex] = heap[rightChildIndex];
        heap[rightChildIndex] = temp;
        heapifyDown(rightChildIndex);
      }
    }
  }

  T get(int i) {
    return heap[i];
  }
}
