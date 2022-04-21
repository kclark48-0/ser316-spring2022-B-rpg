public class EnemyFactory {
    Dungeon dungeon;

    public EnemyFactory(){
        dungeon = Dungeon.getInstance();
    }

    public Combatant createEnemy(String type){
        double scaling;
        switch (type) {
            case "mob":
                scaling = 1;
                break;
            case "miniboss":
                scaling = 1.5;
                break;
            case "boss":
                scaling = 2;
                break;
        }
        String name = "default";
        int level = dungeon.currentFloor/5;

        Enemy newEnemy = new Enemy("default", dungeon.currentFloor/5, );
    }
}
