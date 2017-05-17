package edu.servlet;

import edu.dao.tester.QuestionDAO;
import edu.dao.tester.QuizDAO;
import edu.models.tester.Question;
import edu.models.tester.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * QuestionsServlet for getting question list and moving to questions.jsp page.
 * Created by Mike on 12.05.2017.
 */
@WebServlet(name = "QuestionsServlet", urlPatterns = "/questions")
public class QuestionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID quizID = UUID.fromString(request.getParameter("id"));

        Quiz quiz = null;
        List<Question> questions = null;
        try {
            quiz = new QuizDAO().getQuizById(quizID);
            questions = new QuestionDAO().getQuestionsById(quizID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("quiz", quiz);
        request.setAttribute("questions", questions);
        request.getRequestDispatcher("pages/questions.jsp").forward(request,response);
    }
}
