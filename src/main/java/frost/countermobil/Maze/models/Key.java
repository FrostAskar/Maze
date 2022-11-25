package frost.countermobil.Maze.models;

import java.util.ArrayList;
import java.util.List;

public class Key extends Item{
    //List<Door> doors = new ArrayList<>();
    private int cost = 0;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
