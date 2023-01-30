package com.silverest.services;

import com.silverest.entities.Player;
import com.silverest.entities.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class BlackJackService {
    Logger logger = Logger.getLogger(BlackJackService.class.getName());
    List<Table> tables = new ArrayList<>();

    public void commands() {
        List<String> commands = List.of(
                "Create Table",
                "Join Table",
                "Create Player",
                "Exit"
        );

        IntStream commandsStream = IntStream.range(0, commands.size());
        commandsStream.forEach(i -> System.out.println((i+1) + ": " + commands.get(i)));
    }

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
