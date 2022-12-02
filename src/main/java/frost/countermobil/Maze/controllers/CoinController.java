package frost.countermobil.Maze.controllers;

import frost.countermobil.Maze.models.Coin;
import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.models.Room;
import frost.countermobil.Maze.services.GameService;
import frost.countermobil.Maze.services.MessageService;
import frost.countermobil.Maze.util.JSONParser;
import org.json.simple.JSONObject;

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
        MessageService messageService = new MessageService();

        Game game = (Game) session.getAttribute("game");
        int numberRoom = gameService.getRoomOnPlayer(game);
        String message;
        Room room = gameService.recoverRoomInMaze(game, numberRoom);
        Coin coin = null;

        if (room.getCoin() != null) {
            coin = room.getCoin();
            game.getPlayer().addCoin(coin);
            message = messageService.itemCollectedMessage(coin);
            room.removeCoin();
        } else {
            message = messageService.illegalPickupMessage(coin);
        }

        session.setAttribute("message", message);

        resp.sendRedirect("/nav");
    }
}
