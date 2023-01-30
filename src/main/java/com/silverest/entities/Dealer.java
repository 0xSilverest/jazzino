package com.silverest.entities;

public record Dealer(String name, Hand hand) {
    public void addCard(Card card) {
        hand.putCard(card);
    }

    public void reset() {
        hand.reset();
    }
}
