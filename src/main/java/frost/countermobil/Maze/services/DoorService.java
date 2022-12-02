package frost.countermobil.Maze.services;

import frost.countermobil.Maze.models.*;

import java.util.List;

public class DoorService {

    public boolean CheckKeysForDoor(Door door, Player player) {
        List<Key> keysFromPlayer = player.getKeys();
        for (Key key : keysFromPlayer) {
            if (key.equals(door.getKey())) {
                return true;
            }
        }
        return false;
    }

    public int moveToNextRoom(Room room, Door door) {
        int roomID = room.getRoomId();
        int room1ID = door.getRoom1().getRoomId();
        int room2ID = door.getRoom2().getRoomId();
        int target = 0;
        if (roomID == room1ID) {
            target = room2ID;
        } else if (roomID == room2ID) {
            target = room1ID;
        }
        return target;
    }

    public boolean canMoveToNextRoom(Room room, Maze.Directions dir) {
        return room.getSide(dir) instanceof Door && !((Door) room.getSide(dir)).isBlocked();
    }

}
