package edu.dao.users;

import edu.dao.tester.QuizDAO;
import edu.models.tester.Quiz;
import edu.models.users.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Mike on 16.05.2017.
 */
public class UserDAOTest {

    @Test
    public void testUser() throws SQLException {
        User user = new User();
        user.setUserName("uName");
        user.setPassword("password1");
        new UserDAO().createUser(user);
        User user1 = new UserDAO().getUserById(user.getUserID());
        Assert.assertEquals(user.toString(),user1.toString());

        user.setUserName("uName2");
        new UserDAO().updateUser(user);
        user1 = new UserDAO().getUserById(user.getUserID());
        Assert.assertEquals(user.toString(),user1.toString());

        List<User> users = new UserDAO().getAllUsers();
        new UserDAO().createUser(new User());
        List<User> users1 = new UserDAO().getAllUsers();
        assertEquals(users.size()+1, users1.size());
    }

}