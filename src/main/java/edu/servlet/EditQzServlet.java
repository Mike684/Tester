package edu.servlet;

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
import java.util.UUID;

/**
 * Created by Mike on 15.05.2017.
 */
@WebServlet(name = "EditQzServlet", urlPatterns = "/edit_qz")
public class EditQzServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UUID quizID = UUID.fromString(request.getParameter("quizID"));
//        String theme = request.getParameter("theme");
//
//        Quiz quiz = new Quiz(theme);
//        quiz.setQuizID(quizID);
//
//        try {
//            new QuizDAO().updateQuiz(quiz,quizID);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
