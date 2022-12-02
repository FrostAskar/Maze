package frost.countermobil.Maze.controllers;

import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.models.Key;
import frost.countermobil.Maze.models.Room;
import frost.countermobil.Maze.services.GameService;
import frost.countermobil.Maze.services.KeyService;
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

@WebServlet("/getkey")
public class KeyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameService gameService = new GameService();
        HttpSession session = req.getSession();


        Game game = (Game) session.getAttribute("game");

        String message = gameService.getKey(game);

        gameService.getKey(game);

        session.setAttribute("message", message);

        resp.sendRedirect("/nav");
    }
}
