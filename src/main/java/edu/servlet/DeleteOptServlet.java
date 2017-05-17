package edu.servlet;

import edu.dao.tester.OptionDAO;
import edu.dao.tester.QuestionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

/**
 * DeleteOptServlet for deleting option from database.
 * Created by Mike on 16.05.2017.
 */
@WebServlet(name = "DeleteOptServlet", urlPatterns = "/delete_opt")
public class DeleteOptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID optionID = UUID.fromString(request.getParameter("id"));
        try {
            new OptionDAO().deleteOption(optionID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
