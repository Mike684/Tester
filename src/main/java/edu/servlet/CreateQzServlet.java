package edu.servlet;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.dao.tester.QuizDAO;
import edu.models.tester.Quiz;
import edu.services.JSONService;

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
 * CreateQzServlet for creating quiz and putting it to database.
 * Created by Mike on 09.05.2017.
 */
@WebServlet(name = "CreateQzServlet", urlPatterns = "/create_qz")
public class CreateQzServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String theme = request.getParameter("theme");
        Quiz quiz = new Quiz(theme);
        try {
            new QuizDAO().createQuiz(quiz);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String json = new Gson().toJson(quiz);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
