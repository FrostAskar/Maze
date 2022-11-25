package frost.countermobil.Maze.util;

import frost.countermobil.Maze.models.*;
import org.json.simple.JSONObject;

import java.util.Map;

public class JSONParser {

    public JSONObject roomToJSON (Room room, Player player) {
        JSONObject jsonRoom = new JSONObject();
        jsonRoom.put("room", room.getRoomId());
        JSONObject doors = translateWallsToJSON(room);
        JSONObject items = new JSONObject();
        JSONObject inventory = new JSONObject();
        if (room.getCoin() != null) {
            JSONObject coin = new JSONObject();
            coin.put("x", room.getCoin().getCoordX());
            coin.put("y", room.getCoin().getCoordY());
            items.put("coin", coin);
        }
        if (room.getKey() != null) {
            JSONObject key = new JSONObject();
            key.put("x", room.getKey().getCoordX());
            key.put("y", room.getKey().getCoordY());
            items.put("key", key);
        }
        inventory.put("keys", player.totalKeys());
        inventory.put("coins", player.totalCoins());
        jsonRoom.put("doors", doors);
        jsonRoom.put("items", items);
        jsonRoom.put("inventory", inventory);
        jsonRoom.put("victory", room.isTarget());

        return jsonRoom;
    }

    private JSONObject translateWallsToJSON (Room room){
        JSONObject jsonObject = new JSONObject();
        String key = null, value = null;
        for (Map.Entry<Maze.Directions, MapSight> dir : room.getSides().entrySet()){
            switch (dir.getKey()){
                case NORTH:
                    key = "N";
                    break;
                case SOUTH:
                    key = "S";
                    break;
                case WEST:
                    key = "W";
                    break;
                case EAST:
                    key = "E";
                    break;
            }
            if (dir.getValue() instanceof Wall) {
                value = "wall";
            } else if (dir.getValue() instanceof Door) {
                if (((Door) dir.getValue()).isBlocked()) {
                    value = "closed";
                } else {
                    value = "open";
                }
            }
            jsonObject.put(key, value);
        }

        return jsonObject;
    }

}
