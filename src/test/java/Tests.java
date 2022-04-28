package test.java;

import static org.junit.Assert.*;

import main.java.*;
import main.java.Character;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class Tests {

    Dungeon dungeon;
    EquipmentFactory forge;
    ConsumableFactory alchemist;
    EnemyFactory spawner;
    Character player;
    Character experiment;
    Enemy monster;


    @Before
    public void setUp() throws Exception {
        dungeon = main.java.Dungeon.getInstance();
        forge = new EquipmentFactory();
        alchemist = new ConsumableFactory();
        spawner = new EnemyFactory(alchemist);
        player = new Character();
    }

    @Test
    public void testLevelUpNoXp() {
        player.levelUp();
    }

    @Test
    public void testEnemyCreation() {
        monster = (Enemy) spawner.createEnemy();
    }

    @Test
    public void testCombatGauntlet() {
        for (int i = 0; i < 50; i++) {
            boolean victory = Main.combat(player, spawner);
            player.levelUp();
            player.setHealth(player.getMaxHealth());
            Main.getChest(player, forge, alchemist, dungeon);
            dungeon.setCurrentFloor(dungeon.getCurrentFloor() + 1);
        }
    }

    @Test
    public void testChestLooting() {
        for (int i = 0; i < 20; i++) {
            Main.getChest(player, forge, alchemist, dungeon);
        }
    }

    @Test
    public void testCustomCharacterConstructor() {
        experiment = new Character("Boba", 10, 40, 30, 40,
                30, 20, 150, 200, 20);
        System.out.println(experiment);
    }
}
