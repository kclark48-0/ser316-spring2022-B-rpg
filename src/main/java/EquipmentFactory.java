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


        switch (equipmentType){
            case 0:
                name += "Armor";
                Armor newArmor = new Armor
                break;
            case 1:
                name += "Ifrit";
                maxMana *= 1.5;
                speed *= 0.75;
                break;
            case 2:
                name += "Wraith";
                maxHealth *= 0.5;
                defense *= 0.5;
                speed *= 2;
                reflex *= 1.5;
                break;
        }

        xp = (int) experience;
        g = (int) gold;
        mHlth = (int) maxHealth;
        if (mHlth <= 0){
            mHlth = 1;
        }
        mMana = (int) maxMana;
        if (mMana <= 0){
            mMana = 1;
        }
        atk = (int) attack;
        def = (int) defense;
        spd = (int) speed;
        ref = (int) reflex;

        return new Enemy(name, level, xp, g, mHlth, mMana, atk, def, spd, ref);
    }
}
