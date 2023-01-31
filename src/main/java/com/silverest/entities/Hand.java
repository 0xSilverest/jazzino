package com.silverest.entities;

import com.silverest.utils.Lens;

import java.util.ArrayList;
import java.util.List;

public record Hand(List<Card> cards, List<Card> splCards, boolean isSplit) {
  public static Hand empty() {
    return new Hand(new ArrayList<>(), new ArrayList<>(), false);
  }

  public static final Lens<Hand, List<Card>> handCardsLens =
      Lens.of(Hand::cards, cards -> hand -> new Hand(cards, hand.splCards, hand.isSplit));

  public static final Lens<Hand, List<Card>> splCardsLens =
      Lens.of(Hand::splCards, splCards -> hand -> new Hand(hand.cards, splCards, hand.isSplit));

  public static final Lens<Hand, Boolean> isSplitLens =
      Lens.of(Hand::isSplit, isSplit -> hand -> new Hand(hand.cards, hand.splCards, isSplit));

  public Hand putCard(Card card) {
    return handCardsLens.mod(
        cards -> {
          cards.add(card);
          return cards;
        },
        this);
  }

  public Hand removeCard(Card card) {
    return handCardsLens.mod(
        cards -> {
          cards.remove(card);
          return cards;
        },
        this);
  }

  public Hand putSplCard(Card card) {
    return splCardsLens.mod(
        splCards -> {
          splCards.add(card);
          return splCards;
        },
        this);
  }

  public Hand removeSplCard(Card card) {
    return splCardsLens.mod(
        splCards -> {
          splCards.remove(card);
          return splCards;
        },
        this);
  }

  public Hand setIsSplit(boolean isSplit) {
    return isSplitLens.mod(b -> isSplit, this);
  }

  public Hand reset() {
    return handCardsLens
        .mod(cards -> new ArrayList<>(), splCardsLens.mod(splCards -> new ArrayList<>(), this))
        .setIsSplit(false);
  }

  public Hand split(Card card, Card splCard) {
    return this.setIsSplit(true).putCard(card).putSplCard(splCard);
  }
}