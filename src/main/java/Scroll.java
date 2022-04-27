public class Scroll implements Consumable{

    private String name;
    private int power;

    public Scroll(String name, int power, Entity owner){
        this.name = name;
        this.power = power;
    }

    public void consume(Entity target){
        target.setHealth(target.getHealth() - power);
    }
}
