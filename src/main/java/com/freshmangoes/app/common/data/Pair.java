package com.freshmangoes.app.common.data;

import java.util.AbstractMap;

public class Pair<F, S> extends AbstractMap.SimpleImmutableEntry<F, S> {
  public Pair(F f, S s) {
    super(f, s);
  }

  public F getFirst() {
    return getKey();
  }

  public S getSecond() {
    return getValue();
  }

  public String toString() {
    return "[" + getKey() + "," + getValue() + "]";
  }
}