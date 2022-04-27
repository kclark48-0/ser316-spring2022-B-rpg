package main.java;

/**
 * Common interface for any "living" entities, both player characters and enemies.
 */
public interface Combatant {
    public void attack(Entity target);
    public boolean useConsumable();
}
