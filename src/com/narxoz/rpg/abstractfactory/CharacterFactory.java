package com.narxoz.rpg.abstractfactory;

import com.narxoz.rpg.composite.EnemyUnit;
import com.narxoz.rpg.composite.HeroUnit;

public interface CharacterFactory {

    HeroUnit createHero(String name);
    EnemyUnit createEnemy(String name);
}