package frost.countermobil.Maze.DAO.MySQL;

import frost.countermobil.Maze.DAO.ScoreDAO;
import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.util.ConnectionMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAOMySQL implements ScoreDAO {

    private ConnectionMySQL connectionMySQL = new ConnectionMySQL();
    private Connection con = connectionMySQL.setConnection();


    @Override
    public void savePlayerScore(Game game) {

        String query = "INSERT INTO winners (name, version, time) VALUES (?, ?, ?)";

        try {
            PreparedStatement playerInsertionStmnt = con.prepareStatement(query);
            playerInsertionStmnt.setString(1, game.getPlayerName());
            playerInsertionStmnt.setInt(2, game.getGameVersion());
            playerInsertionStmnt.setLong(3, game.getGameLength());

            playerInsertionStmnt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    @Override
    public List<Game> getTopPlayers() {
        List<Game> topPlayers = new ArrayList<>();

        String query = "SELECT * FROM winners ORDER BY time ASC LIMIT 10";

        try {
            PreparedStatement getTopPlayers = con.prepareStatement(query);
            ResultSet res = getTopPlayers.executeQuery();

            while(res.next()){
                Game game = new Game();
                game.setPlayerName(res.getString(2));
                game.setGameVersion(res.getInt(3));
                game.setGameLength(res.getLong(4));
                topPlayers.add(game);
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        return topPlayers;
    }

}
