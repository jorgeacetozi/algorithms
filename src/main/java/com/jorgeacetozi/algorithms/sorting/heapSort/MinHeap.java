package com.jorgeacetozi.algorithms.sorting.heapSort;

class MinHeap<T extends Comparable<T>> {

  T[] array;
  int size;

  @SuppressWarnings("unchecked")
  MinHeap(int capacity) {
    array = (T[]) new Comparable[capacity];
  }

  void put(T item) {
    if (size == array.length) {
      throw new RuntimeException("The heap is full");
    }
    array[size++] = item;
    heapifyUp(size - 1);
  }

  private void heapifyUp(int i) {
    if (i != 0) {
      int parentIndex = (i - 1) / 2;
      if (array[parentIndex].compareTo(array[i]) > 0) {
        swap(i, parentIndex);
        heapifyUp(parentIndex);
      }
    }
  }

  T remove() {
    if (size == 0) {
      throw new RuntimeException("The heap is empty");
    }
    T temp = array[0];
    array[0] = array[--size];
    array[size] = null;
    heapifyDown(0);
    return temp;
  }

  private void heapifyDown(int i) {
    int leftChildIndex = 2 * i + 1;
    int rightChildIndex = 2 * i + 2;

    boolean hasLeftChild = leftChildIndex < size;
    boolean hasRightChild = rightChildIndex < size;

    if (!hasLeftChild && !hasRightChild) {
      return;
    }
    if (hasLeftChild && !hasRightChild) {
      if (array[i].compareTo(array[leftChildIndex]) > 0) {
        swap(i, leftChildIndex);
        heapifyDown(leftChildIndex);
      }
    } else {
      if (array[leftChildIndex].compareTo(array[rightChildIndex]) < 0) {
        if (array[i].compareTo(array[leftChildIndex]) > 0) {
          swap(i, leftChildIndex);
          heapifyDown(leftChildIndex);
        }
      } else {
        if (array[i].compareTo(array[rightChildIndex]) > 0) {
          swap(i, rightChildIndex);
          heapifyDown(rightChildIndex);
        }
      }
    }
  }

  private void swap(int currentIndex, int targetIndex) {
    T temp = array[targetIndex];
    array[targetIndex] = array[currentIndex];
    array[currentIndex] = temp;
  }
}
