package frost.countermobil.Maze.controllers;

import frost.countermobil.Maze.models.Coin;
import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.models.Room;
import frost.countermobil.Maze.services.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getcoin")
public class CoinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameService gameService = new GameService();

        Game game = (Game) session.getAttribute("game");
        int numberRoom = (int) session.getAttribute("numberRoom");

        Room room = gameService.recoverRoomInMaze(game, numberRoom);

        if (room.getCoin() != null) {
            Coin coin = room.getCoin();
            game.getPlayer().addCoin(coin);
            room.removeCoin();
        } else {
            session.setAttribute("errorLog", "There is no coin in this room, buckaroo.");
        }

        resp.sendRedirect("/nav");
    }
}
