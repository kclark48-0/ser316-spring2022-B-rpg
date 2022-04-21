import java.util.ArrayList;
import java.util.Random;

public class Character extends Entity implements Combatant {

    private int xp;
    private String path;
    private String race;
    private Equipment armor;
    private Equipment weapon;
    private Equipment enchant;

    public Character() {
        this.xp = 0;
        this.name = "defaultChar";
        this.level = 1;
        this.health = 10;
        this.mana = 5;
        this.attack = 2;
        this.defense = 2;
        this.speed = 2;
        this.consumables = new ArrayList<>();
    }

    public Character(String name, int level, int health, int mana, int attack, int defense, int speed, int xp) {
        this.xp = xp;
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

    public void levelUp(){
        this.level += 1;
        this.health += 2;
        this.mana += 1;
        this.attack += 1;
        this.defense += 1;
        if (this.level % 2 != 0){
            this.speed += 1;
        }
    }
}
