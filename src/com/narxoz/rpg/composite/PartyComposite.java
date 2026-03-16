package com.narxoz.rpg.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartyComposite implements CombatNode {
    private final String name;
    private final List<CombatNode> children = new ArrayList<>();

    public PartyComposite(String name) {
        this.name = name;
    }

    public void add(CombatNode node) {
        children.add(node);
    }

    public void remove(CombatNode node) {
        children.remove(node);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        int totalHP = 0;
        for (CombatNode child : children) {
            totalHP += child.getHealth();
        }
        return totalHP;
    }

    @Override
    public int getAttackPower() {
        int totalATK = 0;
        for (CombatNode child : children) {
            totalATK += child.getAttackPower();
        }
        return totalATK;
    }

    @Override
    public void takeDamage(int amount) {
        if (children.isEmpty()) return;
        int damagePerChild = amount / children.size();
        for (CombatNode child : children) {
            child.takeDamage(damagePerChild);
        }
    }

    @Override
    public boolean isAlive() {
        for (CombatNode child : children) {
            if (child.isAlive()) return true;
        }
        return false;
    }

    @Override
    public List<CombatNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "+ " + name + " [HP=" + getHealth() + ", ATK=" + getAttackPower() + "]");
        for (CombatNode child : children) {
            child.printTree(indent + "  ");
        }
    }
}