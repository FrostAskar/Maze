package frost.countermobil.Maze.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Maze {
    Map<Integer, Room> maze = new HashMap<>();
    public enum Directions {
        NORTH, SOUTH, EAST, WEST
    };
}
