package com.narxoz.rpg.abstractfactory;

import com.narxoz.rpg.composite.HeroUnit;
import com.narxoz.rpg.composite.EnemyUnit;

public class HeroCharacterFactory implements CharacterFactory {

    @Override
    public HeroUnit createHero(String name) {

        return new HeroUnit(name,120,25);

    }

    @Override
    public EnemyUnit createEnemy(String name) {

        return new EnemyUnit(name,80,20);

    }
}