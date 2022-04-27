package main.java;

public class Weapon implements Equipment {
    private String name;
    private double multiplier;
    private int boost;

    public Weapon(String name, double multiplier){
        this.name = name;
        this.multiplier = multiplier;
        this.boost = 0;
    }

    public void equip(Character player){
        if (player.getWeapon() == null){
            player.setWeapon(this);
            boost = (int) (multiplier * player.getAttack());
            if (boost < 1){
                boost = 1;
            }
            player.setAttack(player.getAttack() + boost);
        }else{
            if (player.getWeapon().getMultiplier() < multiplier){
                player.setAttack(player.getAttack() - player.getWeapon().getBoost());
                player.setWeapon(this);
                boost = (int) (multiplier * player.getDefense());
                if (boost < 1){
                    boost = 1;
                }
                player.setAttack(player.getAttack() + boost);
            }else{
                player.setGold(player.getGold() + ((int)(multiplier * 100)));
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
