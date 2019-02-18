package com.jorgeacetozi.algorithms.stack.staticArray;

import java.util.EmptyStackException;
import com.jorgeacetozi.algorithms.stack.Stack;

class StaticArrayStack<T> implements Stack<T> {

  T[] array;
  int size, capacity;

  @SuppressWarnings("unchecked")
  StaticArrayStack(int capacity) {
    array = (T[]) new Object[capacity];
    this.capacity = capacity;
  }

  @Override
  public void push(T item) {
    if (size == capacity) {
      throw new RuntimeException("The stack is full");
    }
    array[size++] = item;
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
