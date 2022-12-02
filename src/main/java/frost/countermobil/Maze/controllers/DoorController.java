package frost.countermobil.Maze.controllers;

import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.models.Maze;
import frost.countermobil.Maze.models.Player;
import frost.countermobil.Maze.models.Room;
import frost.countermobil.Maze.services.DoorService;
import frost.countermobil.Maze.services.GameService;
import frost.countermobil.Maze.services.MessageService;
import frost.countermobil.Maze.util.JSONParser;
import frost.countermobil.Maze.util.Translator;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/open")
public class DoorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameService gameService = new GameService();
        Translator tr = new Translator();

        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        String parameterDir = req.getParameter("dir");
        Maze.Directions dir = tr.singleLetterToWord(parameterDir);

        String message = gameService.openDoor(game, dir);

        if (message != null) {
            session.setAttribute("message", message);
        }

        resp.sendRedirect("/nav");
    }
}
