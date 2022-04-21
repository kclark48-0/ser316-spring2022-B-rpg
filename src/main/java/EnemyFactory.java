public class EnemyFactory {
    Dungeon dungeon;
    public final double baseHealth = 5;
    public final double baseMana = 2;
    public final double baseAttack = 1;
    public final double baseDefense = 1;
    public final double baseSpeed = 1;
    public final double baseReflex = 1;
    public final double levelScaling = 5;

    public EnemyFactory(){
        dungeon = Dungeon.getInstance();
    }

    public Combatant createEnemy(){
        double scaling = 0;
        int dungeonFloor = dungeon.currentFloor;

        if (dungeonFloor % 10 == 0){
            scaling = 2;
        }else if (dungeonFloor % 5 == 0){
            scaling = 1.5;
        }else{
            scaling = 1;
        }

        String name = "default";
        int level = (int) (dungeon.currentFloor/levelScaling);
        int maxHealth = (int) (baseHealth * level * scaling);
        int maxMana = (int) (baseMana * level);
        int attack = (int) (baseAttack * level);
        int defense = (int) (baseDefense * level);
        int speed = (int) (baseSpeed * level);
        int reflex = (int) (baseReflex * level);
        return new Enemy(name, level, maxHealth, maxMana, attack, defense, speed, reflex);
    }
}
