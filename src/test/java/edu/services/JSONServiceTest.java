package edu.services;

import edu.models.tester.*;
import edu.models.users.UAnswer;
import edu.models.users.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * Created by Mike on 16.05.2017.
 */
public class JSONServiceTest {

    JSONService service;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new JSONService();
    }

    @Test
    public void quizJSON() throws IOException {
        Quiz quiz = new Quiz();
        String jsonString = service.toJSON(quiz);
        Quiz quiz1 = service.quizFromJSON(jsonString);
        assertEquals(quiz.toString(),quiz1.toString());
    }

    @Test
    public void questionJSON() throws IOException {
        Question question = new Question();
        String jsonString = service.toJSON(question);
        Question question1 = service.questionFromJSON(jsonString);
        assertEquals(question.toString(),question1.toString());
    }

    @Test
    public void optionJSON() throws IOException {
        Option option = new Option();
        String jsonString = service.toJSON(option);
        Option option1 = service.optionnFromJSON(jsonString);
        assertEquals(option.toString(),option1.toString());
    }

    @Test
    public void blankJSON() throws IOException {
        Blank blank = new Blank();
        String jsonString = service.toJSON(blank);
        Blank blank1 = service.blankFromJSON(jsonString);
        assertEquals(blank.toString(),blank1.toString());
    }

    @Test
    public void essayJSON() throws IOException {
        Essay essay = new Essay();
        String jsonString = service.toJSON(essay);
        Essay essay1 = service.essayFromJSON(jsonString);
        assertEquals(essay.toString(),essay1.toString());
    }

    @Test
    public void userJSON() throws IOException {
        User user = new User();
        String jsonString = service.toJSON(user);
        User user1 = service.userFromJSON(jsonString);
        assertEquals(user.toString(),user1.toString());
    }

    @Test
    public void uAnswerJSON() throws IOException {
        UAnswer uAnswer = new UAnswer();
        String jsonString = service.toJSON(uAnswer);
        UAnswer uAnswer1 = service.uAnswerFromJSON(jsonString);
        assertEquals(uAnswer.toString(),uAnswer1.toString());
    }

}