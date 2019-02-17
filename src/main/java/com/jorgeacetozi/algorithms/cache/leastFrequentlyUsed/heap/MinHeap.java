package com.jorgeacetozi.algorithms.cache.leastFrequentlyUsed.heap;

import java.util.HashMap;
import java.util.Map;

public class MinHeap<K, V> {

  private Node<K, V>[] heap;
  private Map<Node<K, V>, Integer> nodeIndexes;
  private int size;

  @SuppressWarnings("unchecked")
  public MinHeap(int capacity) {
    heap = new Node[capacity];
    nodeIndexes = new HashMap<>();
  }

  public void insert(final Node<K, V> newNode) {
    heap[size] = newNode;
    nodeIndexes.put(newNode, size);
    size++;
    heapifyUp(size - 1);
  }

  private void heapifyUp(int currentNodeIndex) {
    if (currentNodeIndex != 0) { // we haven't reached to the root
      int parentIndex = (currentNodeIndex - 1) / 2;

      if (heap[parentIndex].compareTo(heap[currentNodeIndex]) > 0) {
        swap(currentNodeIndex, parentIndex);
        heapifyUp(parentIndex);
      }
    }
  }

  public void updateFrequency(Node<K, V> node) {
    node.setFrequency(node.getFrequency() + 1);
    Integer nodeIndex = nodeIndexes.get(node);
    heapifyDown(nodeIndex);
  }

  public Node<K, V> remove() {
    Node<K, V> leastFrequentlyUsed = heap[0];
    nodeIndexes.remove(leastFrequentlyUsed);
    size--;
    heap[0] = heap[size];
    heap[size] = null;
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
        heapifyDown(leftChildIndex);
      }
    } else {
      if (heap[leftChildIndex].compareTo(heap[rightChildIndex]) < 0) {
        if (heap[currentNodeIndex].compareTo(heap[leftChildIndex]) > 0) {
          swap(currentNodeIndex, leftChildIndex);
          heapifyDown(leftChildIndex);
        }
      } else {
        if (heap[currentNodeIndex].compareTo(heap[rightChildIndex]) > 0) {
          swap(currentNodeIndex, rightChildIndex);
          heapifyDown(rightChildIndex);
        }
      }
    }
  }

  private void swap(int currentPosition, int newPosition) {
    Node<K, V> temp = heap[newPosition];
    heap[newPosition] = heap[currentPosition];
    heap[currentPosition] = temp;
    
    nodeIndexes.put(heap[currentPosition], currentPosition);
    nodeIndexes.put(heap[newPosition], newPosition);
  }

  public void printHeap() {
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
