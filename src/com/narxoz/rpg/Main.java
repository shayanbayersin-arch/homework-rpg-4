
package com.narxoz.rpg;

import com.narxoz.rpg.bridge.*;
import com.narxoz.rpg.composite.*;
import com.narxoz.rpg.battle.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.singleton.GameConfig;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== RPG Raid System Demo ===");

        GameConfig config = GameConfig.getInstance();
        config.printConfig();

        HeroFactory warriorFactory = new WarriorFactory();
        HeroFactory mageFactory = new MageFactory();

        HeroUnit warrior = warriorFactory.createHero();
        HeroUnit mage = mageFactory.createHero();

        EnemyBuilder builder = new EnemyBuilder();

        EnemyUnit goblin = builder
                .setName("Goblin")
                .setHealth(80)
                .setAttack(15)
                .build();

        EnemyUnit orc = builder
                .setName("Orc")
                .setHealth(120)
                .setAttack(25)
                .build();

        PartyComposite heroes = new PartyComposite("Heroes");
        heroes.add(warrior);
        heroes.add(mage);

        PartyComposite enemies = new PartyComposite("Enemies");
        enemies.add(goblin);
        enemies.add(orc);

        Skill fireball = new SingleTargetSkill("Fireball", 30, new FireEffect());
        fireball.cast(goblin);

        RaidEngine engine = new RaidEngine();

        engine.runRaid(heroes, enemies, fireball, null); 
    
    }
}