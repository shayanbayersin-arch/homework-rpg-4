package com.narxoz.rpg.adapter;

import com.narxoz.rpg.composite.HeroUnit;

public class HeroAdapter implements Combatant {

    private HeroUnit hero;

    public HeroAdapter(HeroUnit hero) {
        this.hero = hero;
    }

    @Override
    public String getName() {
        return hero.getName();
    }

    @Override
    public int getHealth() {
        return hero.getHealth();
    }

    @Override
    public void takeDamage(int amount) {
        hero.takeDamage(amount);
    }
}