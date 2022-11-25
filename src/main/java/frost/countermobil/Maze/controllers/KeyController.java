package frost.countermobil.Maze.controllers;

import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.models.Key;
import frost.countermobil.Maze.models.Room;
import frost.countermobil.Maze.services.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getkey")
public class KeyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameService gameService = new GameService();
        HttpSession session = req.getSession();

        Game game = (Game) session.getAttribute("game");
        int numberRoom = (int) session.getAttribute("numberRoom");
        Room room = game.getMaze().getRoom(numberRoom);

        if (room.getKey() != null) {
            Key key = room.getKey();
            game.getPlayer().addKey(key);
            room.removeKey();
        } else {
            session.setAttribute("errorLog", "There is no key in this room, buckaroo.");
        }

        resp.sendRedirect("/nav");
    }
}
