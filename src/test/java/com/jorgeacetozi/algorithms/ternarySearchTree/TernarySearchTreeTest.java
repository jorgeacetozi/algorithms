package com.jorgeacetozi.algorithms.ternarySearchTree;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class TernarySearchTreeTest {

  TernarySearchTree ternarySearchTree = new TernarySearchTree();

  @Test
  public void shouldInsertIntoTST() {
    ternarySearchTree.put("jo", 10);
    ternarySearchTree.put("jor", 15);
    ternarySearchTree.put("j", 20);
    ternarySearchTree.put("c", 25);
    ternarySearchTree.put("ca", 30);
    ternarySearchTree.put("z", 35);

    assertThat(ternarySearchTree.root.character, equalTo('j'));
    assertThat(ternarySearchTree.root.middleChild.character, equalTo('o'));
    assertThat(ternarySearchTree.root.middleChild.middleChild.character, equalTo('r'));
    assertThat(ternarySearchTree.root.leftChild.character, equalTo('c'));
    assertThat(ternarySearchTree.root.leftChild.middleChild.character, equalTo('a'));
    assertThat(ternarySearchTree.root.rightChild.character, equalTo('z'));

    assertThat(ternarySearchTree.root.value, equalTo(20));
    assertThat(ternarySearchTree.root.middleChild.value, equalTo(10));
    assertThat(ternarySearchTree.root.middleChild.middleChild.value, equalTo(15));
    assertThat(ternarySearchTree.root.leftChild.value, equalTo(25));
    assertThat(ternarySearchTree.root.leftChild.middleChild.value, equalTo(30));
    assertThat(ternarySearchTree.root.rightChild.value, equalTo(35));
  }
  
  @Test
  public void shouldGetFromTST() {
    ternarySearchTree.put("jorge", "algorithms");
    Optional<Object> optional = ternarySearchTree.get("jorge");
    
    assertTrue(optional.isPresent());
    assertThat(optional.get(), equalTo("algorithms"));
  }

  @Test
  public void shouldFindPartials() {
    ternarySearchTree.put("catolico", "catolico");
    ternarySearchTree.put("catarro", "catarro");
    ternarySearchTree.put("catra", "catra");
    ternarySearchTree.put("catapora", "catapora");
    ternarySearchTree.put("cabra", "cabra");
    ternarySearchTree.put("dado", "dado");
    ternarySearchTree.put("zebra", "zebra");

    List<String> partials = ternarySearchTree.findPartials("cat");
    assertThat(partials.get(0), equalTo("catapora"));
    assertThat(partials.get(1), equalTo("catarro"));
    assertThat(partials.get(2), equalTo("catolico"));
    assertThat(partials.get(3), equalTo("catra"));
  }

  @Test
  public void shouldFindLongestCommonPrefixWhenThereIsNoLeftOrRightChild() {
    String longestCommonPrefix =
        ternarySearchTree.longestCommonPrefix(Arrays.asList("jor", "jorge", "jorgetest"));
    assertThat(longestCommonPrefix, equalTo("jor"));
  }

  @Test
  public void shouldFindLongestCommonPrefixCaseWhenThereIsLeftOrRightChild() {
    String longestCommonPrefix =
        ternarySearchTree.longestCommonPrefix(Arrays.asList("jor", "jorge", "job", "jjj"));
    assertThat(longestCommonPrefix, equalTo("j"));
  }
}
