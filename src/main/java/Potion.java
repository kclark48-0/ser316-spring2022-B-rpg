package main.java;

public class Potion implements Consumable {

    private String name;
    private int power;

    public Potion(String name, int power) {
        this.name = name;
        this.power = power;
    }

    /**
     * Heals the Entity it is used on for the Potion's power, up to the Entity's maximum health.
     * @param target the Entity to be healed by the potion.
     */
    public void useOn(Entity target) {
        if (target.getMaxHealth() - target.getHealth() < power) {
            target.setHealth(target.getMaxHealth());
        } else {
            target.setHealth(target.getHealth() + power);
        }
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
}
