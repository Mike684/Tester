package edu.servlet;

import edu.dao.tester.QuizDAO;
import edu.dao.users.UserDAO;
import edu.models.tester.Quiz;
import edu.models.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * MainServlet loads main page with quiz list.
 * Created by Mike on 07.05.2017.
 */
@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Quiz> quizList = new ArrayList<>();
        try {
            quizList = new QuizDAO().getAllQuizzes();
        } catch (SQLException e) {
            e.printStackTrace();
        }request.setAttribute("quizList", quizList);
        request.getRequestDispatcher("pages/quizzes.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
