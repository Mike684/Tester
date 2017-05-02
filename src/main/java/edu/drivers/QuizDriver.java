package edu.drivers;

import edu.creator.QuizMaker;
import edu.dao.tester.QuizDAO;
import edu.models.tester.Quiz;
import edu.services.FileService;
import edu.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Mike on 20.04.2017.
 */
public class QuizDriver {
    public static void main(String[] args) throws IOException, SQLException {

        Quiz quiz = new Quiz();
        quiz.setTheme("SomeTheme");
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();

            QuizDAO quizDAO = new QuizDAO();
            quizDAO.setSessionFactory(sessionFactory);
            quizDAO.createQuiz(quiz);





//        new FileService().writeToJSON(quizMaker);
    }
}
