package com.jorgeacetozi.algorithms.queue.staticCircularArray;

import java.util.Optional;

class StaticCircularArray<T> {
 
  T[] array;
  int start, end;
  int size, capacity;

  @SuppressWarnings("unchecked")
  StaticCircularArray(int capacity) {
    array = (T[]) new Object[capacity];
    this.capacity = capacity;
  }

  // O(1). Note that insertStart would also be O(1)
  void insertEnd(T item) {
    if (size == capacity) {
      throw new RuntimeException("The array is full");
    }
    array[end] = item;
    end = (end + 1) % capacity;
    size++;
  }

  // O(1). Note that insertStart would also be O(1)
  T removeStart() {
    if (size == 0) {
      throw new RuntimeException("The array is empty");
    }
    T temp = array[start];
    array[start] = null;
    start = (start + 1) % capacity;
    size--;
    return temp;
  }

  Optional<T> get(int i) {
    if (array[i] == null) {
      return Optional.empty();
    } else {
      return Optional.of(array[i]);
    }
  }
}
