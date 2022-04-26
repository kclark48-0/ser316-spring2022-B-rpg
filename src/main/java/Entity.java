package main.java;

import java.util.ArrayList;
import java.util.Random;

public abstract class Entity implements Combatant  {

    protected String name;
    protected int xp;
    protected int level;
    protected int health;
    protected int maxHealth;
    protected int mana;
    protected int maxMana;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int reflex;
    protected int gold;
    protected ArrayList<Consumable> consumables;

    @Override
    public void attack(Entity target){
        Random rand = new Random();
        if ((1 + rand.nextInt(10) + (this.speed - target.reflex)) > 3){
            int damage = 1 + rand.nextInt(2) + this.attack;
            if (damage - target.defense <= 0){
                target.health -= 1;
            }else{
                target.health -= damage;
            }
        }
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\n" +
                "Level: " + this.level + "\n" +
                "XP: " + this.level + "\n" +
                "Gold: " + this.level + "\n" +
                "Max Health: " + this.maxHealth + "\n" +
                "Max Mana: " + this.maxMana + "\n" +
                "Attack: " + this.attack + "\n" +
                "Defense: " + this.defense + "\n" +
                "Speed: " + this.speed + "\n" +
                "Reflex: " + this.reflex + "\n";
    }
}
