package com.jorgeacetozi.algorithms.cache.leastFrequentlyUsed.heap;

import java.util.Stack;

public class MinHeap<K, V> {

  private Node<K, V>[] heap;
  private int size;

  @SuppressWarnings("unchecked")
  public MinHeap(int capacity) {
    heap = new Node[capacity];
  }

  public void insert(Node<K, V> newNode) {
    heap[size++] = newNode;
    heapifyUp(size - 1);
  }

  private void heapifyUp(int currentNodeIndex) {
    if (currentNodeIndex != 0) { // we haven't reached to the root
      int parentIndex = (currentNodeIndex - 1) / 2;

      if (heap[parentIndex].compareTo(heap[currentNodeIndex]) > 0) {
        Node<K, V> temp = heap[parentIndex];
        heap[parentIndex] = heap[currentNodeIndex];
        heap[currentNodeIndex] = temp;
        heapifyUp(parentIndex);
      }
    }
  }

  public void updateFrequency(Node<K, V> node) {
    node.setFrequency(node.getFrequency() + 1);
    for (int i = 0; i < size; i++) {
      if (heap[i] == node) {
        heapifyDown(i);
        break;
      }
    }
  }

  public Node<K, V> remove() {
    Node<K, V> leastFrequentlyUsed = heap[0];
    heap[0] = heap[--size];
    heapifyDown(0);
    return leastFrequentlyUsed;
  }

  private void heapifyDown(int currentNodeIndex) {
    int leftChildIndex = 2 * currentNodeIndex + 1;
    int rightChildIndex = 2 * currentNodeIndex + 2;

    boolean hasLeftChild = leftChildIndex < size;
    boolean hasRightChild = rightChildIndex < size;

    if (!hasLeftChild && !hasRightChild) {
      return;
    }
    if (hasLeftChild && !hasRightChild) {
      if (heap[currentNodeIndex].compareTo(heap[leftChildIndex]) > 0) {
        swap(currentNodeIndex, leftChildIndex);
      }
    } else {
      if (heap[leftChildIndex].compareTo(heap[rightChildIndex]) < 0) {
        if (heap[currentNodeIndex].compareTo(heap[leftChildIndex]) > 0) {
          swap(currentNodeIndex, leftChildIndex);
        }
      } else {
        if (heap[currentNodeIndex].compareTo(heap[rightChildIndex]) > 0) {
          swap(currentNodeIndex, rightChildIndex);
        }
      }
    }
  }

  private void swap(int currentNodeIndex, int leftChildIndex) {
    Node<K, V> temp = heap[leftChildIndex];
    heap[leftChildIndex] = heap[currentNodeIndex];
    heap[currentNodeIndex] = temp;
    heapifyDown(leftChildIndex);
  }

  public void print() {
    for (int i = 0; i < heap.length; i++) {
      if (heap[i] != null) {
        System.out.print(heap[i] + " | ");
      }
    }
    System.out.println();
  }

  public K getMin() {
    return heap[0].getKey();
  }
}
