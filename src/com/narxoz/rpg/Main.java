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

        PartyComposite heroParty = new PartyComposite("Heroes");
        heroParty.add(warrior);
        heroParty.add(mage);

        PartyComposite enemyParty = new PartyComposite("Enemies");
        enemyParty.add(goblin);
        enemyParty.add(orc);

        System.out.println("\n=== Raid Structure ===");
        heroParty.printTree("");
        enemyParty.printTree("");


        Skill fireball = new SingleTargetSkill("Fireball", 30, new FireEffect());
        Skill iceStorm = new AreaSkill("Ice Storm", 20, new IceEffect());

        System.out.println("\n=== Skills Demo ===");

        fireball.cast(goblin);
        iceStorm.cast(enemyParty);

       
        RaidEngine engine = new RaidEngine();

        System.out.println("\n=== Battle Start ===");

        engine.runRaid(heroParty, enemyParty, fireball, iceStorm);

        System.out.println("\n=== Demo Finished ===");

    }
}