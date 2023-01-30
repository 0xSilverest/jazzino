package com.silverest.executors;

import com.silverest.services.BlackJackService;

public class BlackJackCommandsExecutor {

    private final BlackJackService blackJackService = new BlackJackService();

    public void commands() {
        blackJackService.commands();

        System.out.println("Please enter a command: ");

        switch (System.console().readLine()) {
            case "1" -> System.out.println("Creating table...");
            case "2" -> System.out.println("Joining table...");
            case "3" -> System.out.println("Creating player...");
            case "4" -> {
                System.out.println("Exiting...");
                System.exit(0);
            }
            default -> System.out.println("Invalid command!");
        }
    }
}
