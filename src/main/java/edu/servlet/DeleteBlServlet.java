package edu.servlet;

import edu.dao.tester.BlankDAO;
import edu.dao.tester.OptionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

/**
 * DeleteBlServlet for deleting blank from database.
 * Created by Mike on 17.05.2017.
 */
@WebServlet(name = "DeleteBlServlet", urlPatterns = "/delete_bl")
public class DeleteBlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID optionID = UUID.fromString(request.getParameter("id"));
        try {
            new BlankDAO().deleteBlank(optionID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
