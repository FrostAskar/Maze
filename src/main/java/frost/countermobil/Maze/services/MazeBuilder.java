package frost.countermobil.Maze.services;

import frost.countermobil.Maze.models.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MazeBuilder {

    int roomId = 1;

    public Room createRoom(){
        Room room = new Room(roomId);
        roomId++;
        return room;
    }

    public void insertItem(Item item, Room room){

    }

    public void removeItem(Item item, Room room){

    }

    /*
    CONCEPT TIME:
        Create one object door. This door has to be assigned to 2 rooms
     */

    public void createDoor(Room room1, Room room2, Maze.Directions direction) {
        Door door = new Door();
        door.setRoom1(room1);
        door.setRoom2(room2);
        room1.setSide(direction, door);
        createReverseDoor(room2, door, direction);
    }

    private void createReverseDoor(Room room, Door door, Maze.Directions direction){
        Maze.Directions reverseDirection = null;
        switch (direction){
            case NORTH:
                reverseDirection = Maze.Directions.SOUTH;
                break;
            case SOUTH:
                reverseDirection = Maze.Directions.NORTH;
                break;
            case EAST:
                reverseDirection = Maze.Directions.WEST;
                break;
            case WEST:
                reverseDirection = Maze.Directions.EAST;
                break;
        }
        room.setSide(reverseDirection, door);
    }

    public void createLockedDoor(Room room1, Room room2){

    }

    public void createReverseLockedDoor(){

    }

    public Maze createMaze(int NumberRooms){
        Maze maze = new Maze();
        return maze;
    }
//  todo remember to delete
//    public String example(){
//        JSONObject root = new JSONObject();
//        JSONObject walls = new JSONObject();
//        walls.put("N", "wall");
//        walls.put("S", "door");
//        walls.put("E", "wall");
//        walls.put("W", "door");
//        root.put("walls", walls);
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.add(root);
//        return jsonArray.toJSONString();
//    }

}
