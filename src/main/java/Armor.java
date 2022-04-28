package main.java;

/**
 * Class which implements the Equipment interface and increases the defense of the Character using
 * it. Adds a defense bonus from 0.04 to 1 times the Character's base defense.
 */
public class Armor implements Equipment {

    private String name;
    private double multiplier;
    private int boost;

    /**
     * Default constructor.
     * @param name String representing the quality of the item
     * @param multiplier double used to calculate the amount of the Character's base stat to add
     */
    public Armor(String name, double multiplier) {
        this.name = name;
        this.multiplier = multiplier;
        this.boost = 0;
    }

    /**
     * Checks to see if the equipping Character alreadys has an Equipment item int the same slot.
     * If not, this is equipped by default. If so, the multipliers of this item and the current item
     * are compared. If this has the higher multiplier, it is equipped, otherwise it is converted
     * to a gold amount based on its multiplier.
     * @param player the Charater equipping this item
     */
    public void equip(Character player) {
        if (player.getArmor() == null) {
            player.setArmor(this);
            boost = (int) (multiplier * player.getDefense());
            if (boost < 1) {
                boost = 1;
            }
            player.setDefense(player.getDefense() + boost);
        } else {
            if (player.getArmor().getMultiplier() < multiplier) {
                player.setDefense(player.getDefense() - player.getArmor().getBoost());
                player.setArmor(this);
                boost = (int) (multiplier * player.getDefense());
                if (boost < 1) {
                    boost = 1;
                }
                player.setDefense(player.getDefense() + boost);
            } else {
                player.setGold(player.getGold() + ((int) (multiplier * 100)));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }
}
