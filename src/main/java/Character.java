import java.util.ArrayList;
import java.util.Random;

public class Character extends Entity implements Combatant {

    private String path;
    private String race;
    private Equipment armor;
    private Equipment weapon;
    private Equipment

    public Character() {
        this.name = "defaultChar";
        this.level = 1;
        this.health = 10;
        this.mana = 10;
        this.attack = 2;
        this.defense = 2;
        this.speed = 2;
        this.consumables = new ArrayList<>();
    }

    public Character(String name, int level, int health, int mana, int attack, int defense, int speed) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.consumables = new ArrayList<>();
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
}
