package com.jorgeacetozi.algorithms.heap;

class GenericMinHeap<T extends Comparable<T>> {

  T[] heap;
  int heapSize;

  @SuppressWarnings("unchecked")
  GenericMinHeap() {
    this.heap = (T[]) new Comparable[10];
    this.heapSize = 0;
  }

  void insert(T value) {
    heap[heapSize++] = value;
    heapifyUp(heapSize - 1);
  }

  private void heapifyUp(int currentNodeIndex) {
    if (currentNodeIndex != 0) {
      int parentIndex = (currentNodeIndex - 1) / 2;

      if (heap[parentIndex].compareTo(heap[currentNodeIndex]) > 0) {
        swap(currentNodeIndex, parentIndex);
        heapifyUp(parentIndex);
      }
    }
  }

  private void swap(int currentNodeIndex, int newPosition) {
    T temp = heap[newPosition];
    heap[newPosition] = heap[currentNodeIndex];
    heap[currentNodeIndex] = temp;
  }

  T remove() {
    T rootElement = heap[0];
    heapSize--;
    heap[0] = heap[heapSize];
    heap[heapSize] = null;
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
        swap(currentNodeIndex, leftChildIndex);
        heapifyDown(leftChildIndex);
      }
    } else { // the node contains left and right child
      if (heap[leftChildIndex].compareTo(heap[rightChildIndex]) < 0) {
        swap(currentNodeIndex, leftChildIndex);
        heapifyDown(leftChildIndex);
      } else {
        swap(currentNodeIndex, rightChildIndex);
        heapifyDown(rightChildIndex);
      }
    }
  }

  T get(int i) {
    return heap[i];
  }
}
