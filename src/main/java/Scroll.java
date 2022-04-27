package main.java;

public class Scroll implements Consumable{

    private String name;
    private int power;

    public Scroll(String name, int power){
        this.name = name;
        this.power = power;
    }

    public void useOn(Entity target){
        target.setHealth(target.getHealth() - power);
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
