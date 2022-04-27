package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Entity implements Combatant  {

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

    public void attack(Entity target){
        Random rand = new Random();

        if (rand.nextInt(10) > 7){
            if (useConsumable(target)){
                return;
            }
        }

        int minimum;
        double dblSpeed = (double) this.getSpeed();
        double dblReflex = (double) target.getReflex();
        int ratio = this.getSpeed() / target.getReflex();
        if (ratio >= 2){
            minimum = 2;
        }else if (ratio > 1){
            minimum = 3;
        }else if (ratio == 1){
            minimum = 4;
        }else if (ratio > 0.5){
            minimum = 5;
        }else{
            minimum = 6;
        }

        int accuracy = 1 + rand.nextInt(10);

        if (accuracy >= minimum){
            int damage = 1 + rand.nextInt(3) + this.attack;
            if (accuracy == 10){ damage *= 2; }
            if (damage - target.getDefense() <= 0){
                target.setHealth(target.getHealth() - 1);
            }else{
                target.setHealth(target.getHealth() - (damage - target.getDefense()));
            }
        }
    }

    public boolean useConsumable(Entity opponent) {
        if (consumables.isEmpty()){
            System.out.println(name + " is all out of consumables!");
        }else{
            int idx = new Random().nextInt(consumables.size());
            Consumable randomConsumable = consumables.get(idx);
            if (randomConsumable.getPower() >= (int)(0.10 * this.getMaxHealth())){
                if (randomConsumable instanceof Potion){
                    randomConsumable.useOn(this);
                    System.out.println(name + " used " + randomConsumable.getName() + " and healed for "
                            + randomConsumable.getPower() + "!");
                }else if (randomConsumable instanceof Scroll){
                    randomConsumable.useOn(opponent);
                    System.out.println(name + " blasted " + opponent.getName() + " with " + randomConsumable.getName()
                            + " for " + randomConsumable.getPower() + "!");
                }
                consumables.remove(idx);
                return true;
            }else{
                consumables.remove(idx);
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "Name: " + this.getName() + "\n" +
                "Level: " + this.getLevel() + "\n" +
                "XP: " + this.getXp() + "\n" +
                "Gold: " + this.getGold() + "\n" +
                "Max Health: " + this.getMaxHealth() + "\n" +
                "Health: " + this.getHealth() + "\n" +
                "Max Mana: " + this.getMaxMana() + "\n" +
                "Mana: " + this.getMana() + "\n" +
                "Attack: " + this.getAttack() + "\n" +
                "Defense: " + this.getDefense() + "\n" +
                "Speed: " + this.getSpeed() + "\n" +
                "Reflex: " + this.getReflex() + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getReflex() {
        return reflex;
    }

    public void setReflex(int reflex) {
        this.reflex = reflex;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public ArrayList<Consumable> getConsumables() {
        return consumables;
    }
}
