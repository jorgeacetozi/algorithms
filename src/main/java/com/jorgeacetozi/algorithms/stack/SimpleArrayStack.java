package com.jorgeacetozi.algorithms.stack;

class SimpleArrayStack<T> implements Stack<T> {

  T[] array;
  int size, capacity;

  @SuppressWarnings("unchecked")
  SimpleArrayStack(int capacity) {
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
      throw new RuntimeException("The stack is empty");
    }
    return array[--size];
  }

  @Override
  public T peek() {
    if (size == 0) {
      throw new RuntimeException("The stack is empty");
    }
    return array[size - 1];
  }
}
