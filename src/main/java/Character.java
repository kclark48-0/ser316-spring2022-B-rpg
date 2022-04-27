package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Character extends Entity implements Combatant {

    private String path;
    private String race;
    private Armor armor;
    private Weapon weapon;
    private Glowstone glowStone;

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

    public void levelUp(){
        while (this.getXp() >= (5 * this.level)) {
            this.setXp(this.getXp() - (5 * this.level));
            this.setLevel(this.getLevel() + 1);
            this.setMaxHealth(this.getMaxHealth() + 3);
            this.setHealth(this.getMaxHealth());
            this.setMaxMana(this.getMaxMana() + 2);
            this.setMana(this.getMaxMana());
            if (this.getWeapon() == null){
                this.setAttack(this.getAttack() + 3);
            }else{
                this.setAttack(this.getAttack() - this.getWeapon().getBoost());
                this.setAttack(this.getAttack() + 3);
                this.getWeapon().setBoost((int)(this.getWeapon().getMultiplier() * this.getAttack()));
                this.setAttack(this.getAttack() + this.getWeapon().getBoost());
            }

            if (this.getArmor() == null){
                this.setDefense(this.getDefense() + 2);
            }else{
                this.setDefense(this.getDefense() - this.getArmor().getBoost());
                this.setDefense(this.getDefense() + 2);
                this.getArmor().setBoost((int)(this.getArmor().getMultiplier() * this.getDefense()));
                this.setDefense(this.getDefense() + this.getArmor().getBoost());
            }

            this.setSpeed(this.getSpeed() + 1);

            if (this.getGlowstone() == null){
                this.setReflex(this.getReflex() + 1);
            }else{
                this.setReflex(this.getReflex() - this.getGlowstone().getBoost());
                this.setReflex(this.getReflex() + 1);
                this.getGlowstone().setBoost((int)(this.getWeapon().getMultiplier() * this.getReflex()));
                this.setReflex(this.getReflex() + this.getGlowstone().getBoost());
            }
        }
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Glowstone getGlowstone() {
        return glowStone;
    }

    public void setGlowstone(Glowstone glowStone) {
        this.glowStone = glowStone;
    }
}
