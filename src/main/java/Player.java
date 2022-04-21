import java.util.ArrayList;
import java.util.Random;

/**
 * A Singleton representing the player character, which will need to be accessed throughout the program.
 */
public class Player extends Entity implements Combatant {

    private static Player instance;

    private String path;
    private String race;
    private Equipment armor;
    private Equipment weapon;
    private Equipment enchant;

    private Player() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        this.name = "defaultChar";
        this.level = 1;
        this.health = 10;
        this.mana = 10;
        this.attack = 2;
        this.defense = 2;
        this.speed = 2;
        this.consumables = new ArrayList<>();
    }

    private Player(String name, int level, int health, int mana, int attack, int defense, int speed) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        this.name = name;
        this.level = level;
        this.health = health;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.consumables = new ArrayList<>();
    }

    public static Player getInstance(){
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public static Player getInstance(String name, int level, int health, int mana, int attack, int defense, int speed){
        if (instance == null) {
            instance = new Player(name, level, health, mana, attack, defense, speed);
        }
        return instance;
    }

    @Override
    public boolean useItem() {
        if (consumables.isEmpty()){
            System.out.println("You're all out of consumables!");
            return false;
        }else{
            Random rand = new Random();
            consumables.get(rand.nextInt(consumables.size())).use();
            return true;
        }
    }

    @Override
    public void attack(Entity target){
        Random rand = new Random();
        if (1 + rand.nextInt(10) > 2 + target.speed){
            int damage = 1 + rand.nextInt(3) + this.attack;
            if (damage - target.defense <= 0){
                target.health -= 1;
            }else{
                target.health -= damage;
            }
        }
    }
}
