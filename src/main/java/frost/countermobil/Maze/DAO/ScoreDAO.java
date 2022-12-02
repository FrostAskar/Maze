package frost.countermobil.Maze.DAO;

import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.models.Player;

import java.util.List;

public interface ScoreDAO {

    void savePlayerScore(Game game);

    List<Game> getTopPlayers();

}
