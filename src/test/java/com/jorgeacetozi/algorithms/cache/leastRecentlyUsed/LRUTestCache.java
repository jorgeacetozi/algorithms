package com.jorgeacetozi.algorithms.cache.leastRecentlyUsed;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import java.util.Optional;
import org.junit.Test;

public class LRUTestCache {

  private LRUCache<String, Integer> cache = new LRUCache<>(3);

  @Test
  public void shouldUpdateCacheItemWhenThereIsOnlyOneItemInIt() {
    cache.put("jorge", 31);
    cache.put("jorge", 32);
    
    Optional<Integer> optional = cache.get("jorge");
    
    assertTrue(optional.isPresent());
    assertThat(optional.get(), equalTo(32));
  }
}
