package frost.countermobil.Maze.services;

import frost.countermobil.Maze.DAO.MySQL.ScoreDAOMySQL;
import frost.countermobil.Maze.DAO.ScoreDAO;
import frost.countermobil.Maze.models.*;
import frost.countermobil.Maze.util.JSONParser;
import frost.countermobil.Maze.util.MazeBuilder;
import org.json.simple.JSONObject;

import java.util.List;

public class GameService {
    MazeBuilder mazeBuilder = new MazeBuilder();
    KeyService keyService = new KeyService();
    MessageService messageService = new MessageService();
    DoorService doorService = new DoorService();
    JSONParser jsonParser = new JSONParser();
    ScoreDAO scoreDAO = new ScoreDAOMySQL();

    public Game createGame(int type) {

        Game game = new Game();
        Player player = new Player();
        Maze maze = null;
        switch (type) {
            case 1:
                maze = mazeBuilder.createMazeSimple();
                break;
        }
        game.setPlayer(player);
        game.setMaze(maze);
        game.setGameVersion(type);

        return game;
    }

    public Maze recoverMaze(Game game){
        return game.getMaze();
    }

    public Player recoverPlayer(Game game) {
        return game.getPlayer();
    }

    public Room recoverRoomInMaze(Game game, int roomNumber) {
        Maze maze = game.getMaze();
        return maze.getRoom(roomNumber);
    }

    public String getKey(Game game) {
        String message;
        Room room = recoverRoomInMaze(game, recoverPlayer(game).getRoomID());
        Key key = null;
        if (room.getKey() != null) {
            key = room.getKey();
            if (keyService.checkIfCanGetKey(key, recoverPlayer(game))) {
                game.getPlayer().addKey(key);
                message = messageService.itemCollectedMessage(key);
                room.removeKey();
            } else {
                message = messageService.notEnoughCoins(key, recoverPlayer(game));
            }
        } else {
            message = messageService.illegalPickupMessage(key);
        }
        return message;
    }

    public void setRoomOnPlayer(Game game, int roomNumber) {
        recoverPlayer(game).setRoomID(roomNumber);
    }

    public int getRoomOnPlayer(Game game) {
        return recoverPlayer(game).getRoomID();
    }

    public void setMazeVersion(Game game, int mazeVersion) {
        game.setGameVersion(mazeVersion);
    }

    public int getMazeVersion(Game game) {
        return game.getGameVersion();
    }

    public String openDoor(Game game, Maze.Directions dir) {
        String msg = null;
        Room room = recoverRoomInMaze(game, getRoomOnPlayer(game));
        Player player = recoverPlayer(game);
        //Check if door can be opened with keys in player
        if (doorService.CheckKeysForDoor(room.getDoorInSide(dir), player)) {
            room.getDoorInSide(dir).unlock();
            msg = messageService.doorUnlocked();
        //If not found, returns a message of error to the player
        } else {
            msg = messageService.illegalOpenMessage(room, dir);
        }
        return msg;
    }

    public JSONObject addMesage(JSONObject jsonRoom, String message) {
        return jsonParser.addMessageToJSON(jsonRoom, message);
    }

    public String checkDirection(Game game, Maze.Directions dir) {
        String msg = null;
        Room room = recoverRoomInMaze(game, recoverPlayer(game).getRoomID());
        if (doorService.canMoveToNextRoom(room, dir)){
            setRoomOnPlayer(game, doorService.moveToNextRoom(room, room.getDoorInSide(dir)));
        } else {
            msg = messageService.wrongDirectionMessage(room, dir);
        }
        return msg;
    }

    public void startTimer(Game game) {
        game.setGameLength(System.currentTimeMillis());
    }

    public void endTimer (Game game) {
        long startTime = game.getGameLength();
        long actualTime = System.currentTimeMillis();
        long difference = actualTime - startTime;
        game.setGameLength(difference/1000);
    }

    public void registerGame(Game game) {
        scoreDAO.savePlayerScore(game);
    }

    public List<Game> getTopPlayers(){
        return scoreDAO.getTopPlayers();
    }
}
