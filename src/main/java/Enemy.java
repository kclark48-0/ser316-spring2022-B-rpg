package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Entity implements Combatant {

    /**
     * Custom constructor to set all attributes to specific values.
     * @param name the Enemy's name
     * @param level the Enemy's level
     * @param maxHealth the Enemy's maximum health
     * @param maxMana the Enemy's maximum mana
     * @param attack the Enemy's attack power
     * @param defense the Enemy's defense
     * @param speed the Enemy's speed
     * @param xp the amount of experience the Enemy has
     * @param gold the amount of gold the Enemy has
     * @param reflex the Enemy's reflex
     */
    public Enemy(String name, int level, int xp, int gold, int maxHealth, int maxMana, int attack,
                 int defense, int speed, int reflex) {
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
