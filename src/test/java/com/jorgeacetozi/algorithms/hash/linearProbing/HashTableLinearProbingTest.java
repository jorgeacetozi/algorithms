package com.jorgeacetozi.algorithms.hash.linearProbing;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class HashTableLinearProbingTest {

  HashTableLinearProbing<String, Integer> hashTable = new HashTableLinearProbing<>(5);

  @Test
  public void shouldInsertItemWhenThereIsNoCollision() {
    hashTable.put("Jorge", 30);
    assertThat(hashTable.size, equalTo(1));
    assertThat(hashTable.table[3].value, equalTo(30));
  }

}
