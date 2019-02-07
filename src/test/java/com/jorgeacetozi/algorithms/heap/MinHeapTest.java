package com.jorgeacetozi.algorithms.heap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class MinHeapTest {

  MinHeap minHeap = new MinHeap();

  @Test
  public void shouldInsertIntoHeap() {
    minHeap.insert(7);
    minHeap.insert(25);
    minHeap.insert(10);
    minHeap.insert(30);
    minHeap.insert(4);

    assertThat(minHeap.heap[0], equalTo(4));
    assertThat(minHeap.heap[1], equalTo(7));
    assertThat(minHeap.heap[2], equalTo(10));
    assertThat(minHeap.heap[3], equalTo(30));
    assertThat(minHeap.heap[4], equalTo(25));
  }

  @Test
  public void shouldRemoveHeapRoot() {
    minHeap.insert(7);
    assertThat(minHeap.remove(), equalTo(7));
    assertThat(minHeap.heapSize, equalTo(0));
    assertThat(minHeap.heap[0], equalTo(-1));
  }

  @Test
  public void shouldRemoveRootWithLeftChildOnly() {
    minHeap.insert(7);
    minHeap.insert(3);
    assertThat(minHeap.remove(), equalTo(3));
    assertThat(minHeap.heapSize, equalTo(1));
    assertThat(minHeap.heap[0], equalTo(7));
  }

  @Test
  public void shouldRemoveRootWithTwoChildrem() {
    minHeap.insert(7);
    minHeap.insert(3);
    minHeap.insert(10);
    assertThat(minHeap.remove(), equalTo(3));
    assertThat(minHeap.heapSize, equalTo(2));
    assertThat(minHeap.heap[0], equalTo(7));
    assertThat(minHeap.heap[1], equalTo(10));
  }

  @Test
  public void shouldRemoveWithLeftChild() {
    minHeap.insert(7);
    minHeap.insert(25);
    minHeap.insert(10);
    minHeap.insert(30);
    minHeap.insert(40);
    minHeap.insert(15);

    assertThat(minHeap.remove(), equalTo(7));
    assertThat(minHeap.heapSize, equalTo(5));
    assertThat(minHeap.heap[0], equalTo(10));
    assertThat(minHeap.heap[1], equalTo(25));
    assertThat(minHeap.heap[2], equalTo(15));
    assertThat(minHeap.heap[3], equalTo(30));
    assertThat(minHeap.heap[4], equalTo(40));
    assertThat(minHeap.heap[5], equalTo(-1));
  }

  @Test
  public void shouldRemoveWithLeftAndRightChildrem() {
    minHeap.insert(7);
    minHeap.insert(25);
    minHeap.insert(10);
    minHeap.insert(30);
    minHeap.insert(40);
    minHeap.insert(15);
    minHeap.insert(12);

    assertThat(minHeap.remove(), equalTo(7));
    assertThat(minHeap.heapSize, equalTo(6));
    assertThat(minHeap.heap[0], equalTo(10));
    assertThat(minHeap.heap[1], equalTo(25));
    assertThat(minHeap.heap[2], equalTo(12));
    assertThat(minHeap.heap[3], equalTo(30));
    assertThat(minHeap.heap[4], equalTo(40));
    assertThat(minHeap.heap[5], equalTo(15));
    assertThat(minHeap.heap[6], equalTo(-1));
  }

  @Test
  public void shouldRemoveWithManyFixDownOperations() {
    minHeap.insert(7);
    minHeap.insert(25);
    minHeap.insert(10);
    minHeap.insert(30);
    minHeap.insert(40);
    minHeap.insert(15);
    minHeap.insert(12);
    minHeap.insert(50);

    assertThat(minHeap.remove(), equalTo(7));
    assertThat(minHeap.heapSize, equalTo(7));
    assertThat(minHeap.heap[0], equalTo(10));
    assertThat(minHeap.heap[1], equalTo(25));
    assertThat(minHeap.heap[2], equalTo(12));
    assertThat(minHeap.heap[3], equalTo(30));
    assertThat(minHeap.heap[4], equalTo(40));
    assertThat(minHeap.heap[5], equalTo(15));
    assertThat(minHeap.heap[6], equalTo(50));
  }
}
