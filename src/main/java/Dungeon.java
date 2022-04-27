package main.java;

/**
 * Singleton class representing the game environment and controls the scaling value used to create enemies and items
 * of appropriate power for the floor they are found on.
 */
public class Dungeon {
    private static final Dungeon instance = new Dungeon();
    private int floors;
    private int currentFloor;
    private int furthestFloorReached;
    private double scaling = 1;

    private Dungeon(){
        this.floors = 100;
        this.currentFloor = 1;
        this.furthestFloorReached = 1;
    }

    public static synchronized Dungeon getInstance(){
        return instance;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Method to update the current floor of the dungeon the player is on. This also automatically updates the
     * enemy scaling used by EnemyFactory.
     * @param floor int representing the current floor the player is on
     */
    public void setCurrentFloor(int floor){
        this.currentFloor = floor;

        if (currentFloor == 100 ){
            scaling = 3;
        }else if (currentFloor % 10 == 0){
            scaling = 2;
        }else if (currentFloor % 5 == 0){
            scaling = 1.5;
        }else{
            scaling = 1;
        }
    }

    public int getFurthestFloorReached() {
        return furthestFloorReached;
    }

    public void setFurthestFloorReached(int furthestFloorReached) {
        this.furthestFloorReached = furthestFloorReached;
    }

    public void setScaling(double scaling) {
        this.scaling = scaling;
    }

    public double getScaling() {
        return scaling;
    }
}
