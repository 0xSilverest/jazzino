package com.silverest.entities;

import com.silverest.utils.Lens;

import java.util.function.Function;

public record Player(String id, String name, Hand hand, double balance, double bet) {

  public static final Lens<Player, String> playerNameLens =
      Lens.of(Player::name, n -> p -> p.withName(n));

  private Player withName(String name) {
    return new Player(id, name, hand, balance, bet);
  }

  public static final Lens<Player, Hand> playerHandLens =
      Lens.of(Player::hand, h -> p -> p.withHand(h));

  private Player withHand(Hand hand) {
    return new Player(id, name, hand, balance, bet);
  }

  public static final Lens<Player, Double> playerBalanceLens =
      Lens.of(Player::balance, b -> p -> p.withBalance(b));

  private Player withBalance(double balance) {
    return new Player(id, name, hand, balance, bet);
  }

  public static final Lens<Player, Double> playerBetLens =
      Lens.of(Player::bet, b -> p -> p.withBet(b));

  private Player withBet(double bet) {
    return new Player(id, name, hand, balance, bet);
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

  public Player resetBalance() {
    return playerBalanceLens.mod(b -> 0.0, this);
  }

  public Player setBet(double bet) {
    return playerBetLens.mod(b -> b + bet, this);
  }

  public Player setBalance(double balance) {
    return playerBalanceLens.mod(b -> b + balance, this);
  }

  public Player stand() {
    return playerHandLens.mod(Hand::stand, this);
  }

  public Player doubleDown() {
    return playerBetLens.mod(b -> b * 2, this);
  }

  public Player split() {
    return playerHandLens.mod(h -> h.split(), this);
  }

  public Player surrender() {
    return this.withBet(0.0).withBalance(this.balance() / 2);
  }
}
