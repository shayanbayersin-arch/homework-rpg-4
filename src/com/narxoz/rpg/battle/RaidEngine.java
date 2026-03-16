package com.narxoz.rpg.battle;

import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.CombatNode;
import java.util.Random;

public class RaidEngine {
    private Random random = new Random(1L);

    public RaidEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public RaidResult runRaid(CombatNode teamA, CombatNode teamB, Skill teamASkill, Skill teamBSkill) {
        System.out.println("Raid started!");
        System.out.println(teamA.getName() + " fight " + teamB.getName());

        RaidResult result = new RaidResult();
        result.setRounds(1);
        result.setWinner(teamA.getName());
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