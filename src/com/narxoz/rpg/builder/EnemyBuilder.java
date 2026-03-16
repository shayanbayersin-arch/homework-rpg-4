package com.narxoz.rpg.builder;

import com.narxoz.rpg.composite.EnemyUnit;

public class EnemyBuilder {

    private String name;
    private int health;
    private int attack;

    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public EnemyBuilder setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public EnemyUnit build() {
        return new EnemyUnit(name, health, attack);
    }
}