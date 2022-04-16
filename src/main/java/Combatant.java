/**
 * Common interface for any "living" entities, both player characters and enemies.
 */
public interface Combatant {
    public void attack();
    public boolean useItem();
}
