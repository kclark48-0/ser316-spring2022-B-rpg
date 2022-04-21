package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Entity implements Combatant {

    public Enemy() {
        this.name = "defaultEnemy";
        this.level = 1;
        this.maxHealth = 5;
        this.health = 5;
        this.maxMana = 2;
        this.mana = 2;
        this.attack = 1;
        this.defense = 1;
        this.speed = 1;
        this.reflex = 1;
        this.consumables = new ArrayList<>();
    }

    public Enemy(String name, int level, int maxHealth, int maxMana, int attack, int defense, int speed, int reflex) {
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.maxMana = maxMana;
        this.mana = maxMana;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.reflex = reflex;
        this.consumables = new ArrayList<>();
    }

    @Override
    public boolean useItem() {
        if (consumables.isEmpty()){
            System.out.println(name + " is all out of consumables!");
            return false;
        }else{
            Random rand = new Random();
            consumables.get(rand.nextInt(consumables.size())).use();
            return true;
        }
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\n" +
                "Level: " + this.level + "\n" +
                "Max Health: " + this.maxHealth + "\n" +
                "Max Mana: " + this.maxMana + "\n" +
                "Attack: " + this.attack + "\n" +
                "Defense: " + this.defense + "\n" +
                "Speed: " + this.speed + "\n" +
                "Reflex: " + this.reflex + "\n";
    }
}
