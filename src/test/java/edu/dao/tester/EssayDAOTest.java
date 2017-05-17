package edu.dao.tester;

import edu.models.tester.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Mike on 16.05.2017.
 */
public class EssayDAOTest {

    @Test
    public void createAndGet() throws SQLException {
        Quiz quiz = new Quiz("theme");

        Question question = new Question();
        question.setQuizID(quiz.getQuizID());
        question.setText("question");
        question.setType(QuestionType.TEST);
        question.setMaxMark(5.0);

        Essay essay = new Essay();
        essay.setQuestionID(question.getQuestionID());

        new QuizDAO().createQuiz(quiz);
        new QuestionDAO().createQuestion(question);
        new EssayDAO().createEssay(essay);

        Essay essay1 = new EssayDAO().getEssayById(essay.getEssayID());
        Assert.assertEquals(essay.toString(), essay1.toString());

        essay.setEssay("essay");
        new EssayDAO().updateEssay(essay);
        essay1 = new EssayDAO().getEssayById(essay.getEssayID());
        Assert.assertEquals(essay.toString(), essay1.toString());

        List<Essay> essayList = new EssayDAO().getAllEssays();
        new EssayDAO().createEssay(new Essay());
        List<Essay> essayList1 = new EssayDAO().getAllEssays();
        assertEquals(essayList.size()+1, essayList1.size());
    }

}