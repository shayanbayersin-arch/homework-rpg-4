package com.narxoz.rpg.battle;

import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.CombatNode;
import com.narxoz.rpg.composite.PartyComposite;

import java.util.Random;

public class RaidEngine {
    private Random random = new Random(1L);

    public RaidEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public RaidResult runRaid(CombatNode teamA, CombatNode teamB, Skill teamASkill, Skill teamBSkill) {
        RaidResult result = new RaidResult();
        result.setRounds(0);
        result.setWinner("TBD");
        result.addLine("TODO: implement raid simulation");
        return result;
    }

    public void runRaid(CombatNode heroes, CombatNode enemies) {

    System.out.println("Raid started!");

    if (!heroes.isAlive() || !enemies.isAlive()) {
        System.out.println("One side has no alive units.");
        return;
    }

    System.out.println(heroes.getName() + " fight " + enemies.getName());
}

}
