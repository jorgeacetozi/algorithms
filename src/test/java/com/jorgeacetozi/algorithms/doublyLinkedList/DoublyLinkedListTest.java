package com.jorgeacetozi.algorithms.doublyLinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import org.junit.Test;

public class DoublyLinkedListTest {

  DoublyLinkedList linkedList = new DoublyLinkedList();

  @Test
  public void shouldInsertAtStartWithEmptyList() {
    linkedList.insertStart(10);
    assertNotNull(linkedList.head);
    assertNotNull(linkedList.tail);
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.previous);
    assertNull(linkedList.head.next);
    assertThat(linkedList.head, equalTo(linkedList.tail));
  }

  @Test
  public void shouldInsertAtStartWithNotEmptyList() {
    linkedList.insertStart(10);
    linkedList.insertStart(11);
    linkedList.insertStart(12);
    assertThat(linkedList.head.value, equalTo(12));
    assertNull(linkedList.head.previous);

    assertThat(linkedList.head.next.value, equalTo(11));
    assertThat(linkedList.head.next.previous, equalTo(linkedList.head));
    assertThat(linkedList.head.next.next, equalTo(linkedList.tail));

    assertThat(linkedList.tail.value, equalTo(10));
    assertThat(linkedList.tail.previous.value, equalTo(11));
    assertNull(linkedList.tail.next);
  }

  @Test
  public void shouldInsertAtEndWithEmptyList() {
    linkedList.insertEnd(10);
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.previous);
    assertNull(linkedList.head.next);
    assertThat(linkedList.head, equalTo(linkedList.tail));
  }

  @Test
  public void shouldInsertAtEndWithNotEmptyList() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.previous);

    assertThat(linkedList.head.next.value, equalTo(11));
    assertThat(linkedList.head.next.previous, equalTo(linkedList.head));
    assertThat(linkedList.head.next.next, equalTo(linkedList.tail));

    assertThat(linkedList.tail.value, equalTo(12));
    assertThat(linkedList.tail.previous.value, equalTo(11));
    assertNull(linkedList.tail.next);
  }

  @Test(expected = RuntimeException.class)
  public void shouldRemoveFromStartWithEmptyList() {
    linkedList.removeStart();
  }

  @Test
  public void shouldRemoveFromStartWithOneNode() {
    linkedList.insertStart(10);
    linkedList.removeStart();
    assertNull(linkedList.head);
    assertNull(linkedList.tail);
  }

  @Test
  public void shouldRemoveFromWithTwoOrMoreNodes() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    linkedList.removeStart();

    assertThat(linkedList.head.value, equalTo(11));
    assertNull(linkedList.head.previous);
    assertThat(linkedList.head.next, equalTo(linkedList.tail));

    linkedList.removeStart();
    assertThat(linkedList.head, equalTo(linkedList.tail));
  }

  @Test(expected = RuntimeException.class)
  public void shouldRemoveFromEndWithEmptyList() {
    linkedList.removeEnd();
  }

  @Test
  public void shouldRemoveFromEndWithOneNode() {
    linkedList.insertStart(10);
    linkedList.removeEnd();
    assertNull(linkedList.head);
    assertNull(linkedList.tail);
  }

  @Test
  public void shouldRemoveFromEndWithTwoOrMoreNodes() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    linkedList.removeEnd();

    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.previous);
    assertThat(linkedList.head.next, equalTo(linkedList.tail));
    assertThat(linkedList.tail.value, equalTo(11));
    assertThat(linkedList.tail.previous, equalTo(linkedList.head));
    assertNull(linkedList.tail.next);

    linkedList.removeEnd();

    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head, equalTo(linkedList.tail));
  }

  @Test
  public void shouldRemoveGivenNodeByReferenceWithEmptyList() {

  }

  @Test
  public void shouldRemoveGivenNodeByReferenceWithOneNode() {

  }

  @Test
  public void shouldRemoveGivenNodeByReferenceWithTwoOrMoreNodesButNotTheLastOne() {

  }

  @Test
  public void shouldRemoveGivenNodeByReferenceWithTwoOrMoreNodesTheLastOne() {

  }

  @Test
  public void shouldFindItem() {

  }
}
