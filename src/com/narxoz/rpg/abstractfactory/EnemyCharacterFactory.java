package com.narxoz.rpg.abstractfactory;

import com.narxoz.rpg.composite.HeroUnit;
import com.narxoz.rpg.composite.EnemyUnit;

public class EnemyCharacterFactory implements CharacterFactory {

    @Override
    public HeroUnit createHero(String name) {

        return new HeroUnit(name,100,20);

    }

    @Override
    public EnemyUnit createEnemy(String name) {

        return new EnemyUnit(name,140,30);

    }
}