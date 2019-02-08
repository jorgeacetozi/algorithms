package com.jorgeacetozi.algorithms.singlyLinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SinglyLinkedListTest {

  SinglyLinkedList linkedList = new SinglyLinkedList();

  @Test
  public void shouldInsertAtStart() {
    linkedList.insertStart(10);
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.next);

    linkedList.insertStart(11);
    assertThat(linkedList.head.value, equalTo(11));
    assertThat(linkedList.head.next.value, equalTo(10));
    assertNull(linkedList.head.next.next);
  }

  @Test
  public void shouldInsertAtEnd() {
    linkedList.insertEnd(10);
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.next);

    linkedList.insertEnd(11);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head.next.value, equalTo(11));
    assertNull(linkedList.head.next.next);
  }

  @Test
  public void shouldDeleteGivenElement() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    linkedList.removeItem(11);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head.next.value, equalTo(12));
    assertNull(linkedList.head.next.next);
  }

  @Test
  public void shouldDeleteHeadUsingRemoveItem() {
    linkedList.insertEnd(10);
    linkedList.removeItem(10);
    assertNull(linkedList.head);
  }

  @Test
  public void shouldDeleteLastItemUsingRemoveItem() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    linkedList.removeItem(11);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head.next.value, equalTo(12));
    
    linkedList.removeItem(12);
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.next);
    
    linkedList.removeItem(10);
    assertNull(linkedList.head);
  }

  @Test
  public void shouldDeleteHeadUsingRemoveEnd() {
    linkedList.insertEnd(10);
    linkedList.removeEnd();
    assertNull(linkedList.head);
  }

  @Test
  public void shouldDeleteItemUsingRemoveEnd() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.removeEnd();
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.next);
  }

  @Test
  public void shouldDeleteHeadUsingRemoveStart() {
    linkedList.insertEnd(10);
    linkedList.removeStart();
    assertNull(linkedList.head);
  }

  @Test
  public void shouldDeleteItemUsingRemoveStart() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.removeStart();
    assertThat(linkedList.head.value, equalTo(11));
    assertNull(linkedList.head.next);
  }

  @Test
  public void shouldNotFindItem() {
    assertNull(linkedList.find(10));
  }

  @Test
  public void shouldFindHeadItem() {
    linkedList.insertEnd(10);
    assertThat(linkedList.find(10).value, equalTo(10));
  }

  @Test
  public void shouldFindMiddleItem() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    assertThat(linkedList.find(11).value, equalTo(11));
  }
}
