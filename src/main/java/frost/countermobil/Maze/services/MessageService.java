package frost.countermobil.Maze.services;

import frost.countermobil.Maze.models.*;

public class MessageService {

    public String wrongDirectionMessage(Room room, Maze.Directions dir) {
        String msg = "";
        if (room.getSide(dir) instanceof Wall) {
            msg = "There is no door on this side!";
        } else if (room.getSide(dir) instanceof Door) {
            msg = "This door is blocked!";
        }
        return msg;
    }

    public String illegalPickupMessage(Item item) {
        String msg = "";
        if (item instanceof Coin) {
            msg = "There is no coin to pick in this room";
        } else if (item instanceof Key) {
            msg = "There is no key to pick in this room";
        }
        return msg;
    }

    public String illegalOpenMessage (Room room, Maze.Directions dir) {
        String msg = "";
        if (room.getSide(dir) instanceof Wall) {
            msg = "There is no door to open in this side";
        } else if (room.getSide(dir) instanceof Door) {
            msg = "You don't have the key to open this door";
        }
        return msg;
    }

    public String itemCollectedMessage(Item item) {
        String msg = "";
        if (item instanceof Coin) {
            msg = "You've collected a coin";
        } else if (item instanceof Key) {
            msg = "You've collected a key";
        }
        return msg;
    }

    public String notEnoughCoins(Key key, Player player) {
        int difference = key.getCost() - player.totalCoins();
        return "You don't have enough coins, you need " + difference + " more coins.";
    }

    public String winMessage() {
        return "You've beaten the maze";
    }

    public String doorUnlocked() {
        return "The door has been unlocked";
    }
}
