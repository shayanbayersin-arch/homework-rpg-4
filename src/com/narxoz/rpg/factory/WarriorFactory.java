package com.narxoz.rpg.factory;

import com.narxoz.rpg.composite.HeroUnit;

public class WarriorFactory implements HeroFactory {
    @Override
    public HeroUnit createHero() {
        return new HeroUnit("Warrior", 140, 30);
    }
}