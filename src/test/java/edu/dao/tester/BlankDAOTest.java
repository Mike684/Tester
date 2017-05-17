package edu.dao.tester;

import edu.models.tester.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Mike on 16.05.2017.
 */
public class BlankDAOTest {

    @Test
    public void createAndGet() throws SQLException {
        Quiz quiz = new Quiz("theme");

        Question question = new Question();
        question.setQuizID(quiz.getQuizID());
        question.setText("question");
        question.setType(QuestionType.TEST);
        question.setMaxMark(5.0);

        Blank blank = new Blank();
        blank.setQuestionID(question.getQuestionID());
        blank.setAnswer("answer");

        new QuizDAO().createQuiz(quiz);
        new QuestionDAO().createQuestion(question);
        new BlankDAO().createBlank(blank);

        Blank blank1 = new BlankDAO().getBlankById(blank.getBlankID());
        Assert.assertEquals(blank.toString(), blank1.toString());

        blank.setAnswer("answer2");
        new BlankDAO().updateBlank(blank);
        blank1 = new BlankDAO().getBlankById(blank.getBlankID());
        Assert.assertEquals(blank.toString(), blank1.toString());

        List<Blank> blanks = new BlankDAO().getAllBlanks();
        new OptionDAO().createOption(new Option());
        List<Blank> blanks1 = new BlankDAO().getAllBlanks();
        assertEquals(blanks.size()+1, blanks1.size());
    }

}