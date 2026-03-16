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
   
        return 0;
    }

    @Override
    public int getAttackPower() {
      
        return 0;
    }

    @Override
    public void takeDamage(int amount) {
       
    }

    @Override
    public boolean isAlive() {

    for (CombatNode child : children) {
        if (child.isAlive()) {
            return true;
        }
    }

    return false;
    }
    

    @Override
    public List<CombatNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void printTree(String indent) {
    int totalHP = 0;
    int totalATK = 0;

    for (CombatNode child : children) {
    totalHP += child.getHealth();
    totalATK += child.getAttackPower();
    }

    System.out.println(indent + "+ " + name + " [HP=" + totalHP + ", ATK=" + totalATK + "]");

    for (CombatNode child : children) {
     child.printTree(indent + "  ");
    }
    }

    private List<CombatNode> getAliveChildren() {

    List<CombatNode> alive = new ArrayList<>();

    for (CombatNode child : children) {
        if (child.isAlive()) {
            alive.add(child);
        }
    }

    return alive;
}
}
