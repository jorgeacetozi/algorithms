package com.jorgeacetozi.algorithms.singlyLinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import org.junit.Test;

public class SinglyLinkedListWithTailTest {

  SinglyLinkedListWithTail linkedList = new SinglyLinkedListWithTail();

  @Test
  public void shouldInsertAtStart() {
    linkedList.insertStart(10);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head, equalTo(linkedList.tail));

    linkedList.insertStart(11);
    assertThat(linkedList.head.value, equalTo(11));
    assertThat(linkedList.head.next, equalTo(linkedList.tail));
    assertThat(linkedList.tail.value, equalTo(10));
    assertNull(linkedList.tail.next);
    assertNotEquals(linkedList.head, linkedList.tail);
  }

  @Test
  public void shouldInsertAtEnd() {
    linkedList.insertEnd(10);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head, equalTo(linkedList.tail));

    linkedList.insertEnd(11);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head.next, equalTo(linkedList.tail));
    assertThat(linkedList.tail.value, equalTo(11));
    assertNull(linkedList.tail.next);
    assertNotEquals(linkedList.head, linkedList.tail);
  }

  @Test
  public void shouldRemoveFromStart() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    
    linkedList.removeStart();
    assertThat(linkedList.head, equalTo(linkedList.tail));
    assertThat(linkedList.head.value, equalTo(11));
    assertNull(linkedList.head.next);
    
    linkedList.removeStart();
    assertNull(linkedList.head);
    assertNull(linkedList.tail);
  }
}
