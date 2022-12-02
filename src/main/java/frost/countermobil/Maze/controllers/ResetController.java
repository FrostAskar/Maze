package frost.countermobil.Maze.controllers;

import com.mysql.cj.Session;
import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.services.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reset")
public class ResetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameService gameService = new GameService();

        HttpSession session = req.getSession();
        //Recover version of maze being played
        int mazeVersion = gameService.getMazeVersion((Game)session.getAttribute("game"));
        //Create new game and overwrite former.
        Game game = gameService.createGame(mazeVersion);
        gameService.setRoomOnPlayer(game, 1);
        gameService.startTimer(game);
        session.setAttribute("game", game);
        session.setAttribute("message", "Game has been reseted");
        resp.sendRedirect("/nav");
    }
}
