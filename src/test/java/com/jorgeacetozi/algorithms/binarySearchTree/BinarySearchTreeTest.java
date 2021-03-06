package com.jorgeacetozi.algorithms.binarySearchTree;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Optional;
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
    Optional<Node> nodeOptional = bst.find(12);

    assertTrue(nodeOptional.isPresent());

    Node cobra = nodeOptional.get();
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

  @Test
  public void shouldDoNothingWhenDeletingItemThatIsNotInTheBST() {
    bst.insert(10, "Jorge");
    bst.delete(11);
    assertThat(bst.root.key, equalTo(10));
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
    assertFalse(bst.find(5).isPresent());
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
    assertFalse(bst.find(5).isPresent());
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

  @Test
  public void shouldTraverseInorder() {
    bst.insert(3, "Xuxa3");
    bst.insert(1, "Xuxa1");
    bst.insert(5, "Xuxa5");
    bst.insert(4, "Xuxa4");
    bst.insert(2, "Xuxa2");
    bst.insert(6, "Xuxa6");
    bst.insert(0, "Xuxa0");

    List<Node> inorderTraversal = bst.inorderTraversal();

    assertThat(inorderTraversal.get(0).key, equalTo(0));
    assertThat(inorderTraversal.get(1).key, equalTo(1));
    assertThat(inorderTraversal.get(2).key, equalTo(2));
    assertThat(inorderTraversal.get(3).key, equalTo(3));
    assertThat(inorderTraversal.get(4).key, equalTo(4));
    assertThat(inorderTraversal.get(5).key, equalTo(5));
    assertThat(inorderTraversal.get(6).key, equalTo(6));
  }

  @Test
  public void shouldTraversePreorder() {
    bst.insert(3, "Xuxa3");
    bst.insert(1, "Xuxa1");
    bst.insert(5, "Xuxa5");
    bst.insert(4, "Xuxa4");
    bst.insert(2, "Xuxa2");
    bst.insert(6, "Xuxa6");
    bst.insert(0, "Xuxa0");

    List<Node> preorderTraversal = bst.preorderTraversal();

    assertThat(preorderTraversal.get(0).key, equalTo(3));
    assertThat(preorderTraversal.get(1).key, equalTo(1));
    assertThat(preorderTraversal.get(2).key, equalTo(0));
    assertThat(preorderTraversal.get(3).key, equalTo(2));
    assertThat(preorderTraversal.get(4).key, equalTo(5));
    assertThat(preorderTraversal.get(5).key, equalTo(4));
    assertThat(preorderTraversal.get(6).key, equalTo(6));
  }

  @Test
  public void shouldTraversePostorder() {
    bst.insert(3, "Xuxa3");
    bst.insert(1, "Xuxa1");
    bst.insert(5, "Xuxa5");
    bst.insert(4, "Xuxa4");
    bst.insert(2, "Xuxa2");
    bst.insert(6, "Xuxa6");
    bst.insert(0, "Xuxa0");

    List<Node> postorderTraversal = bst.postorderTraversal();

    assertThat(postorderTraversal.get(0).key, equalTo(0));
    assertThat(postorderTraversal.get(1).key, equalTo(2));
    assertThat(postorderTraversal.get(2).key, equalTo(1));
    assertThat(postorderTraversal.get(3).key, equalTo(4));
    assertThat(postorderTraversal.get(4).key, equalTo(6));
    assertThat(postorderTraversal.get(5).key, equalTo(5));
    assertThat(postorderTraversal.get(6).key, equalTo(3));
  }
}
