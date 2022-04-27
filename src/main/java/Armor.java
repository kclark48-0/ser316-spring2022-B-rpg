public class Armor implements Equipment {

    private String name;
    private double multiplier;
    private int boost;
    private Character player;

    public Armor(String name, int boost, Character pc){
        this.name = name;
        this.boost = boost;
        this.player = pc;
    }

    public void equip(){
        if (player.getArmor() == null){
            player.setArmor(this);
            boost = (int) (multiplier * player.getDefense());
            player.setDefense(player.getDefense() + boost);
        }else{
            if (player.getArmor().getMultiplier() < multiplier){
                player.setDefense(player.getDefense() - player.getArmor().getBoost());
                player.setArmor(this);
                boost = (int) (multiplier * player.getDefense());
                player.setDefense(player.getDefense() + boost);
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
