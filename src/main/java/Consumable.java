package main.java;

public interface Consumable {
    String getName();

    int getPower();

    void useOn(Entity target);
}
