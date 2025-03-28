package main.java;

public class Scroll implements Consumable {

    private String name;
    private int power;

    public Scroll(String name, int power) {
        this.name = name;
        this.power = power;
    }

    /**
     * Scrolls deal damage directly to the target with no chance of missing, and no damage reduction
     * from the target's defense.
     * @param target the Entity targeted by the Scroll
     */
    public void useOn(Entity target) {
        target.setHealth(target.getHealth() - power);
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

}
