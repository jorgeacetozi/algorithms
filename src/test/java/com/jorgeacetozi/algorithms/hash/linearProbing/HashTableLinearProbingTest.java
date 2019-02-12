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

  @Test
  public void shouldInsertItemWhenThereIsCollision() {
    hashTable.put("Jorge", 30);
    hashTable.put("Jorge", 35);
    hashTable.put("Jorge", 40);
    assertThat(hashTable.size, equalTo(3));
    assertThat(hashTable.table[3].value, equalTo(30));
    assertThat(hashTable.table[4].value, equalTo(35));
    assertThat(hashTable.table[0].value, equalTo(40));
  }
}
