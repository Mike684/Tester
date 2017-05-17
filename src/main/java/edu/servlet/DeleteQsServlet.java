package edu.servlet;

import edu.dao.tester.QuestionDAO;
import edu.dao.tester.QuizDAO;
import edu.models.tester.Question;
import edu.models.tester.QuestionType;
import edu.models.tester.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

/**
 * DeleteQsServlet for deleting question from database.
 * Created by Mike on 14.05.2017.
 */
@WebServlet(name = "DeleteQsServlet", urlPatterns = "/delete_qs")
public class DeleteQsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID questionID = UUID.fromString(request.getParameter("id"));
        try {
            new QuestionDAO().deleteQuestion(questionID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
