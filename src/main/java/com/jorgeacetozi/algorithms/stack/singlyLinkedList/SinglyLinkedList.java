package com.jorgeacetozi.algorithms.stack.singlyLinkedList;

import java.util.EmptyStackException;

class SinglyLinkedList<T> {

  Node<T> head;

  void insertStart(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  T removeStart() {
    if (head == null) {
      throw new EmptyStackException();
    } else {
      Node<T> aux = head;
      head = head.next;
      return aux.data;
    }
  }

  T getNextItemToBeRemovedFromStart() {
    if (head == null) {
      throw new EmptyStackException();
    } else {
      return head.data;
    }
  }
}
