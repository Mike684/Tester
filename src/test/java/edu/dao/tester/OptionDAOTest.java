package edu.dao.tester;

import edu.models.tester.Option;
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
public class OptionDAOTest {

    @Test
    public void createAndTest() throws SQLException {
        Quiz quiz = new Quiz("theme");

        Question question = new Question();
        question.setQuizID(quiz.getQuizID());
        question.setText("question");
        question.setType(QuestionType.TEST);
        question.setMaxMark(5.0);

        Option option = new Option();
        option.setQuestionID(question.getQuestionID());
        option.setOption("option");
        option.setAnswer(false);

        new QuizDAO().createQuiz(quiz);
        new QuestionDAO().createQuestion(question);
        new OptionDAO().createOption(option);

        Option option1 = new OptionDAO().getOptionById(option.getOptionID());
        Assert.assertEquals(option.toString(), option1.toString());

        option.setOption("option2");
        new OptionDAO().updateOption(option);
        option1 = new OptionDAO().getOptionById(option.getOptionID());
        Assert.assertEquals(option.toString(), option1.toString());

        List<Option> options = new OptionDAO().getAllOptions();
        new OptionDAO().createOption(new Option());
        List<Option> options1 = new OptionDAO().getAllOptions();
        assertEquals(options.size()+1, options1.size());

    }

}