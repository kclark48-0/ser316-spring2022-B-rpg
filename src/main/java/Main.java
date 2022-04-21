package main.java;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Dungeon!");
        Dungeon dungeon = Dungeon.getInstance();
        System.out.println("Current dungeon floor: " + dungeon.currentFloor);
        EnemyFactory spawner = new EnemyFactory();
        Enemy baseGobbo = (Enemy) spawner.createEnemy();
        System.out.println(baseGobbo.toString());

        dungeon.currentFloor = 3;
        Enemy gobbo3 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo3.toString());

        dungeon.currentFloor = 5;
        Enemy gobbo5 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo5.toString());

        dungeon.currentFloor = 6;
        Enemy gobbo6 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo6.toString());

        dungeon.currentFloor = 9;
        Enemy gobbo9 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo9.toString());

        dungeon.currentFloor = 10;
        Enemy gobbo10 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo10.toString());

        dungeon.currentFloor = 12;
        Enemy gobbo12 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo12.toString());

        dungeon.currentFloor = 15;
        Enemy gobbo15 = (Enemy) spawner.createEnemy();
        System.out.println(gobbo15.toString());
    }
}
