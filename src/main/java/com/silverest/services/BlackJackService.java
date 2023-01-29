package com.silverest.services;

import com.silverest.entities.Player;
import com.silverest.entities.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BlackJackService {
    Logger logger = Logger.getLogger(BlackJackService.class.getName());
    List<Table> tables = new ArrayList<>();

    public List<Table> getTables() {
        return tables;
    }

    public void createTable(Table table) {
        logger.info("Creating table...");
        logger.info("Table dealer: " + table.dealer());
        logger.info("Table deck: " + table.deck());
        logger.info("Table deck count: " + table.deck().size());
        logger.info("Table min bet: " + table.minBet());
        logger.info("Table max bet: " + table.maxBet());
        tables.add(table);
    }

    public void deleteTable(Table table) {
        tables.remove(table);
    }

    public void addPlayer(Table table, Player player) {
        table.addPlayer(player);
    }
}
