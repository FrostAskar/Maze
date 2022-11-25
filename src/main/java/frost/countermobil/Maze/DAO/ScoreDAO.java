package frost.countermobil.Maze.DAO;

import frost.countermobil.Maze.models.Player;

import java.util.List;

public interface ScoreDAO {

    void savePlayerScore(Player player);

    List<Player> getTopPlayers();

    Player getPlayer(int playerId);

}
