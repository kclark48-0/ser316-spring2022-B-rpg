package main.java;

import java.util.Random;

public class EnemyFactory {
    Dungeon dungeon;
    public final int baseXP = 5;
    public final int baseGold = 1;
    public final double baseHealth = 8;
    public final double baseMana = 2;
    public final double baseAttack = 3;
    public final double baseDefense = 1;
    public final double baseSpeed = 1;
    public final double baseReflex = 1;
    public final int levelScaling = 4;

    public EnemyFactory(){
        dungeon = Dungeon.getInstance();
    }

    public Combatant createEnemy(){
        int enemyType = new Random().nextInt(3);

        String name;

        if (dungeon.getScaling() == 3){
            name = "Archfiend ";
        }else if (dungeon.getScaling() == 2){
            name = "Elder ";
        }else if (dungeon.getScaling() == 1.5){
            name = "Greater ";
        }else{
            name = "Lesser ";
        }

        int level = 1;
        level += dungeon.getCurrentFloor() / levelScaling;
        double scaling = dungeon.getScaling();
        double experience = baseXP * level * scaling;
        double gold = baseGold * level * scaling;
        double maxHealth = baseHealth * level * scaling;
        double maxMana = baseMana * level * scaling;
        double attack = baseAttack * level * scaling;
        double defense = baseDefense * level * scaling;
        double speed = baseSpeed * level * scaling;
        double reflex = baseReflex * level * scaling;

        int xp;
        int g;
        int mHlth;
        int mMana;
        int atk;
        int def;
        int spd;
        int ref;

        switch (enemyType){
            case 0:
                name += "Hellhound";
                maxHealth *= 1.5;
                maxMana *= 0.5;
                attack *= 1.5;
                defense *= 0.75;
                break;
            case 1:
                name += "Ifrit";
                maxMana *= 1.5;
                speed *= 0.75;
                break;
            case 2:
                name += "Wraith";
                maxHealth *= 0.5;
                defense *= 0.5;
                speed *= 2;
                reflex *= 1.5;
                break;
        }

        xp = (int) experience;
        g = (int) gold;
        mHlth = (int) maxHealth;
        if (mHlth <= 0){
            mHlth = 1;
        }
        mMana = (int) maxMana;
        if (mMana <= 0){
            mMana = 1;
        }
        atk = (int) attack;
        def = (int) defense;
        spd = (int) speed;
        ref = (int) reflex;

        return new Enemy(name, level, xp, g, mHlth, mMana, atk, def, spd, ref);
    }
}
