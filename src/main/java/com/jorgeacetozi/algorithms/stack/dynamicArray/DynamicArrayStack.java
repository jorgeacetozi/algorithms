package com.jorgeacetozi.algorithms.stack.dynamicArray;

import java.util.EmptyStackException;
import com.jorgeacetozi.algorithms.stack.Stack;

class DynamicArrayStack<T> implements Stack<T> {

  T[] array;
  int size, capacity;

  @SuppressWarnings("unchecked")
  DynamicArrayStack(int initialCapacity) {
    array = (T[]) new Object[initialCapacity];
    this.capacity = initialCapacity;
  }

  @Override
  public void push(T item) {
    array[size++] = item;
    if (size == capacity) {
      resize();
    }
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    T[] oldArray = array;
    capacity = capacity * 2;
    array = (T[]) new Object[capacity];
    for (int i = 0; i < oldArray.length; i++) {
      array[i] = oldArray[i];
    }
  }

  @Override
  public T pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return array[--size];
  }

  @Override
  public T peek() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return array[size - 1];
  }
}
