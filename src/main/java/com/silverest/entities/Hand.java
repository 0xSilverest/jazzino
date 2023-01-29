package com.silverest.entities;

import java.util.ArrayList;
import java.util.List;

public record Hand(List<Card> cards, boolean isSplit) {
  public static Hand empty() {
    return new Hand(new ArrayList<>(), false);
  }
}
