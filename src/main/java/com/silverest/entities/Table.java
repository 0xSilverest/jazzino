package com.silverest.entities;

import com.silverest.entities.utils.DealerCompanion;
import com.silverest.entities.utils.DeckCompanion;

import java.util.ArrayList;
import java.util.List;

public record Table(
    String id, List<Player> players, Dealer dealer, List<Card> deck, double minBet, double maxBet) {

  public static Table builder() {
    return new TableBuilder().build();
  }

  public TableBuilder toBuilder() {
    return new TableBuilder()
        .players(players)
        .dealer(dealer)
        .deck(deck)
        .minBet(minBet)
        .maxBet(maxBet);
  }

  public static class TableBuilder {

    private final String id = "table-" + System.currentTimeMillis();
    private List<Player> players = new ArrayList<>();
    private Dealer dealer = DealerCompanion.createDealer();
    private List<Card> deck = new ArrayList<>();
    private double minBet = 1.0;
    private double maxBet = 10.0;

    public TableBuilder players(List<Player> players) {
      this.players = players;
      return this;
    }

    public TableBuilder dealer(Dealer dealer) {
      this.dealer = dealer;
      return this;
    }

    public TableBuilder deck(List<Card> deck) {
      this.deck = deck;
      return this;
    }

    public TableBuilder deckCount(int deckCount) {
      this.deck = DeckCompanion.createDeck(deckCount);
      return this;
    }

    public TableBuilder minBet(double minBet) {
      this.minBet = minBet;
      return this;
    }

    public TableBuilder maxBet(double maxBet) {
      this.maxBet = maxBet;
      return this;
    }

    public Table build() {
      if (this.deck.isEmpty()) {
        this.deck = DeckCompanion.createDeck(4);
      }
      return new Table(id, players, dealer, deck, minBet, maxBet);
    }
  }

  public void addPlayer(Player player) {
    players.add(player);
  }

  public void removePlayer(Player player) {
    players.remove(player);
  }

  public void dealCards() {
    for (Player player : players) {
      player.addCard(deck.remove(0));
      player.addCard(deck.remove(0));
    }
    dealer.addCard(deck.remove(0));
    dealer.addCard(deck.remove(0));
  }

  public void newRound() {
    for (Player player : players) {
      player.emptyHand();
    }
    dealer.reset();
  }
}