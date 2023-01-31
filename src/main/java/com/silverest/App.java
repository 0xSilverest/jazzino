package com.silverest;

import com.silverest.entities.Player;
import com.silverest.entities.utils.PlayerCompanion;
import com.silverest.executors.BlackJackCommandsExecutor;

public class App {
  private final static BlackJackCommandsExecutor blackJackCommandsExecutor =
      new BlackJackCommandsExecutor();

  public static void main(String[] args) {
    System.out.println("Welcome to Jazzino!");
    Player player = PlayerCompanion.createPlayer("John", 100.0);
    blackJackCommandsExecutor.commands(player);
  }
}
