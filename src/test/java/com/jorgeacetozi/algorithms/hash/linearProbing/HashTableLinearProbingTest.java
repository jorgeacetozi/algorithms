package com.jorgeacetozi.algorithms.hash.linearProbing;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import java.util.Optional;
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

  @Test
  public void shouldgetItemWhenThereIsNoCollision() {
    hashTable.put("Jorge", 30);
    assertThat(hashTable.size, equalTo(1));

    Optional<Integer> optional = hashTable.get("Jorge");

    assertTrue(optional.isPresent());
    assertThat(optional.get(), equalTo(30));
  }

  @Test
  public void shouldGetItemWhenThereIsCollision() {
    hashTable.put("Jorge", 30);
    hashTable.put("Xuxinha", 35);
    assertThat(hashTable.size, equalTo(2));

    Optional<Integer> optionalJorge = hashTable.get("Jorge");

    assertTrue(optionalJorge.isPresent());
    assertThat(optionalJorge.get(), equalTo(30));

    Optional<Integer> optionalXuxinha = hashTable.get("Xuxinha");

    assertTrue(optionalXuxinha.isPresent());
    assertThat(optionalXuxinha.get(), equalTo(35));
  }
}
