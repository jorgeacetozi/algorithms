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
  
  @Test
  public void shouldRemoveFromEnd() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);

    linkedList.removeEnd();
    assertThat(linkedList.head, equalTo(linkedList.tail));
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.next);

    linkedList.removeEnd();
    assertNull(linkedList.head);
    assertNull(linkedList.tail);
  }
  
  @Test
  public void shouldDeleteGivenItem() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    linkedList.removeItem(11);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head.next.value, equalTo(12));
    assertThat(linkedList.tail.value, equalTo(12));
    assertNull(linkedList.head.next.next);
  }

  @Test
  public void shouldDeleteHeadUsingRemoveItem() {
    linkedList.insertEnd(10);
    assertNotNull(linkedList.head);
    assertNotNull(linkedList.tail);
    linkedList.removeItem(10);
    assertNull(linkedList.head);
    assertNull(linkedList.tail);
  }

  @Test
  public void shouldDeleteLastItemUsingRemoveItem() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    linkedList.removeItem(11);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.tail.value, equalTo(12));
    
    linkedList.removeItem(12);
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.next);
    assertThat(linkedList.head, equalTo(linkedList.tail));
    
    linkedList.removeItem(10);
    assertNull(linkedList.head);
    assertNull(linkedList.tail);
  }
}
