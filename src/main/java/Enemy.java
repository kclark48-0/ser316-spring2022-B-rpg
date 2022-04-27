package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Entity implements Combatant {

    public Enemy(String name, int level, int xp, int gold, int maxHealth, int maxMana, int attack, int defense, int speed, int reflex) {
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.gold = gold;
        this.maxHealth = maxHealth;
        this.health = this.getMaxHealth();
        this.maxMana = maxMana;
        this.mana = this.getMaxMana();
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.reflex = reflex;
        this.consumables = new ArrayList<>();
    }

}
