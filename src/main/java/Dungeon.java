package main.java;

public class Dungeon {
    private static final Dungeon instance = new Dungeon();
    protected int floors;
    protected int currentFloor;
    protected int furthestFloorReached;


    private Dungeon(){
        this.floors = 100;
        this.currentFloor = 1;
        this.furthestFloorReached = 1;
    }

    public static synchronized Dungeon getInstance(){
        return instance;
    }
}
