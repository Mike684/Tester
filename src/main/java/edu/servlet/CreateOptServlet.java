package edu.servlet;

import com.google.gson.Gson;
import edu.dao.tester.OptionDAO;
import edu.dao.tester.QuestionDAO;
import edu.models.tester.Option;
import edu.models.tester.Question;
import edu.models.tester.QuestionType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

/**
 * CreateOptServlet for creating option and putting it to database.
 * Created by Mike on 14.05.2017.
 */
@WebServlet(name = "CreateOptServlet", urlPatterns = "/create_opt")
public class CreateOptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UUID questionID = UUID.fromString(request.getParameter("questionID"));
        String text = request.getParameter("option");
        String answer = request.getParameter("answer");
        Option option = new Option();
        option.setQuestionID(questionID);
        option.setOption(text);
        option.setAnswer(Boolean.valueOf(answer));

        try {
            new OptionDAO().createOption(option);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String json = new Gson().toJson(option);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
