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

@WebServlet("/start")
public class StartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/start.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GameService gameService = new GameService();
        HttpSession session = req.getSession();

        int mazeVersion = Integer.parseInt(req.getParameter("mapid"));
        Game game = gameService.createGame(mazeVersion);

        session.setAttribute("game", game);
        session.setAttribute("numberRoom", 1);

        resp.sendRedirect("/nav");
    }
}