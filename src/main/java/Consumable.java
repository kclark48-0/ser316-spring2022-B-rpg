package main.java;

public interface Consumable{
    public String getName();
    public int getPower();
    public void useOn(Entity target);
}
