package com.silverest.executors;

import com.silverest.entities.PlayerChoice;

public class PlayerChoiceExecutor {
    public void execute(PlayerChoice choice) {
        switch (choice) {
            case HIT -> System.out.println("HIT");
            case STAND -> System.out.println("STAND");
            case SPLIT -> System.out.println("SPLIT");
            case DOUBLE -> System.out.println("DOUBLE");
            case SURRENDER -> System.out.println("SURRENDER");
        }
    }
}
