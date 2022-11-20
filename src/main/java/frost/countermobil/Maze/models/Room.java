package frost.countermobil.Maze.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    int roomId;
    List<Item> itemsInRoom = new ArrayList<>();
    boolean target = false;
    Map<Maze.Directions, MapSight> sides = new HashMap<>();

    //Creates isolated room, later to be asigned doors
    public Room(int roomId){
        this.roomId = roomId;
        sides.put(Maze.Directions.NORTH, new Wall());
        sides.put(Maze.Directions.SOUTH, new Wall());
        sides.put(Maze.Directions.EAST, new Wall());
        sides.put(Maze.Directions.WEST, new Wall());
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void addItem(Item item){
        itemsInRoom.add(item);
    }

    public void removeItem(Item item){
        for (Item itemInRoom : itemsInRoom){
            if (item == itemInRoom){
                itemsInRoom.remove(item);
            }
        }
    }

    public void setSide(Maze.Directions direction, MapSight sight){
        sides.put(direction, sight);
    }
}
