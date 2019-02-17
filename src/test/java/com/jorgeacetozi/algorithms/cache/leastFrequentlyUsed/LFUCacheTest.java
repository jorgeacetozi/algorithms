package com.jorgeacetozi.algorithms.cache.leastFrequentlyUsed;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import java.util.Optional;
import org.junit.Test;

public class LFUCacheTest {

  private LFUCache<String, Integer> cache = new LFUCache<>(3);

  @Test
  public void shouldInsertIntoCache() {
    cache.put("jorge1", 1);
    cache.put("jorge2", 2);
    cache.put("jorge3", 3);
    assertTrue(cache.isFull());
  }

  @Test
  public void shouldGetItemFromCache() {
    cache.put("jorge1", 1);
    cache.put("jorge2", 2);
    cache.put("jorge3", 3);
    Optional<Integer> presentOptional = cache.get("jorge1");
    assertTrue(presentOptional.isPresent());
    assertThat(presentOptional.get(), equalTo(1));

    Optional<Integer> notPresentOptional = cache.get("jorge4");
    assertFalse(notPresentOptional.isPresent());
  }
}
