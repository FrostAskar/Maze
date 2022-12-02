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

@WebServlet("/endform")
public class EndController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameService gameService = new GameService();

        //Stop timer
        Game game = (Game) session.getAttribute("game");
        gameService.endTimer(game);
        //Save timer
        session.setAttribute("game", game);
        req.setAttribute("mazeDuration", game.getGameLength());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/endform.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameService gameService = new GameService();
        Game game = (Game) session.getAttribute("game");
        game.setPlayerName(req.getParameter("playerName"));
        gameService.registerGame(game);
        resp.sendRedirect("/winners");
    }
}
