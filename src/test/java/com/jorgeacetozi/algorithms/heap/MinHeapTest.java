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
}
