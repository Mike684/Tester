package edu.drivers;

import edu.creator.QuizMaker;
import edu.dao.users.UserDAO;
import edu.models.tester.Quiz;
import edu.models.users.User;
import edu.services.FileService;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Mike on 20.04.2017.
 */
public class QuizDriver {
    public static void main(String[] args) throws IOException, SQLException {

        Quiz quiz = new QuizMaker().createQuiz();
//        new FileService().writeToJSON(quiz);
//        new FileService().writeToXML(quiz);

        UserDAO userDAO = new UserDAO();
        User user = new User();
        user.setUserName("name");
        user.setPassword("password");
        userDAO.createUser(user);
//        userDAO.updateUser(user);
//        userDAO.deleteUser(user.getUserID());
//        System.out.println(userDAO.getUserById(user.getUserID()).toString());
    }
}
