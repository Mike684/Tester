package edu.servlet;

import com.google.gson.Gson;
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
import java.util.List;
import java.util.UUID;

/**
 * CreateQsServlet for creating question and putting it to database.
 * Created by Mike on 13.05.2017.
 */
@WebServlet(name = "CreateQsServlet", urlPatterns = "/create_qs")
public class CreateQsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID quizID = UUID.fromString(request.getParameter("quizID"));
        String text = request.getParameter("question");
        String type = request.getParameter("type");
        String maxMark = request.getParameter("mark");

        Question question = new Question();
        question.setQuizID(quizID);
        question.setText(text);
        question.setType(QuestionType.valueOf(type));
        question.setMaxMark(Double.valueOf(maxMark));

        try {
            new QuestionDAO().createQuestion(question);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String json = new Gson().toJson(question);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
