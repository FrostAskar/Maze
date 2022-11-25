package frost.countermobil.Maze.controllers;

import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.models.Player;
import frost.countermobil.Maze.models.Room;
import frost.countermobil.Maze.services.DoorService;
import frost.countermobil.Maze.services.GameService;
import frost.countermobil.Maze.util.Translator;

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
        DoorService doorService = new DoorService();
        Translator tr = new Translator();
        HttpSession session = req.getSession();

        Game game = (Game) session.getAttribute("game");
        int numberRoom = (int) session.getAttribute("numberRoom");
        Player player = game.getPlayer();
        String dir = req.getParameter("dir");

        Room room = game.getMaze().getRoom(numberRoom);
        if (doorService.CheckKeysForDoor(room.getDoorInSide(tr.singleLetterToWord(dir)), player)) {
            game.getMaze().getRoom(numberRoom).getDoorInSide(tr.singleLetterToWord(dir)).unlock();
        }
        resp.sendRedirect("/nav");
    }
}
