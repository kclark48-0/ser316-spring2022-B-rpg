public class Weapon implements Equipment {
    private String name;
    private double multiplier;
    private int boost;
    private Character player;

    public Weapon(String name, int boost, Character pc){
        this.name = name;
        this.boost = boost;
        this.player = pc;
    }

    public void equip(){
        if (player.getWeapon() == null){
            player.setWeapon(this);
            boost = (int) (multiplier * player.getAttack());
            player.setAttack(player.getAttack() + boost);
        }else{
            if (player.getWeapon().getMultiplier() < multiplier){
                player.setAttack(player.getAttack() - player.getWeapon().getBoost());
                player.setWeapon(this);
                boost = (int) (multiplier * player.getDefense());
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

    public Character getPlayer() {
        return player;
    }

    public void setPlayer(Character player) {
        this.player = player;
    }
}
