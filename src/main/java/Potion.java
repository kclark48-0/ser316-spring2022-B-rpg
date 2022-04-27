public class Potion implements Consumable {

    private String name;
    private int power;
    private Entity owner;

    public Potion(String name, int power, Entity owner){
        this.name = name;
        this.power = power;
        this.owner = owner;
    }

    public void consume(){
        if (owner.getMaxHealth() - owner.getHealth() < power){
            owner.setHealth(owner.getMaxHealth);
        }else{
            owner.setHealth(owner.getHealth() + power);
        }
    }
}
