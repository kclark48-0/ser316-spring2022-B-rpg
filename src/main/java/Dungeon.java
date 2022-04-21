public class Dungeon {
    private static final Dungeon instance = new Dungeon();
    private int floors;
    private int currentFloor;


    private Dungeon(){

    }

    public static synchronized Dungeon getInstance(){
        return instance;
    }
}
