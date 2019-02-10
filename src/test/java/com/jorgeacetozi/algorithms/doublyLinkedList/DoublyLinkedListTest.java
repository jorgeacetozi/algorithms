package com.jorgeacetozi.algorithms.doublyLinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import org.junit.Test;

public class DoublyLinkedListTest {

  DoublyLinkedList linkedList = new DoublyLinkedList();

  @Test
  public void shouldInsertAtStartEmptyList() {
    linkedList.insertStart(10);
    assertNotNull(linkedList.head);
    assertNotNull(linkedList.tail);
    assertThat(linkedList.head, equalTo(linkedList.tail));
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.previous);
    assertNull(linkedList.head.next);
    assertNull(linkedList.tail.previous);
    assertNull(linkedList.tail.next);
  }

  @Test
  public void shouldInsertAtStartNotEmptyList() {
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
  public void shouldInsertAtEnd() {

  }

  @Test
  public void shouldRemoveFromStartWithEmptyList() {

  }

  @Test
  public void shouldRemoveFromStartWithOneNode() {

  }

  @Test
  public void shouldRemoveFromWithTwoOrMoreNodes() {

  }

  @Test
  public void shouldRemoveFromEndWithEmptyList() {

  }

  @Test
  public void shouldRemoveFromEndWithOneNode() {

  }

  @Test
  public void shouldRemoveFromEndWithTwoOrMoreNodes() {

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
