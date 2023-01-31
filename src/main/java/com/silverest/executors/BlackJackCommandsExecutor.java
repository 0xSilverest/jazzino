package com.silverest.executors;

import com.silverest.entities.Player;
import com.silverest.entities.utils.TableCompanion;
import com.silverest.services.BlackJackService;

import java.util.Scanner;

public class BlackJackCommandsExecutor {

  private final BlackJackService blackJackService = new BlackJackService();

  public void commands(Player player) {
    blackJackService.commands();

    System.out.println("Please enter a command: ");

    Scanner scanner = new Scanner(System.in);

    while (true) {
      switch (scanner.nextLine()) {
        case "1" -> blackJackService.createTable(TableCompanion.createTable(4, 1.0, 10.0));
        case "2" -> blackJackService.addPlayer(scanner.nextLine(), player);
        case "3" -> blackJackService.listTables().forEach(System.out::println);
        case "4" -> {
          System.out.println("Exiting...");
          System.exit(0);
        }
        default -> System.out.println("Invalid command!");
      }
    }
  }
}
