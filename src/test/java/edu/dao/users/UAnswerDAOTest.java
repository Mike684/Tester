package edu.dao.users;

import edu.dao.tester.*;
import edu.models.tester.*;
import edu.models.users.UAnswer;
import edu.models.users.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Mike on 16.05.2017.
 */
public class UAnswerDAOTest {

    @Test
    public void createAndGet() throws SQLException {
        User user = new User();
        user.setUserName("uName");
        user.setPassword("password1");

        Quiz quiz = new Quiz("theme");

        Question question = new Question();
        question.setQuizID(quiz.getQuizID());
        question.setText("question");
        question.setType(QuestionType.TEST);
        question.setMaxMark(5.0);

        Essay essay = new Essay();
        essay.setQuestionID(question.getQuestionID());

        UAnswer uAnswer = new UAnswer();
        uAnswer.setQuestionID(question.getQuestionID());
        uAnswer.setUserID(user.getUserID());
        uAnswer.setAnswer("answer");
        uAnswer.setMark(4.0);

        new QuizDAO().createQuiz(quiz);
        new QuestionDAO().createQuestion(question);
        new EssayDAO().createEssay(essay);

        new UserDAO().createUser(user);

        new UAnswerDAO().createUAnswer(uAnswer);
        UAnswer uAnswer1 = new UAnswerDAO().getUAnswerById(uAnswer.getAnswerID());
        Assert.assertEquals(uAnswer.toString(), uAnswer1.toString());

        uAnswer.setAnswer("answer2");
        new UAnswerDAO().updateUAnswer(uAnswer);
        uAnswer1 = new UAnswerDAO().getUAnswerById(uAnswer.getAnswerID());
        Assert.assertEquals(uAnswer.toString(), uAnswer1.toString());

        List<UAnswer> uAnswers = new UAnswerDAO().getAllUAnswers();
        new UAnswerDAO().createUAnswer(new UAnswer());
        List<UAnswer> uAnswers1 = new UAnswerDAO().getAllUAnswers();
        assertEquals(uAnswers.size()+1, uAnswers1.size());

    }

}