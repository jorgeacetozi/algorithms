package com.jorgeacetozi.algorithms.binarySearchTree;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class BinarySearchTreeTest {

  @Test
  public void shouldInsertRootNode() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(10, "Jorge");
    assertNotNull(bst.root);
    assertThat(bst.root.key, is(10));
    assertThat(bst.root.value, is("Jorge"));
  }

  @Test
  public void shouldInsertLeftChildAndRightChild() {
    BinarySearchTree bst = new BinarySearchTree();
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
    BinarySearchTree bst = new BinarySearchTree();
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
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(10, "Jorge");
    bst.insert(15, "Xuxa");
    bst.insert(15, "Cobra");
    assertThat(bst.root.rightChild.value, is("Cobra"));
  }

  @Test
  public void shouldFindNodeByKey() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(10, "Jorge");
    bst.insert(15, "Xuxa");
    bst.insert(12, "Cobra");
    Node cobra = bst.find(12);
    assertThat(cobra.key, is(12));
    assertThat(cobra.value, is("Cobra"));
  }
  
  @Test
  public void shouldFindMinimumKey() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(10, "Jorge");
    bst.insert(15, "Xuxa");
    bst.insert(12, "Cobra");
    bst.insert(7, "Hello");
    bst.insert(3, "Minimum");
    Node min = bst.findMin();
    assertThat(min.key, is(3));
    assertThat(min.value, is("Minimum"));
  }
}
