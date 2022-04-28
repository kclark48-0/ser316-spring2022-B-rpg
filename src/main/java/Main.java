package main.java;

import java.util.Random;

/**
 * Class implementing the "game loop" simulation of the dungeon crawling game.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Dungeon!");
        Dungeon dungeon = Dungeon.getInstance();
        ConsumableFactory alchemist = new ConsumableFactory();
        EnemyFactory spawner = new EnemyFactory(alchemist);
        EquipmentFactory forge = new EquipmentFactory();
        Character pc = new Character();
        boolean victory = true;
        int tries = 1;

        while (dungeon.getCurrentFloor() < 100) {
            System.out.println("\nCurrent dungeon floor: " + dungeon.getCurrentFloor());
            victory = combat(pc, spawner);
            if (victory) {
                dungeon.setCurrentFloor(dungeon.getCurrentFloor() + 1);
                getChest(pc, forge, alchemist, dungeon);
                if (pc.getHealth() < (int) (0.15 * pc.getMaxHealth())) {
                    System.out.println("\nReturned to surface to heal and level.");
                    pc.setHealth(pc.getMaxHealth());
                    pc.levelUp();
                }
            } else {
                System.out.println("\nPlayer lost at " + pc.health + " health. Returning to surface"
                        + " to heal and level");
                pc.setGold(pc.getGold() - (int) (pc.getGold() * 0.1));
                pc.setHealth(pc.getMaxHealth());
                pc.levelUp();
                tries++;
            }

        }
        pc.health = Integer.valueOf(pc.maxHealth);
        pc.levelUp();
        System.out.println("\nCharacter's status going into the Final Boss fight:");
        System.out.println(pc);
        System.out.println("\nReached Floor 99 in " + tries + " tries.\n");
        victory = combat(pc, spawner);
        if (victory) {
            System.out.println("\nYou've conquered the dungeon!!!");
        } else {
            System.out.println("\nYou lost and you're dead!!!");
        }
    }

    /**
     * Simulates a turn by turn combat between the player's Character and a single Enemy.
     * Returns a boolean representing whether the Character won the combat.
     * @param player the Character navigating the dungeon
     * @param spawner the EnemyFactory used to create opponents
     * @return boolean representing the Character's victory or loss
     */
    public static boolean combat(Character player, EnemyFactory spawner) {
        Enemy opponent = (Enemy) spawner.createEnemy();
        System.out.println("You are fighting "  + opponent.getName() + " (" + opponent.getHealth()
                + " HP)");
        boolean over = false;
        boolean win = false;
        while (!over) {
            if (player.getSpeed() >= opponent.getSpeed()) {
                player.attack(opponent);
                System.out.println("Player attacks! "  + opponent.getName() + " is at "
                        + opponent.getHealth() + " HP");
                if (opponent.getHealth() <= 0) {
                    player.setXp(player.getXp() + opponent.getXp());
                    player.setGold(player.getGold() + opponent.getGold());
                    win = true;
                    over = true;
                    break;
                }
                opponent.attack(player);
                System.out.println(opponent.getName() + " attacks! Player is at "
                        + player.getHealth() + " HP");
                System.out.println(player.name + " health: " + player.health);
                if (player.getHealth() <= 0) {
                    over = true;
                    break;
                }
            } else {
                opponent.attack(player);
                System.out.println(opponent.getName() + " attacks! Player is at "
                        + player.getHealth() + " HP");
                System.out.println(opponent.name + " health: " + opponent.health);
                if (player.getHealth() <= 0) {
                    over = true;
                    break;
                }
                player.attack(opponent);
                System.out.println("Player attacks! "  + opponent.getName() + " is at "
                        + opponent.getHealth() + " HP");
                if (opponent.getHealth() <= 0) {
                    player.setXp(player.getXp() + opponent.getXp());
                    player.setGold(player.getGold() + opponent.getGold());
                    win = true;
                    over = true;
                    break;
                }
            }
        }
        return win;
    }

    /**
     * Method for determining if a chest spawns after a successful combat, and what it contains.
     * The number of items and their quality scale with the dungeon level and enemy difficulty.
     * There is a 20% chance a chest spawns on a normal level, a 30% chance on a miniboss level,
     * and a 40% chance on a midboss level.
     * @param player the Character which will receive the items from the chest
     * @param forge the Equipment factory generating the equipment items in the chest
     * @param alchemist the Consumable factory generating the consumable items in the chest
     * @param dungeon the instance of the Dungeon singleton
     */
    public static void getChest(Character player, EquipmentFactory forge,
                                ConsumableFactory alchemist, Dungeon dungeon) {
        Random rand = new Random();
        if (rand.nextInt(10) + (dungeon.getScaling() * 2) > 9) {
            int numItems = (int) (2 * dungeon.getScaling());
            for (int i = 0; i < numItems; i++) {
                if (rand.nextInt(2) == 0) {
                    Equipment newEquip = forge.createEquipment();
                    newEquip.equip(player);
                } else {
                    Consumable newConsumable = alchemist.createConsumable();
                    player.getConsumables().add(newConsumable);
                }

            }
        }
    }
}
