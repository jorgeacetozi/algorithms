package com.jorgeacetozi.algorithms.queue.singlyLinkedListWithTail;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SinglyLinkedListWithTailQueueTest {

  SinglyLinkedListWithTailQueue<String> queue = new SinglyLinkedListWithTailQueue<>();

  @Test
  public void shouldEnqueueItems() {
    queue.enqueue("jorge");
    queue.enqueue("cobra");
    queue.enqueue("xuxa");

    String item1 = queue.dequeue();
    assertThat(item1, equalTo("jorge"));

    String item2 = queue.dequeue();
    assertThat(item2, equalTo("cobra"));

    String item3 = queue.dequeue();
    assertThat(item3, equalTo("xuxa"));
  }
}
