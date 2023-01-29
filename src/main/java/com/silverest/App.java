package com.silverest;

import com.silverest.entities.utils.TableCompanion;
import com.silverest.services.BlackJackService;

import java.util.List;
import java.util.stream.IntStream;

public class App {
    private static final BlackJackService blackJackService = new BlackJackService();

    private static void commands() {
        List<String> commands = List.of(
                "Create Table",
                "Join Table",
                "Create Player",
                "Exit"
        );

        IntStream commandsStream = IntStream.range(0, commands.size());
        commandsStream.forEach(i -> System.out.println((i+1) + ": " + commands.get(i)));

        System.out.println("Please enter a command: ");

        switch (System.console().readLine()) {
            case "1" -> {
                System.out.println("Creating table...");
                commands();
            }
            case "2" -> {
                System.out.println("Joining table...");
                commands();
            }
            case "3" -> {
                System.out.println("Creating player...");
                commands();
            }
            case "4" -> {
                System.out.println("Exiting...");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid command!");
                commands();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Jazzino!");
        commands();
    }
}
