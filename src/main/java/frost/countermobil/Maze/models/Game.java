package frost.countermobil.Maze.models;

public class Game {

    Player player = new Player();
    Maze maze = new Maze();

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
}
