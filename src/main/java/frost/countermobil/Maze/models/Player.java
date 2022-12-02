package frost.countermobil.Maze.models;

import java.util.ArrayList;
import java.util.List;

public class Player {

    int roomID;
    int money = 0;
    List<Key> keys = new ArrayList<>();

    public int totalKeys() {
        return keys.size();
    }

    public int totalCoins() {
        return money;
    }

    public void addCoin(Coin coin) {
        money += coin.getValue();
    }

    public void addKey(Key key) {
        keys.add(key);
        this.money -= key.getCost();
    }

    public List<Key> getKeys() {
        return keys;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
}
