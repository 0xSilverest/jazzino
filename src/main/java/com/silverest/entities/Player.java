package com.silverest.entities;

import com.silverest.utils.Lens;

import java.util.function.Function;

public record Player(String id, String name, Hand hand, double balance, double bet) {

  public static Player init(String id, String name, double balance) {
    return new Player(id, name, Hand.empty(), balance, 0.0);
  }

  public static final Lens<Player, String> playerNameLens =
      Lens.of(Player::name, n -> p -> new Player(p.id, n, p.hand, p.balance, p.bet));

  public static final Lens<Player, Hand> playerHandLens =
      Lens.of(Player::hand, h -> p -> new Player(p.id, p.name, h, p.balance, p.bet));

  public static final Lens<Player, Double> playerBalanceLens =
      Lens.of(Player::balance, b -> p -> new Player(p.id, p.name, p.hand, b, p.bet));

  public static final Lens<Player, Double> playerBetLens =
      Lens.of(Player::bet, b -> p -> new Player(p.id, p.name, p.hand, p.balance, b));

  public Player withName(String name) {
    return playerNameLens.mod(n -> name, this);
  }

  public Player withBalance(double balance) {
    return playerBalanceLens.mod(b -> b + balance, this);
  }

  public Player withBet(double bet) {
    return playerBetLens.mod(b -> b + bet, this);
  }

  public Player withHand(Hand hand) {
    return playerHandLens.mod(h -> hand, this);
  }

  public Player addCard(Card card) {
    return playerHandLens.mod(h -> h.putCard(card), this);
  }

  public void emptyHand() {
    hand.reset();
  }

  public Player resetBet() {
    return playerBetLens.mod(b -> 0.0, this);
  }

  public Player doubleDown(Card card) {
    return this.withBet(bet * 2).addCard(card);
  }

  public Player split(Card card, Card splCard) {
    return this.withHand(hand.split(card, splCard));
  }

  public Player surrender() {
    return this.withBalance(balance + bet / 2).withBet(0.0);
  }
}
