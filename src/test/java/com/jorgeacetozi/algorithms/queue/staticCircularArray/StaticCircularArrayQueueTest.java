package com.jorgeacetozi.algorithms.queue.staticCircularArray;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import org.junit.Test;

public class StaticCircularArrayQueueTest {

  StaticCircularArrayQueue<String> queue = new StaticCircularArrayQueue<>(3);

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
    
    queue.enqueue("navalha");
    assertTrue(queue.circularArray.get(0).isPresent());
    assertThat(queue.circularArray.get(0).get(), equalTo("navalha"));
  }
}
