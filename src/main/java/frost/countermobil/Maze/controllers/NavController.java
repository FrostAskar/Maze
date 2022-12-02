package frost.countermobil.Maze.controllers;

import frost.countermobil.Maze.models.*;
import frost.countermobil.Maze.services.DoorService;
import frost.countermobil.Maze.services.GameService;
import frost.countermobil.Maze.services.MessageService;
import frost.countermobil.Maze.util.JSONParser;
import frost.countermobil.Maze.util.Translator;
import org.json.simple.JSONObject;

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
        Translator tr = new Translator();
        JSONParser jsonParser = new JSONParser();

        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        Player player = gameService.recoverPlayer(game);
        Maze maze = gameService.recoverMaze(game);
        int numberRoom = gameService.getRoomOnPlayer(game);
        Room actualRoom = maze.getRoom(numberRoom);
        Maze.Directions dir = null;
        String message = (String) session.getAttribute("message");
        JSONObject jsonRoom =  jsonParser.roomToJSON(actualRoom, player);
        //Check if nav is getting a direction from the maze
        String parameterDir = req.getParameter("dir");
        if (parameterDir != null) {
            dir = tr.singleLetterToWord(parameterDir);
            message = gameService.checkDirection(game, dir);
        }

        // If message is written, add it to JSON Object.
        if (message != null) {
            jsonRoom = gameService.addMesage(jsonRoom, message);
            //After storing message it is removed from session as to not have it print in next load
            session.removeAttribute("message");
        //Values must be updated if checkDirection is performed successfully
        } else {
            numberRoom = gameService.getRoomOnPlayer(game);
            actualRoom = maze.getRoom(numberRoom);
            jsonRoom =  jsonParser.roomToJSON(actualRoom, player);

        }

        session.setAttribute("jsonRoom", jsonRoom);

        gameService.setRoomOnPlayer(game, numberRoom);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/maze.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/maze.jsp");
        dispatcher.forward(req, resp);
    }
}