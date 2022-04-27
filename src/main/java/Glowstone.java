public class Glowstone implements Equipment {

    private String name;
    private double multiplier;
    private int boost;

    public Glowstone(String name, int boost, Character pc){
        this.name = name;
        this.boost = boost;
    }

    public void equip(Character player){
        if (player.getGlowstone() == null){
            player.setGlowstone(this);
            boost = (int) (multiplier * player.getReflex());
            player.setReflex(player.getReflex() + boost);
        }else{
            if (player.getGlowstone().getMultiplier() < multiplier){
                player.setReflex(player.getReflex() - player.getGlowstone().getBoost());
                player.setGlowstone(this);
                boost = (int) (multiplier * player.getReflex());
                player.setReflex(player.getReflex() + boost);
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
