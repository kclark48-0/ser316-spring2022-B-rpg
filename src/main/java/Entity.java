package main.java;

import java.util.ArrayList;
import java.util.Random;

/**
 * Parent class for both Character and Enemy to store basic stats and behavior.
 */
public class Entity implements Combatant {

    /*REQUIREMENT: Character should have stats (mana not currently used)*/
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

    /**
     * Method implementing basic attack and combat item use behaviors. There is a 20% chance the
     * Entity will try to use a Consumable, and an 80% chance they will try a basic attack. Basic
     * attacks have a 60% chance to hit, modified by the ratio of the attacker's speed to the
     * defender's reflex. Attacks that hit the target deal a minimum of 1 damage, even if they are
     * completely absorbed by the targets armor. Attacks rolled with a perfect 10 to hit deal double
     * damage.
     * @param target an Entity which will be the opponent for the combat
     */
    public void attack(Entity target) {
        Random rand = new Random();

        /*REQUIREMENT: Combatant can either attack or use consumable item*/
        if (rand.nextInt(10) > 7) {
            if (useConsumable(target)) {
                return;
            }
        }

        int minimum;
        double dblSpeed = (double) this.getSpeed();
        double dblReflex = (double) target.getReflex();
        double ratio = dblSpeed / dblReflex;
        if (ratio >= 2) {
            minimum = 2;
        } else if (ratio > 1) {
            minimum = 3;
        } else if (ratio == 1) {
            minimum = 4;
        } else if (ratio > 0.5) {
            minimum = 5;
        } else {
            minimum = 6;
        }

        int accuracy = 1 + rand.nextInt(10);

        /*REQUIREMENT: All attacks should have a chance to miss*/
        if (accuracy >= minimum) {
            int damage = 1 + rand.nextInt(3) + this.attack;

            /*REQUIREMENT: Attacks should have a chance to critically strike for double damage*/
            if (accuracy == 10) {
                damage *= 2;
            }

            /*REQUIREMENT: Attacks should deal a minimum of 1 damage*/
            if (damage - target.getDefense() <= 0) {
                target.setHealth(target.getHealth() - 1);
            } else {
                target.setHealth(target.getHealth() - (damage - target.getDefense()));
            }
        }
    }

    /**
     * Attempts to use a random Consumable in the Entity's inventory. If Entity does not have any,
     * or the selected consumable is too weak to justify using a turn on it, the method returns
     * false to indicate that the Entity should perform an attack instead.
     * @param opponent the opponent Entity this Entity is currently in combat with
     * @return boolean representing whether a consumable was used
     */
    public boolean useConsumable(Entity opponent) {
        if (consumables.isEmpty()) {
            System.out.println(name + " is all out of consumables!");
        } else {
            int idx = new Random().nextInt(consumables.size());
            Consumable randomConsumable = consumables.get(idx);
            if (randomConsumable.getPower() >= (int) (0.10 * this.getMaxHealth())) {
                if (randomConsumable instanceof Potion) {
                    randomConsumable.useOn(this);
                    System.out.println(name + " used " + randomConsumable.getName()
                            + " and healed for " + randomConsumable.getPower() + "!");
                } else if (randomConsumable instanceof Scroll) {
                    randomConsumable.useOn(opponent);
                    System.out.println(name + " blasted " + opponent.getName() + " with "
                            + randomConsumable.getName() + " for " + randomConsumable.getPower()
                            + "!");
                }
                consumables.remove(idx);
                return true;
            } else {
                consumables.remove(idx);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\n"
                + "Level: " + this.getLevel() + "\n"
                + "XP: " + this.getXp() + "\n"
                + "Gold: " + this.getGold() + "\n"
                + "Max Health: " + this.getMaxHealth() + "\n"
                + "Health: " + this.getHealth() + "\n"
                + "Max Mana: " + this.getMaxMana() + "\n"
                + "Mana: " + this.getMana() + "\n"
                + "Attack: " + this.getAttack() + "\n"
                + "Defense: " + this.getDefense() + "\n"
                + "Speed: " + this.getSpeed() + "\n"
                + "Reflex: " + this.getReflex() + "\n";
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
