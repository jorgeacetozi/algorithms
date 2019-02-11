package com.jorgeacetozi.algorithms.hash;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import java.util.Optional;
import org.junit.Test;

public class HashTableChainingTest {

  HashTableChaining<String, Integer> hashTable = new HashTableChaining<>(5);

  @Test
  public void shouldInsertToLinkedListWhenThereIsAColision() {
    hashTable.put("Jorge", 30);
    hashTable.put("Jorge", 35);
    assertThat(hashTable.table[3].value, equalTo(35));
    assertThat(hashTable.table[3].next.value, equalTo(30));
  }

  @Test
  public void shouldGetItemWhenThereIsNoColision() {
    hashTable.put("Jorge", 30);
    Optional<Integer> optional = hashTable.get("Jorge");

    assertTrue(optional.isPresent());
    assertThat(optional.get(), equalTo(30));
  }

  @Test
  public void shouldGetItemWhenThereIsColision() {
    hashTable.put("Jorge", 30);
    hashTable.put("Xuxinha", 35);
    Optional<Integer> optional = hashTable.get("Jorge");

    assertTrue(optional.isPresent());
    assertThat(optional.get(), equalTo(30));
  }

  @Test
  public void shouldReturnEmptyWhenThereIsNoItemWithTheGivenKey() {
    hashTable.put("Jorge", 30);
    Optional<Integer> optional = hashTable.get("Cobra");
    assertFalse(optional.isPresent());
  }
}
