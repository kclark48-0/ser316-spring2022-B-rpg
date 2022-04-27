import java.util.Random;

public class ConsumableFactory {

    Dungeon dungeon;
    public double basePower = 5;
    public final int levelScaling = 4;

    public ConsumableFactory(){
        dungeon = Dungeon.getInstance();
    }

    public Consumable createEquipment(){
        int consumableType = new Random().nextInt(2);

        String name;
        double scaling = dungeon.getScaling();

        if (scaling == 2){
            name = "Eldritch ";
        }else if (scaling == 1.5){
            name = "Arcane ";
        }else{
            name = "";
        }

        int level = 1;
        level += dungeon.getCurrentFloor() / levelScaling;
        int power = (int)(level * scaling * basePower);

        System.out.println("\n***Multiplier of new Equipment is " + multiplier + "***\n");

        Consumable newConsumable = null;

        switch (consumableType){
            case 0:
                name += "Potion";
                newConsumable = new Potion(name, power);
                break;
            case 1:
                name += "Scroll";
                newConsumable = new Scroll(name, power);
                break;
        }

        return newConsumable;
    }
}
