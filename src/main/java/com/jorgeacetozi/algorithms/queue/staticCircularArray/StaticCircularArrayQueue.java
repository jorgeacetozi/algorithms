package com.jorgeacetozi.algorithms.queue.staticCircularArray;

import com.jorgeacetozi.algorithms.queue.Queue;

class StaticCircularArrayQueue<T> implements Queue<T> {
  
  StaticCircularArray<T> circularArray;
  
  public StaticCircularArrayQueue(int capacity) {
    circularArray = new StaticCircularArray<>(capacity);
  }

  @Override
  public void enqueue(T item) {
    circularArray.insertEnd(item);
  }

  @Override
  public T dequeue() {
    return circularArray.removeStart();
  }
}
