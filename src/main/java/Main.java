package main.java;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Dungeon!");
        Dungeon dungeon = Dungeon.getInstance();
        System.out.println("Current dungeon floor: " + dungeon.getCurrentFloor());
        EnemyFactory spawner = new EnemyFactory();
        Character pc = new Character();
        boolean victory = combat(pc, spawner);
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
        boolean over = false;
        boolean win = false;
        while (!over){
            if (player.speed >= opponent.speed){
                player.attack(opponent);
                System.out.println(opponent.name + " health: " + opponent.health);
                if (opponent.health <= 0){
                    win = true;
                    over = true;
                    break;
                }
                opponent.attack(player);
                System.out.println(player.name + " health: " + player.health);
                if(player.health <= 0){
                    over = true;
                    break;
                }
            }else{
                opponent.attack(player);
                System.out.println(opponent.name + " health: " + opponent.health);
                if(player.health <= 0){
                    over = true;
                    break;
                }
                player.attack(opponent);
                System.out.println(player.name + " health: " + player.health);
                if (opponent.health <= 0){
                    win = true;
                    over = true;
                    break;
                }
            }
        }
        return win;
    }
}
