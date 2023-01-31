package com.silverest.services;

import com.silverest.entities.Dealer;
import com.silverest.entities.Player;
import com.silverest.entities.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class BlackJackService {
  final Logger logger = Logger.getLogger(BlackJackService.class.getName());
  final Map<String, Table> tables = new HashMap<>();

  public void commands() {
    List<String> commands = List.of("Create Table", "Join Table", "List tables", "Exit");

    IntStream commandsStream = IntStream.range(0, commands.size());
    commandsStream.forEach(i -> System.out.println((i + 1) + ": " + commands.get(i)));
  }

  public List<Table> getTables() {
    return tables.values().stream().toList();
  }

  public void createTable(Table table) {
    logger.info("Creating table...");
    logger.info("Table id: " + table.id());
    logger.info("Table dealer: " + table.dealer());
    logger.info("Table deck: " + table.deck());
    logger.info("Table deck count: " + table.deck().size());
    logger.info("Table min bet: " + table.minBet());
    logger.info("Table max bet: " + table.maxBet());
    tables.put(table.id(), table);
  }

  public void deleteTable(Table table) {
    tables.remove(table.id());
  }

  public void addPlayer(String tableId, Player player) {
    tables.get(tableId).players().add(player);
  }

  public void dealCards(String tableId) {
    logger.info("Dealing cards...");
    Table table = tables.get(tableId);
    List<Player> players =
        table.players().stream()
            .map(player -> player.addCard(table.deck().remove(0)).addCard(table.deck().remove(0)))
            .toList();

    Dealer dealer = table.dealer().addCard(table.deck().remove(0)).addCard(table.deck().remove(0));

    table.toBuilder().players(players).dealer(dealer).build();
  }

  public Player hit(String tableId, Player player) {
    logger.info("Hitting...");
    Table table = tables.get(tableId);
    return player.addCard(table.deck().remove(0));
  }

  public Player doubleDown(String tableId, Player player) {
    logger.info("Doubling down...");
    Table table = tables.get(tableId);
    return player.doubleDown(table.deck().remove(0));
  }

  public Player split(String tableId, Player player) {
    logger.info("Splitting...");
    Table table = tables.get(tableId);
    return player.split(table.deck().remove(0), table.deck().remove(0));
  }

  public List<Table> listTables() {
    return tables.values().stream().toList();
  }
}
