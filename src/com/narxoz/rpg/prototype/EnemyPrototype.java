package com.narxoz.rpg.prototype;

import com.narxoz.rpg.composite.EnemyUnit;

public class EnemyPrototype implements Cloneable {

    private EnemyUnit enemy;

    public EnemyPrototype(EnemyUnit enemy) {
        this.enemy = enemy;
    }

    public EnemyUnit cloneEnemy() {
        return new EnemyUnit(enemy.getName(), enemy.getHealth(), enemy.getAttackPower());
    }
}