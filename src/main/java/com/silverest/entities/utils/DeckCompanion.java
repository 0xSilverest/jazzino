package com.silverest.entities.utils;

import com.silverest.entities.Card;
import com.silverest.entities.Rank;
import com.silverest.entities.Suit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeckCompanion {
  public static List<Card> createDeck(int numberOfDecks) {
    return Arrays.stream(Suit.values())
        .flatMap(
            suit ->
                Arrays.stream(Rank.values())
                    .flatMap(
                        rank -> Collections.nCopies(numberOfDecks, new Card(suit, rank)).stream())
                    .toList()
                    .stream())
        .toList();
  }
}
