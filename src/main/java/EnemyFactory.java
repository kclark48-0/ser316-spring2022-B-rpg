package main.java;

public class EnemyFactory {
    Dungeon dungeon;
    public final double baseHealth = 5;
    public final double baseMana = 2;
    public final double baseAttack = 1;
    public final double baseDefense = 1;
    public final double baseSpeed = 1;
    public final double baseReflex = 1;
    public final int levelScaling = 4;

    public EnemyFactory(){
        dungeon = Dungeon.getInstance();
    }

    public Combatant createEnemy(){
        double scaling = 1;
        int dungeonFloor = dungeon.currentFloor;

        //TODO: add case for floor 100 FINAL BOSS
        if (dungeonFloor % 10 == 0){
            scaling = 2;
        }else if (dungeonFloor % 5 == 0){
            scaling = 1.5;
        }

        String name = "default";
        int level = 1;
        level += dungeonFloor / levelScaling;
        int maxHealth = (int) (baseHealth * level * scaling);
        int maxMana = (int) (baseMana * level * scaling);
        int attack = (int) (baseAttack * level * scaling);
        int defense = (int) (baseDefense * level * scaling);
        int speed = (int) (baseSpeed * level * scaling);
        int reflex = (int) (baseReflex * level * scaling);
        int lvl = (int) level;
        return new Enemy(name, lvl, maxHealth, maxMana, attack, defense, speed, reflex);
    }
}
