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

        // ---------- Singleton ----------
        GameConfig config = GameConfig.getInstance();
        config.printConfig();

        // ---------- Factory (создание героев) ----------
        HeroFactory warriorFactory = new WarriorFactory();
        HeroFactory mageFactory = new MageFactory();

        HeroUnit warrior = warriorFactory.createHero("Thor");
        HeroUnit mage = mageFactory.createHero("Merlin");

        // ---------- Builder (создание врагов) ----------
        EnemyBuilder enemyBuilder = new EnemyBuilder();

        EnemyUnit goblin = enemyBuilder
                .setName("Goblin")
                .setHealth(80)
                .setAttack(15)
                .build();

        EnemyUnit orc = enemyBuilder
                .setName("Orc")
                .setHealth(120)
                .setAttack(25)
                .build();

        // ---------- Composite (создание групп) ----------
        PartyComposite heroParty = new PartyComposite("Hero Party");
        heroParty.add(warrior);
        heroParty.add(mage);

        PartyComposite enemyParty = new PartyComposite("Enemy Party");
        enemyParty.add(goblin);
        enemyParty.add(orc);

        // ---------- Bridge (skills + effects) ----------
        Skill fireball = new SingleTargetSkill("Fireball", 30, new FireEffect());
        Skill iceStorm = new AreaSkill("Ice Storm", 20, new IceEffect());

        System.out.println("\n=== Skills Demo ===");
        fireball.cast(goblin);
        iceStorm.cast(enemyParty);

        // ---------- Raid Engine ----------
        RaidEngine engine = new RaidEngine();

        System.out.println("\n=== Raid Battle ===");

        RaidResult result = engine.startRaid(heroParty, enemyParty);

        System.out.println("\n=== Battle Result ===");
        System.out.println(result.getWinner());

    }
}