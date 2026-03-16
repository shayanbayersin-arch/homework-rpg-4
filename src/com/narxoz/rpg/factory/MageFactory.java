package com.narxoz.rpg.factory;

import com.narxoz.rpg.composite.HeroUnit;

public class MageFactory implements HeroFactory {
    @Override
    public HeroUnit createHero() {
        return new HeroUnit("Mage", 90, 40);
    }
}
