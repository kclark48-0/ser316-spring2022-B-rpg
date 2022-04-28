package main.java;

import java.util.Random;

public class ConsumableFactory {

    Dungeon dungeon;
    public double basePower = 5;
    public static final int levelScaling = 6;

    public ConsumableFactory() {
        dungeon = Dungeon.getInstance();
    }

    /**
     * Creates a new Consumable of random type (Potion or Scroll) scaled to the current level of
     * the dungeon.
     * @return new generated Consumable
     */
    public Consumable createConsumable() {

        String name;
        double scaling = dungeon.getScaling();

        if (scaling == 2) {
            name = "Eldritch ";
        } else if (scaling == 1.5) {
            name = "Arcane ";
        } else {
            name = "";
        }

        int level = 1;
        level += dungeon.getCurrentFloor() / levelScaling;
        int power = (int) (level * basePower);

        //System.out.println("\n***Power of new Consumable is " + power + "***\n");

        Consumable newConsumable = null;

        switch (new Random().nextInt(2)) {
            case 0:
                name += "Potion";
                newConsumable = new Potion(name, power);
                break;
            case 1:
                name += "Scroll";
                newConsumable = new Scroll(name, power);
                break;
        }

        return newConsumable;
    }
}
