package edu.dao.tester;

import edu.models.tester.Question;
import edu.models.tester.QuestionType;
import edu.models.tester.Quiz;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Mike on 16.05.2017.
 */
public class QuestionDAOTest {

    @Test
    public void testQuestion() throws SQLException {
        Quiz quiz = new Quiz("theme");
        Question question = new Question();
        question.setQuizID(quiz.getQuizID());
        question.setText("question");
        question.setType(QuestionType.TEST);
        question.setMaxMark(5.0);

        new QuizDAO().createQuiz(quiz);
        new QuestionDAO().createQuestion(question);
        Question question1 = new QuestionDAO().getQuestionById(question.getQuestionID());
        Assert.assertEquals(question.toString(), question1.toString());

        question.setText("question2");
        new QuestionDAO().updateQuestion(question);
        question1 = new QuestionDAO().getQuestionById(question.getQuestionID());
        Assert.assertEquals(question.toString(), question1.toString());

        List<Question> questions = new QuestionDAO().getAllQuestions();
        new QuestionDAO().createQuestion(new Question());
        List<Question> questions1 = new QuestionDAO().getAllQuestions();
        assertEquals(questions.size()+1, questions1.size());
    }

}