package main.java;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Dungeon!");
        Dungeon dungeon = Dungeon.getInstance();
        ConsumableFactory alchemist = new ConsumableFactory();
        EnemyFactory spawner = new EnemyFactory(alchemist);
        EquipmentFactory forge = new EquipmentFactory();
        Character pc = new Character();
        boolean victory = true;
        int tries = 1;

        while (dungeon.getCurrentFloor() < 100){
            //System.out.println("\nCurrent dungeon floor: " + dungeon.getCurrentFloor());
            victory = combat(pc, spawner);
            if (victory){
                dungeon.setFurthestFloorReached(dungeon.getCurrentFloor());
                dungeon.setCurrentFloor(dungeon.getCurrentFloor()+1);
                getChest(pc, forge, alchemist, dungeon);
                if (pc.health < (int)(0.15 * pc.maxHealth)){
                    pc.health = Integer.valueOf(pc.maxHealth);
                    pc.levelUp();
                }
            }else{
                System.out.println("\nPlayer lost at " + pc.health + " health.");
                pc.setGold(pc.getGold() - (int)(pc.getGold() * 0.1));
                pc.health = Integer.valueOf(pc.maxHealth);
                pc.levelUp();
                tries++;
            }

        }
        pc.health = Integer.valueOf(pc.maxHealth);
        pc.levelUp();
        System.out.println(pc);
        System.out.println("\nReached Floor 99 in " + tries + " tries.");
        victory = combat(pc, spawner);
        if (victory){
            System.out.println("\nYou Win!!!");
        }else{
            System.out.println("\nYou Lose!!!");
        }
    }

    public static boolean combat(Character player, EnemyFactory spawner){
        Enemy opponent = (Enemy) spawner.createEnemy();
        //System.out.println(player);
        //System.out.println(opponent);
        boolean over = false;
        boolean win = false;
        while (!over){
            //System.out.println(opponent.getName() + " health: " + opponent.getHealth());
            //System.out.println("Player health: " + player.getHealth());
            if (player.getSpeed() >= opponent.getSpeed()){
                player.attack(opponent);
                System.out.println(opponent.name + " health: " + opponent.health);
                if (opponent.getHealth() <= 0){
                    player.setXp(player.getXp() + opponent.getXp());
                    player.setGold(player.getGold() + opponent.getGold());
                    win = true;
                    over = true;
                    break;
                }
                opponent.attack(player);
                System.out.println(player.name + " health: " + player.health);
                if(player.getHealth() <= 0){
                    over = true;
                    break;
                }
            }else{
                opponent.attack(player);
                System.out.println(opponent.name + " health: " + opponent.health);
                if(player.getHealth() <= 0){
                    over = true;
                    break;
                }
                player.attack(opponent);
                System.out.println(player.name + " health: " + player.health);
                if (opponent.getHealth() <= 0){
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

    public static void getChest(Character player, EquipmentFactory forge, ConsumableFactory alchemist, Dungeon dungeon){
        Random rand = new Random();
        if (rand.nextInt(10) + (dungeon.getScaling() * 2) > 9){ //20% chance of a chest spawning each floor,
            int numItems = (int)(2 * dungeon.getScaling());            //30% chance each miniboss floor,
            for (int i = 0; i < numItems; i++){                        //40% chance each midboss floor
                if (rand.nextInt(2) == 0){
                    Equipment newEquip = forge.createEquipment();
                    newEquip.equip(player);
                }else{
                    Consumable newConsumable = alchemist.createConsumable();
                    player.getConsumables().add(newConsumable);
                }

            }
            System.out.println("\nCurrent dungeon floor: " + dungeon.getCurrentFloor());
            System.out.println(player);
        }
    }
}
