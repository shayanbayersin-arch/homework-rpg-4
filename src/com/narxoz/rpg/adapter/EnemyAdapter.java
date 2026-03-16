package com.narxoz.rpg.adapter;

import com.narxoz.rpg.composite.EnemyUnit;

public class EnemyAdapter implements Combatant {

    private EnemyUnit enemy;

    public EnemyAdapter(EnemyUnit enemy) {
        this.enemy = enemy;
    }

    @Override
    public String getName() {
        return enemy.getName();
    }

    @Override
    public int getHealth() {
        return enemy.getHealth();
    }

    @Override
    public void takeDamage(int damage) {
        enemy.takeDamage(damage);
    }
}