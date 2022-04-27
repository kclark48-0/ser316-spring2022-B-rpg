public class Potion implements Consumable {

    private String name;
    private int power;

    public Potion(String name, int power, Entity owner){
        this.name = name;
        this.power = power;
    }

    public void consume(Entity target){
        if (target.getMaxHealth() - target.getHealth() < power){
            target.setHealth(target.getMaxHealth);
        }else{
            target.setHealth(target.getHealth() + power);
        }
    }
}
