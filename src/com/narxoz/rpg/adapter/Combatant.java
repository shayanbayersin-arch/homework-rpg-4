package com.narxoz.rpg.adapter;

public interface Combatant {
    String getName();
    int getHealth();
    void takeDamage(int amount);
    
}
