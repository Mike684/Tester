package edu.models.tester;

import java.util.UUID;

/**
 * Blank is a simple representation of a open question answer blank.
 * Created by Mike on 02.05.2017.
 */
public class Blank {

    private UUID blankID;

    private String answer;

    private String uAnswer;

    private UUID questionID;

    /**
     * Default constructor.
     */
    public Blank() {
        blankID = UUID.randomUUID();
    }

    /**
     * This is a constructor to initialize entire Blank object.
     * @param answer is an blank answer.
     * @param uAnswer is an user answer.
     * @param questionID is a cquestion id.
     */
    public Blank(String answer, String uAnswer, UUID questionID) {
        blankID = UUID.randomUUID();
        this.answer = answer;
        this.uAnswer = uAnswer;
        this.questionID = questionID;
    }

    /**
     * Get blank id.
     * @return blank id.
     */
    public UUID getBlankID() {
        return blankID;
    }

    /**
     * Set blank id.
     * @param blankID is a new blank id.
     */
    public void setBlankID(UUID blankID) {
        this.blankID = blankID;
    }

    /**
     * Get answer text.
     * @return answer text.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Set answer text.
     * @param answer is a new answer text.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Get user answer.
     * @return user answer.
     */
    public String getUAnswer() {
        return uAnswer;
    }

    /**
     * Set user anwser.
     * @param uAnswer is a new user answer.
     */
    public void setUAnswer(String uAnswer) {
        this.uAnswer = uAnswer;
    }

    /**
     * Get question id.
     * @return question id.
     */
    public UUID getQuestionID() {
        return questionID;
    }

    /**
     * Set question id.
     * @param questionID is a new question id.
     */
    public void setQuestionID(UUID questionID) {
        this.questionID = questionID;
    }

    /**
     * Get all details about blank in one string.
     * @return blank details string.
     */
    @Override
    public String toString() {
        return "Blank{" +
                "blankID=" + blankID +
                ", answer='" + answer + '\'' +
                ", uAnswer='" + uAnswer + '\'' +
                ", questionID=" + questionID +
                '}';
    }
}
