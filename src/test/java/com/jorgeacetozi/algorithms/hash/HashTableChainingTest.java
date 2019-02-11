package com.jorgeacetozi.algorithms.hash;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
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

}
