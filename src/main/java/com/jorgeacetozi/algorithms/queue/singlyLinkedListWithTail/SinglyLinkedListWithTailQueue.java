package com.jorgeacetozi.algorithms.queue.singlyLinkedListWithTail;

import com.jorgeacetozi.algorithms.queue.Queue;

class SinglyLinkedListWithTailQueue<T> implements Queue<T> {
  
  SinglyLinkedListWithTail<T> linkedList = new SinglyLinkedListWithTail<>();
  int size;

  @Override
  public void enqueue(T item) {
    linkedList.insertEnd(item);
    size++;
  }

  @Override
  public T dequeue() {
    size--;
    return linkedList.removeStart();
  }
}
