package main.java;

import java.util.Random;

public class EnemyFactory {
    Dungeon dungeon;
    ConsumableFactory alchemist;
    public static final int baseXp = 5;
    public static final int baseGold = 1;
    public static final double baseHealth = 7;
    public static final double baseMana = 2;
    public static final double baseAttack = 2;
    public static final double baseDefense = 1;
    public static final double baseSpeed = 1;
    public static final double baseReflex = 1;
    public static final int levelScaling = 4;

    public EnemyFactory(ConsumableFactory alchemist) {
        this.dungeon = Dungeon.getInstance();
        this.alchemist = alchemist;
    }

    /**
     * Creates a new Enemy of random type (Hellhound, Ifrit, or Wraith) scaled to the current level
     * of the dungeon.
     * @return new generated Enemy
     */
    public Combatant createEnemy() {
        int enemyType = new Random().nextInt(3);

        String name;

        if (dungeon.getScaling() == 3) {
            name = "Archfiend ";
        } else if (dungeon.getScaling() == 2) {
            name = "Elder ";
        } else if (dungeon.getScaling() == 1.5) {
            name = "Greater ";
        } else {
            name = "Lesser ";
        }

        /*REQUIREMENT: Enemies should get harder as you progress*/
        int level = 1;
        level += dungeon.getCurrentFloor() / levelScaling;
        double scaling = dungeon.getScaling();
        double experience = baseXp * level * scaling;
        double gold = baseGold * level * scaling;
        double maxHealth = baseHealth * level * scaling;
        double maxMana = baseMana * level * scaling;
        double attack = baseAttack * level * scaling;
        double defense = baseDefense * level * scaling;
        double speed = baseSpeed * level * scaling;
        double reflex = baseReflex * level * scaling;

        switch (enemyType) {
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

        int xp = (int) experience;
        int g = (int) gold;
        int mxHlth = (int) maxHealth;
        if (mxHlth <= 0) {
            mxHlth = 1;
        }
        int mxMana = (int) maxMana;
        if (mxMana <= 0) {
            mxMana = 1;
        }
        int atk = (int) attack;
        int def = (int) defense;
        int spd = (int) speed;
        int ref = (int) reflex;

        Enemy newEnemy = new Enemy(name, level, xp, g, mxHlth, mxMana, atk, def, spd, ref);
        //there's a 50% chance the new Enemy is generated with a Consumable to use.
        if (new Random().nextInt(10) > 4) {
            newEnemy.getConsumables().add(alchemist.createConsumable());
        }
        return newEnemy;
    }
}
