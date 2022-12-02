package frost.countermobil.Maze.util;

import frost.countermobil.Maze.models.*;
//import org.json.simple.JSONObject;

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


    public void createDoor(Room room1, Room room2, Maze.Directions direction, String status) {
        Door door = new Door();
        if(status.equals("block")) {
            Key key = new Key();
            door.lock(key);
        }
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

    public Maze createMazeSimple(){
        Maze maze = new Maze();
        //Creates a list of enclosed rooms not connected
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            rooms.add(createRoom());
        }
        //Creation of open doors and connections between rooms
        createDoor(rooms.get(0), rooms.get(1), Maze.Directions.NORTH, "open");
        createDoor(rooms.get(2), rooms.get(3), Maze.Directions.EAST, "open");
        //Creation of closed doors and connections between rooms. Creates key in door
        createDoor(rooms.get(0), rooms.get(2), Maze.Directions.SOUTH, "block");
        //Assignation of key coordinates and room it's stored in and its value
        setKeyInRoom(rooms.get(1), rooms.get(0).getDoorInSide(Maze.Directions.SOUTH).getKey(), 0.3, 0.9);
        rooms.get(0).getDoorInSide(Maze.Directions.SOUTH).getKey().setCost(2);
        //Assignation of coin coordinates and room they're stored in
        setCoinInRoom(rooms.get(0), new Coin(), 0.3, 0.5);
        setCoinInRoom(rooms.get(1), new Coin(), 0.5, 0.3);
        setCoinInRoom(rooms.get(2), new Coin(), 0.9, 0.9);
        //Goal room
        rooms.get(3).setTarget();

        maze.setRooms(rooms);
        return maze;
    }

    public void setKeyInRoom(Room targetRoom, Key key, double coordX, double coordY) {
        key.setCoords(coordX, coordY);
        targetRoom.setKey(key);
    }

    public void setCoinInRoom(Room targetRoom, Coin coin, double coordX, double coordY) {
        coin.setCoords(coordX, coordY);
        targetRoom.setCoin(coin);
    }

//    public JSONObject roomToJSON (Room room, Player player) {
//        JSONObject jsonRoom = new JSONObject();
//        jsonRoom.put("room", room.getRoomId());
//        JSONObject walls = new JSONObject(room.getSides());
//        JSONObject items = new JSONObject();
//        JSONObject inventory = new JSONObject();
//        if (room.getCoin() != null) {
//            JSONObject coin = new JSONObject();
//            coin.put("x", room.getCoin().getCoordX());
//            coin.put("y", room.getCoin().getCoordY());
//            items.put("coin", coin);
//        }
//        if (room.getKey() != null) {
//            JSONObject key = new JSONObject();
//            key.put("x", room.getKey().getCoordX());
//            key.put("y", room.getKey().getCoordY());
//            items.put("key", key);
//        }
//        inventory.put("keys", player.totalKeys());
//        inventory.put("coins", player.totalCoins());
//        jsonRoom.put("walls", walls);
//        jsonRoom.put("items", items);
//        jsonRoom.put("inventory", inventory);
//        return jsonRoom;
//    }

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
