import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Entity implements Combatant {

    public Enemy() {
        this.name = "defaultEnemy";
        this.level = 1;
        this.health = 5;
        this.mana = 2;
        this.attack = 1;
        this.defense = 1;
        this.speed = 1;
        this.consumables = new ArrayList<>();
    }

    public Enemy(String name, int level, int health, int mana, int attack, int defense, int speed) {
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
            System.out.println(name + " is all out of consumables!");
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
        if (1 + rand.nextInt(10) > 3 + target.speed){
            int damage = 1 + rand.nextInt(2) + this.attack;
            if (damage - target.defense <= 0){
                target.health -= 1;
            }else{
                target.health -= damage;
            }
        }
    }
}
