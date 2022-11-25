package frost.countermobil.Maze.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maze {
    List<Room> rooms = new ArrayList<>();
    public enum Directions {
        NORTH, SOUTH, EAST, WEST
    };

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room getRoom(int nRoom) {
        return rooms.get(nRoom -1);
    }

}
