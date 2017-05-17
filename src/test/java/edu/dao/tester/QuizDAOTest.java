package edu.dao.tester;

import edu.dao.users.UserDAO;
import edu.models.tester.Quiz;
import edu.models.users.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Mike on 16.05.2017.
 */
public class QuizDAOTest {

    @Test
    public void testQuiz() throws SQLException {
        Quiz quiz = new Quiz("theme");
        new QuizDAO().createQuiz(quiz);
        Quiz quiz1 = new QuizDAO().getQuizById(quiz.getQuizID());
        Assert.assertEquals(quiz.toString(),quiz1.toString());

        quiz.setTheme("theme2");
        new QuizDAO().updateQuiz(quiz);
        quiz1 = new QuizDAO().getQuizById(quiz.getQuizID());
        Assert.assertEquals(quiz.toString(),quiz1.toString());

        List<Quiz> quizList = new QuizDAO().getAllQuizzes();
         new QuizDAO().createQuiz(new Quiz());
        List<Quiz> quizList1 = new QuizDAO().getAllQuizzes();
        assertEquals(quizList.size()+1, quizList1.size());
    }

}