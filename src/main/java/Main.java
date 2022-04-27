package main.java;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Dungeon!");
        Dungeon dungeon = Dungeon.getInstance();
        EnemyFactory spawner = new EnemyFactory();
        for (int i = 0; i < 100; i++){
            Character pc = new Character();
            dungeon.setCurrentFloor(1);
            dungeon.setFurthestFloorReached(1);
            boolean victory = true;
            int tries = 1;

            while (dungeon.getCurrentFloor() < 100){
                //System.out.println("\nCurrent dungeon floor: " + dungeon.getCurrentFloor());
                victory = combat(pc, spawner);
                if (victory){
                    dungeon.setFurthestFloorReached(dungeon.getCurrentFloor());
                    dungeon.setCurrentFloor(dungeon.getCurrentFloor()+1);
                    if (pc.health < (int)(0.15 * pc.maxHealth)){
                        pc.health = Integer.valueOf(pc.maxHealth);
                        pc.levelUp();
                    }
                }else{
                    //System.out.println("\nPlayer lost at " + pc.health + " health.");
                    pc.health = Integer.valueOf(pc.maxHealth);
                    pc.levelUp();
                    tries++;
                }

            }
            pc.health = Integer.valueOf(pc.maxHealth);
            pc.levelUp();
            System.out.println("\nReached Floor 99 in " + tries + " tries.");
            victory = combat(pc, spawner);
            if (victory){
                System.out.println(pc);
                System.out.println("\nYou Win!!!");
            }
        }

        /*
        Enemy baseGobbo = (Enemy) spawner.createEnemy();
        System.out.println(baseGobbo.toString());

        dungeon.setCurrentFloor(3);
        Enemy gobbo3 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo3.toString());

        dungeon.setCurrentFloor(5);
        Enemy gobbo5 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo5.toString());

        dungeon.setCurrentFloor(6);
        Enemy gobbo6 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo6.toString());

        dungeon.setCurrentFloor(9);
        Enemy gobbo9 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo9.toString());

        dungeon.setCurrentFloor(10);
        Enemy gobbo10 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo10.toString());

        dungeon.setCurrentFloor(12);
        Enemy gobbo12 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo12.toString());

        dungeon.setCurrentFloor(15);
        Enemy gobbo15 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo15.toString());
        */
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
                //System.out.println(opponent.name + " health: " + opponent.health);
                if (opponent.getHealth() <= 0){
                    player.setXp(player.getXp() + opponent.getXp());
                    player.setGold(player.getGold() + opponent.getGold());
                    win = true;
                    over = true;
                    break;
                }
                opponent.attack(player);
                //System.out.println(player.name + " health: " + player.health);
                if(player.getHealth() <= 0){
                    over = true;
                    break;
                }
            }else{
                opponent.attack(player);
                //System.out.println(opponent.name + " health: " + opponent.health);
                if(player.getHealth() <= 0){
                    over = true;
                    break;
                }
                player.attack(opponent);
                //System.out.println(player.name + " health: " + player.health);
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
}
