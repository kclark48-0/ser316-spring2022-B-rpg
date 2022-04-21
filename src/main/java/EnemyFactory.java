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

    public Combatant createEnemy(String type){
        double scaling = 1;
        switch (type) {
            case "mob":
                break;
            case "miniboss":
                scaling = 1.5;
                break;
            case "boss":
                scaling = 2;
                break;
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
