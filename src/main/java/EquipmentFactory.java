package main.java;

import java.util.Random;

public class EquipmentFactory {
    Dungeon dungeon;
    public double baseMultiplier = .04;
    public final int levelScaling = 4;

    public EquipmentFactory(){
        dungeon = Dungeon.getInstance();
    }

    public Equipment createEquipment(){
        int equipmentType = new Random().nextInt(3);

        String name;
        double scaling = dungeon.getScaling();

        if (scaling == 2){
            name = "Masterwork ";
        }else if (scaling == 1.5){
            name = "Fine ";
        }else{
            name = "";
        }

        int level = 1;
        level += dungeon.getCurrentFloor() / levelScaling;
        double multiplier = (level * scaling * baseMultiplier) / 2;
        if (multiplier > 1){
            multiplier = 1;
        }else if (multiplier < 0){
            multiplier = .04;
        }
        //System.out.println("\n***Multiplier of new Equipment is " + multiplier + "***\n");

        Equipment newEquipment = null;

        switch (equipmentType){
            case 0:
                name += "Armor";
                newEquipment = new Armor(name, multiplier);
                break;
            case 1:
                name += "Weapon";
                newEquipment = new Weapon(name, multiplier);
                break;
            case 2:
                name += "Glowstone";
                newEquipment = new Glowstone(name, multiplier);
                break;
        }

        return newEquipment;
    }
}
