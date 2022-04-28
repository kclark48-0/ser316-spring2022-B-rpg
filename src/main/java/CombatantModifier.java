package main.java;

public abstract class CombatantModifier implements Combatant {
    private Combatant modifiedCombatant;

    public CombatantModifier(Combatant modifiedCombatant) {
        this.modifiedCombatant = modifiedCombatant;
    }

    public void attack(Entity target) {
        modifiedCombatant.attack(target);
    }
}
