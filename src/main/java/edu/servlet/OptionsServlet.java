package edu.servlet;

import edu.dao.tester.BlankDAO;
import edu.dao.tester.OptionDAO;
import edu.dao.tester.QuestionDAO;
import edu.dao.tester.QuizDAO;
import edu.models.tester.Blank;
import edu.models.tester.Option;
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
 * OptionsServlet for getting option list and moving to options.jsp page.
 * Created by Mike on 14.05.2017.
 */
@WebServlet(name = "OptionsServlet", urlPatterns = "/options")
public class OptionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID questionID = UUID.fromString(request.getParameter("id"));
        Question question = null;

        String type = request.getParameter("type");
        if (type.equalsIgnoreCase("TEST")||type.equalsIgnoreCase("MTEST")) {
            List<Option> options = null;
            try {
                question = new QuestionDAO().getQuestionById(questionID);
                options = new OptionDAO().getOptionsById(questionID);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("question", question);
            request.setAttribute("options", options);
            request.getRequestDispatcher("pages/options.jsp").forward(request, response);
        }
        else if (type.equalsIgnoreCase("BLANK")) {
            List<Blank> blanks = null;
            try {
                question = new QuestionDAO().getQuestionById(questionID);
                blanks = new BlankDAO().getBlanksById(questionID);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("question", question);
            request.setAttribute("blanks", blanks);
            request.getRequestDispatcher("pages/blanks.jsp").forward(request, response);
        }
    }
}
