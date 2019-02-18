package com.jorgeacetozi.algorithms.queue;

public interface Queue<T> {

  void enqueue(T item);

  T dequeue();

}
