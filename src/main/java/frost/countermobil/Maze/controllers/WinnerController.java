package frost.countermobil.Maze.controllers;

import frost.countermobil.Maze.models.Game;
import frost.countermobil.Maze.services.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/winners")
public class WinnerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameService gameService = new GameService();
        List<Game> topGames = gameService.getTopPlayers();
        session.setAttribute("winners", topGames);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/winners.jsp");
        dispatcher.forward(req, resp);

    }
}
