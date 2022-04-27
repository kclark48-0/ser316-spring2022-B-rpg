package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Character extends Entity implements Combatant {

    private String path;
    private String race;
    private Equipment armor;
    private Equipment weapon;
    private Equipment enchant;

    public Character() {
        this.xp = 0;
        this.gold = 0;
        this.name = "defaultChar";
        this.level = 1;
        this.maxHealth = 10;
        this.health = 10;
        this.maxMana = 10;
        this.mana = 5;
        this.attack = 2;
        this.defense = 2;
        this.speed = 2;
        this.reflex = 2;
        this.consumables = new ArrayList<>();
    }

    public Character(String name, int level, int maxHealth, int maxMana, int attack, int defense, int speed, int xp, int gold, int reflex) {
        this.xp = xp;
        this.gold = gold;
        this.name = name;
        this.level = level;
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

    @Override
    public boolean useItem() {
        if (consumables.isEmpty()){
            System.out.println("You're all out of consumables!");
            return false;
        }else{
            Random rand = new Random();
            consumables.get(rand.nextInt(consumables.size())).use();
            return true;
        }
    }

    public void levelUp(){
        while (this.getXp() >= (5 * this.level)) {
            this.setXp(this.getXp() - (5 * this.level));
            this.setLevel(this.getLevel() + 1);
            this.setMaxHealth(this.getMaxHealth() + 3);
            this.setHealth(this.getMaxHealth());
            this.setMaxMana(this.getMaxMana() + 2);
            this.setMana(this.getMaxMana());
            this.setAttack(this.getAttack() + 3);
            this.setDefense(this.getDefense() + 2);
            this.setSpeed(this.getSpeed() + 1);
            this.setReflex(this.getReflex() + 1);
        }
    }
}
