package com.jorgeacetozi.algorithms.queue.singlyLinkedListWithTail;

class SinglyLinkedListWithTail<T> {

  Node<T> head, tail;

  // O(1) because we have the tail reference
  public void insertEnd(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) { // case 1: the list is empty
      head = tail = newNode;
    } else { // case 2: the list is not empty
      tail.next = newNode;
      tail = tail.next;
    }
  }

  // O(1)
  public T removeStart() {
    if (head == null) { // case 1: the list is empty
      throw new RuntimeException("The queue is empty");
    }
    Node<T> aux = head;
    if (head == tail) { // case 2: the list has only one element
      head = tail = null;
    } else { // case 2: the list has two or more elements
      head = head.next;
    }
    return aux.data;
  }
}
