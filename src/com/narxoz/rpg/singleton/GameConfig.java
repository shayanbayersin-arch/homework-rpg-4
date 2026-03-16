package com.narxoz.rpg.singleton;

public class GameConfig {
    private static GameConfig instance;

    private GameConfig() {
      
    }

    public static GameConfig getInstance() {
        if (instance == null) {
            instance = new GameConfig();
        }
        return instance;
    }

    public void printConfig() {
    System.out.println("Game configuration loaded");
    }
}
