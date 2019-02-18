package com.jorgeacetozi.algorithms.stack.singlyLinkedList;

import com.jorgeacetozi.algorithms.stack.Stack;

class SinglyLinkedListStack<T> implements Stack<T> {

  SinglyLinkedList<T> linkedList = new SinglyLinkedList<>();
  int size;

  @Override
  public void push(T item) {
    linkedList.insertStart(item);
    size++;
  }

  @Override
  public T pop() {
    size--;
    return linkedList.removeStart();
  }

  @Override
  public T peek() {
    return linkedList.getNextItemToBeRemovedFromStart();
  }
}
