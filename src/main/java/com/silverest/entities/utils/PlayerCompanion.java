package com.silverest.entities.utils;

import com.silverest.entities.Player;

import java.util.Random;

public class PlayerCompanion {
  public static Player createPlayer(String name, double balance) {
    Random random = new Random();
    return Player.init(String.valueOf(random.nextInt(1000)), name, balance);
  }
}
