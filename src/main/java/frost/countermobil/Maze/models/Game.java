package frost.countermobil.Maze.models;

import java.sql.Date;
import java.time.LocalDateTime;

public class Game {

    Player player = new Player();
    String playerName;
    Maze maze = new Maze();
    long gameLength;
    int gameVersion;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public int getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(int gameVersion) {
        this.gameVersion = gameVersion;
    }

    public long getGameLength() {
        return gameLength;
    }

    public void setGameLength (Long time) {
        this.gameLength = time;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
