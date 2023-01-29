package com.silverest.entities.utils;

import com.silverest.entities.Table;

public class TableCompanion {
    public static Table createTable(int deckCount, int minBet, int maxBet) {
        return new Table.TableBuilder()
                .deckCount(deckCount)
                .minBet(minBet)
                .maxBet(maxBet)
                .build();
    }
}
