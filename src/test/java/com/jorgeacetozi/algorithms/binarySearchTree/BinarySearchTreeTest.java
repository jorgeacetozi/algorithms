package com.jorgeacetozi.algorithms.binarySearchTree;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class BinarySearchTreeTest {

  BinarySearchTree bst = new BinarySearchTree();

  @Test
  public void shouldInsertRootNode() {
    bst.insert(10, "Jorge");
    assertNotNull(bst.root);
    assertThat(bst.root.key, is(10));
    assertThat(bst.root.value, is("Jorge"));
  }

  @Test
  public void shouldInsertLeftChildAndRightChild() {
    bst.insert(10, "Jorge");
    assertNull(bst.root.leftChild);
    bst.insert(5, "Xuxa");
    assertNotNull(bst.root.leftChild);
    assertThat(bst.root.leftChild.key, is(5));
    assertThat(bst.root.leftChild.value, is("Xuxa"));

    bst.insert(7, "Cobra");
    assertNotNull(bst.root.leftChild.rightChild);
    assertThat(bst.root.leftChild.rightChild.key, is(7));
    assertThat(bst.root.leftChild.rightChild.value, is("Cobra"));
  }

  @Test
  public void shouldInsertRightChildAndLeftChild() {
    bst.insert(10, "Jorge");
    assertNull(bst.root.rightChild);
    bst.insert(15, "Xuxa");
    assertNotNull(bst.root.rightChild);
    assertThat(bst.root.rightChild.key, is(15));
    assertThat(bst.root.rightChild.value, is("Xuxa"));

    bst.insert(12, "Cobra");
    assertNotNull(bst.root.rightChild.leftChild);
    assertThat(bst.root.rightChild.leftChild.key, is(12));
    assertThat(bst.root.rightChild.leftChild.value, is("Cobra"));
  }

  @Test
  public void shouldUpdateValueWhenInsertingExistingKey() {
    bst.insert(10, "Jorge");
    bst.insert(15, "Xuxa");
    bst.insert(15, "Cobra");
    assertThat(bst.root.rightChild.value, is("Cobra"));
  }

  @Test
  public void shouldFindNodeByKey() {
    bst.insert(10, "Jorge");
    bst.insert(15, "Xuxa");
    bst.insert(12, "Cobra");
    Node cobra = bst.find(12);
    assertThat(cobra.key, is(12));
    assertThat(cobra.value, is("Cobra"));
  }

  @Test
  public void shouldFindMinimumKey() {
    bst.insert(10, "Jorge");
    bst.insert(15, "Xuxa");
    bst.insert(12, "Cobra");
    bst.insert(7, "Hello");
    bst.insert(3, "Minimum");
    Node min = bst.findMin();
    assertThat(min.key, is(3));
    assertThat(min.value, is("Minimum"));
  }

  @Test
  public void shouldFindMaximumKey() {
    bst.insert(10, "Jorge");
    bst.insert(15, "Xuxa");
    bst.insert(12, "Cobra");
    bst.insert(7, "Hello");
    bst.insert(3, "Minimum");
    Node max = bst.findMax();
    assertThat(max.key, is(15));
    assertThat(max.value, is("Xuxa"));
  }

  @Test
  public void shouldDeleteRoot() {
    bst.insert(10, "Jorge");
    bst.delete(10);
    assertNull(bst.root);
  }

  @Test(expected = RuntimeException.class)
  public void shouldThrowExceptionWhenBSTIsEmpty() {
    bst.delete(10);
  }

  @Test
  public void shouldDeleteNodeWithNoChildren() {
    bst.insert(10, "Jorge");
    bst.insert(5, "Xuxa");
    assertNotNull(bst.root.leftChild);
    bst.delete(5);
    assertNull(bst.root.leftChild);
  }

  @Test
  public void shouldDeleteNodeWithOneChild() {
    bst.insert(10, "Jorge");
    bst.insert(5, "Xuxa");
    bst.insert(3, "Cobra");

    assertThat(bst.root.leftChild.key, is(5));
    bst.delete(5);
    assertThat(bst.root.leftChild.key, is(3));
    assertNull(bst.find(5));
  }

  @Test
  public void shouldDeleteNodeWithTwoChildren() {
    bst.insert(10, "Xuxa10");
    bst.insert(5, "Xuxa5");
    bst.insert(3, "Xuxa3");
    bst.insert(1, "Xuxa1");
    bst.insert(4, "Xuxa4");
    bst.insert(9, "Xuxa9");
    bst.insert(7, "Xuxa7");
    bst.insert(8, "Xuxa8");
    bst.insert(20, "Xuxa20");

    assertThat(bst.root.leftChild.key, is(5));
    bst.delete(5);
    assertThat(bst.root.leftChild.key, is(4));
    assertThat(bst.root.leftChild.value, is("Xuxa4"));
    assertNull(bst.find(5));
  }

  @Test
  public void shouldGetBSTHeight() {
    bst.insert(10, "Xuxa10");
    bst.insert(5, "Xuxa5");
    bst.insert(3, "Xuxa3");
    bst.insert(1, "Xuxa1");
    bst.insert(4, "Xuxa4");
    bst.insert(9, "Xuxa9");
    bst.insert(7, "Xuxa7");
    bst.insert(8, "Xuxa8");
    bst.insert(20, "Xuxa20");

    assertThat(bst.getHeight(), equalTo(5));
  }
  
  @Test
  public void shouldGetBSTSum() {
    bst.insert(10, "Xuxa10");
    bst.insert(5, "Xuxa5");
    bst.insert(3, "Xuxa3");
    bst.insert(1, "Xuxa1");
    bst.insert(4, "Xuxa4");
    bst.insert(9, "Xuxa9");
    bst.insert(7, "Xuxa7");
    bst.insert(8, "Xuxa8");
    bst.insert(20, "Xuxa20");

    assertThat(bst.getSum(), equalTo(67));
  }
}
