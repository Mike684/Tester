package edu.servlet;

import com.google.gson.Gson;
import edu.dao.tester.QuizDAO;
import edu.models.tester.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * DeleteQzServlet for deleting quiz from database.
 * Created by Mike on 08.05.2017.
 */
@WebServlet(name = "DeleteQzServlet", urlPatterns = "/delete_qz")
public class DeleteQzServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID quizID = UUID.fromString(request.getParameter("id"));
        try {
            new QuizDAO().deleteQuiz(quizID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setStatus(HttpServletResponse.SC_OK);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
