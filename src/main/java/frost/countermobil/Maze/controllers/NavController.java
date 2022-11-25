package frost.countermobil.Maze.controllers;

import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.models.Maze;
import frost.countermobil.Maze.models.Player;
import frost.countermobil.Maze.models.Room;
import frost.countermobil.Maze.services.DoorService;
import frost.countermobil.Maze.services.GameService;
import frost.countermobil.Maze.util.JSONParser;
import frost.countermobil.Maze.util.Translator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/nav")
public class NavController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameService gameService = new GameService();
        DoorService doorService = new DoorService();
        Translator tr = new Translator();
        JSONParser jsonParser = new JSONParser();

        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        Player player = game.getPlayer();
        Maze maze = gameService.recoverMaze(game);
        int numberRoom = (int) session.getAttribute("numberRoom");
        Room actualRoom = maze.getRoom(numberRoom);

        String dir = req.getParameter("dir");
        if (dir != null) {
            numberRoom = doorService.moveToNextRoom(actualRoom, actualRoom.getDoorInSide(tr.singleLetterToWord(dir)));
            actualRoom = maze.getRoom(numberRoom);
        }

        req.setAttribute("jsonRoom", jsonParser.roomToJSON(actualRoom, player));

        session.setAttribute("numberRoom", numberRoom);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/maze.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/maze.jsp");
        dispatcher.forward(req, resp);
    }
}