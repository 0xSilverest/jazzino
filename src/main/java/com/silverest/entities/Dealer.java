package com.silverest.entities;

public record Dealer(String name, Hand hand) {
    public Dealer addCard(Card card) {
        return new Dealer(name, hand.putCard(card));
    }

    public void reset() {
        hand.reset();
    }
}
