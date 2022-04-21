public class Dungeon {
    private static final Dungeon instance = new Dungeon();
    protected int floors;
    protected int currentFloor;
    protected int furthestFloorReached;


    private Dungeon(){

    }

    public static synchronized Dungeon getInstance(){
        return instance;
    }
}
