package edu.servlet;

import com.google.gson.Gson;
import edu.dao.tester.BlankDAO;
import edu.dao.tester.OptionDAO;
import edu.models.tester.Blank;
import edu.models.tester.Option;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

/**
 * CreateBlServlet for creating blank and putting it to database.
 * Created by Mike on 17.05.2017.
 */
@WebServlet(name = "CreateBlServlet", urlPatterns = "/create_bl")
public class CreateBlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID questionID = UUID.fromString(request.getParameter("questionID"));
        String answer = request.getParameter("answer");
        Blank blank = new Blank();
        blank.setQuestionID(questionID);
        blank.setAnswer(answer);

        try {
            new BlankDAO().createBlank(blank);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String json = new Gson().toJson(blank);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
