package frost.countermobil.Maze.models;

import java.util.HashMap;
import java.util.Map;

public class Room {

    private int roomId;
    //private List<Item> itemsInRoom = new ArrayList<>();
    private boolean target = false;
    private Map<Maze.Directions, MapSight> sides = new HashMap<>();
    private Key key = null;
    private Coin coin = null;

    //Creates isolated room, later to be asigned doors
    public Room(int roomId){
        this.roomId = roomId;
        sides.put(Maze.Directions.NORTH, new Wall());
        sides.put(Maze.Directions.SOUTH, new Wall());
        sides.put(Maze.Directions.EAST, new Wall());
        sides.put(Maze.Directions.WEST, new Wall());
    }

    public Door getDoorInSide(Maze.Directions dir){
        return (Door) this.sides.get(dir);
    }

    public int getRoomId() {
        return roomId;
    }

    public Map<Maze.Directions, MapSight> getSides() {
        return sides;
    }

    public void setSide(Maze.Directions direction, MapSight sight){
        sides.put(direction, sight);
    }

    public void setTarget() {
        this.target = true;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public void removeCoin() {
        this.coin = null;
    }

    public void removeKey() {
        this.key = null;
    }

    public boolean isTarget() {
        return target;
    }
}
