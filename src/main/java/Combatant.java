package main.java;

/**
 * Common interface for any "living" entities, both player characters and enemies.
 */
public interface Combatant {
    void attack(Entity target);

    boolean useConsumable(Entity opponent);
}
