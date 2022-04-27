package main.java;

public class Potion implements Consumable {

    private String name;
    private int power;

    public Potion(String name, int power, Entity owner){
        this.name = name;
        this.power = power;
    }

    public void useOn(Entity target){
        if (target.getMaxHealth() - target.getHealth() < power){
            target.setHealth(target.getMaxHealth());
        }else{
            target.setHealth(target.getHealth() + power);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
