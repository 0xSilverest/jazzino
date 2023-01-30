package com.silverest.entities;

import com.silverest.utils.Lens;

import java.util.ArrayList;
import java.util.List;

public record Hand(List<Card> cards, List<Card> splCard, boolean isSplit) {
  public static Hand empty() {
    return new Hand(new ArrayList<>(), new ArrayList<>(), false);
  }

  public static Lens<Hand, List<Card>> handCardsLens =
        Lens.of(Hand::cards, cards -> hand -> new Hand(cards, hand.splCard, hand.isSplit));

  public Hand putCard(Card card) {
    return handCardsLens.mod(cards -> {
      cards.add(card);
      return cards;
    }, this);
  }

  public void reset() {
    cards.clear();
  }

  public Hand stand() {
    reset();
    return this;
  }

  public Hand split() {
    splCard.add(cards.remove(1));
    return new Hand(cards, splCard, true);
  }
}
