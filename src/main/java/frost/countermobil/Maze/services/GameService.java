package frost.countermobil.Maze.services;

import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.models.Maze;
import frost.countermobil.Maze.models.Player;
import frost.countermobil.Maze.models.Room;

public class GameService {
    MazeBuilder mazeBuilder = new MazeBuilder();

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

}
