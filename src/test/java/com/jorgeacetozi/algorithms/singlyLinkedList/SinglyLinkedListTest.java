package com.jorgeacetozi.algorithms.singlyLinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SinglyLinkedListTest {

  SinglyLinkedList linkedList = new SinglyLinkedList();

  @Test
  public void shouldInsertAtStartWithEmptyList() {
    linkedList.insertStart(10);
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.next);
  }

  @Test
  public void shouldInsertAtStartWithNotEmptyList() {
    linkedList.insertStart(10);
    linkedList.insertStart(11);
    assertThat(linkedList.head.value, equalTo(11));
    assertThat(linkedList.head.next.value, equalTo(10));
    assertNull(linkedList.head.next.next);
  }

  @Test
  public void shouldInsertAtEndWithEmptyList() {
    linkedList.insertEnd(10);
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.next);
  }

  @Test
  public void shouldInsertAtEndWithNotEmptyList() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head.next.value, equalTo(11));
    assertNull(linkedList.head.next.next);
  }

  @Test(expected = RuntimeException.class)
  public void shouldThrowExceptionWhenRemoveFromStartWithEmptyList() {
    linkedList.removeStart();
  }

  @Test
  public void shouldRemoveFromStartWithOneNode() {
    linkedList.insertStart(10);
    linkedList.removeStart();
    assertNull(linkedList.head);
  }

  @Test
  public void shouldRemoveFromStartWithTwoOrMoreNodes() {
    linkedList.insertStart(10);
    linkedList.insertStart(11);
    linkedList.insertStart(12);
    linkedList.removeStart();

    assertThat(linkedList.head.value, equalTo(11));
    assertThat(linkedList.head.next.value, equalTo(10));
  }

  @Test(expected = RuntimeException.class)
  public void shouldThrowExceptionWhenRemoveFromEndWithEmptyList() {
    linkedList.removeEnd();
  }

  @Test
  public void shouldRemoveFromEndWithOneNode() {
    linkedList.insertEnd(10);
    linkedList.removeEnd();
    assertNull(linkedList.head);
  }

  @Test
  public void shouldRemoveFromEndWithTwoOrMoreNodes() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.removeEnd();
    assertThat(linkedList.head.value, equalTo(10));
    assertNull(linkedList.head.next);
  }

  @Test(expected = RuntimeException.class)
  public void shouldThrowExceptionWhenRemoveGivenItemByValueWithEmptyList() {
    linkedList.removeItem(10);
  }

  @Test
  public void shouldRemoveGivenItemByValueWithOneNode() {
    linkedList.insertEnd(10);

    boolean isRemoved = linkedList.removeItem(10);

    assertTrue(isRemoved);
    assertNull(linkedList.head);
  }

  @Test
  public void shouldRemoveGivenItemByValueWithTwoOrMoreNodesButNotTheLastOne() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);

    boolean isRemoved = linkedList.removeItem(11);

    assertTrue(isRemoved);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head.next.value, equalTo(12));
    assertNull(linkedList.head.next.next);
  }

  @Test
  public void shouldRemoveGivenItemByValueWithTwoOrMoreNodesAndItsTheFirstOne() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);

    boolean isRemoved = linkedList.removeItem(10);

    assertTrue(isRemoved);
    assertThat(linkedList.head.value, equalTo(11));
    assertThat(linkedList.head.next.value, equalTo(12));
    assertNull(linkedList.head.next.next);
  }

  @Test
  public void shouldRemoveGivenItemByValueWithTwoOrMoreNodesAndItsTheLastOne() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);

    boolean isRemoved = linkedList.removeItem(12);

    assertTrue(isRemoved);
    assertThat(linkedList.head.value, equalTo(10));
    assertThat(linkedList.head.next.value, equalTo(11));
    assertNull(linkedList.head.next.next);
  }

  @Test
  public void shouldNotRemoveGivenItemByValueWhenItsNotInTheList() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    assertFalse(linkedList.removeItem(13));
  }

  @Test
  public void shouldFindItem() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    assertTrue(linkedList.find(11));
  }

  @Test
  public void shouldNotFindItem() {
    linkedList.insertEnd(10);
    linkedList.insertEnd(11);
    linkedList.insertEnd(12);
    assertFalse(linkedList.find(15));
  }
}
