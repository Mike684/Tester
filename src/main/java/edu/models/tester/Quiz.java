package edu.models.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Quiz is a simple representation of a quiz.
 * Created by Mike on 02.05.2017.
 */
public class Quiz {

    private UUID quizID;

    private String theme;

    private List<Question> questions = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Quiz() {
        quizID = UUID.randomUUID();
    }

    /**
     * This is a constructor to initialize entire Quiz object.
     * @param theme
     */
    public Quiz(String theme) {
        quizID = UUID.randomUUID();
        this.theme = theme;
    }

    /**
     * Get quiz id.
     * @return quiz id.
     */
    public UUID getQuizID() {
        return quizID;
    }

    /**
     * Set quiz id.
     * @param quizID is a new quiz id.
     */
    public void setQuizID(UUID quizID) {
        this.quizID = quizID;
    }

    /**
     * Get quiz theme.
     * @return quiz theme.
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Set quiz theme.
     * @param theme is a new quiz theme.
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Get all questions of current quiz.
     * @return question list.
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Set question list.
     * @param questions is a new question list.
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Add new question to quiz.
     * @param question is a new question.
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * Get all details about quiz in one string.
     * @return quiz details string.
     */
    @Override
    public String toString() {
        return "Quiz{" +
                "quizID=" + quizID +
                ", theme='" + theme + '\'' +
                ", questions=" + questions +
                '}';
    }
}
