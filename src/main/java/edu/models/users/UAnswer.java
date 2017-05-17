package edu.models.users;

import java.util.UUID;

/**
 * UAnswer represents a main information about user answers.
 * Created by Mike on 02.05.2017.
 */

public class UAnswer {

    private UUID answerID;

    private UUID userID;

    private UUID questionID;

    private String answer;

    private Double mark;

    /**
     * This is default constructor.
     */
    public UAnswer() {
        answerID = UUID.randomUUID();
    }

    /**
     * This is a constructor to initialize entire UAnswer object.
     * @param userID is an user id.
     * @param questionID is a question id.
     * @param answer is an user answer.
     * @param mark is a question mark.
     */
    public UAnswer(UUID userID, UUID questionID, String answer, Double mark) {
        answerID = UUID.randomUUID();
        this.userID = userID;
        this.questionID = questionID;
        this.answer = answer;
        this.mark = mark;
    }

    /**
     * Get user answer id.
     * @return answer id.
     */
    public UUID getAnswerID() {
        return answerID;
    }

    /**
     * Set answer id.
     * @param answerID is a new answer id.
     */
    public void setAnswerID(UUID answerID) {
        this.answerID = answerID;
    }

    /**
     * Get user id.
     * @return user id.
     */
    public UUID getUserID() {
        return userID;
    }

    /**
     * Set user id.
     * @param userID is a new bound user id.
     */
    public void setUserID(UUID userID) {
        this.userID = userID;
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
     * @param questionID is a new bound question id.
     */
    public void setQuestionID(UUID questionID) {
        this.questionID = questionID;
    }

    /**
     * Get uaer answer.
     * @return answer.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Set user answer.
     * @param answer is a new bound user answer.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Get current question mark.
     * @return current mark.
     */
    public Double getMark() {
        return mark;
    }

    /**
     * Set question mark.
     * @param mark is a new bound question mark.
     */
    public void setMark(Double mark) {
        this.mark = mark;
    }

    /**
     * Get all detatils about user answer in one string.
     * @return answer details string.
     */
    @Override
    public String toString() {
        return "UAnswer{" +
                "answerID=" + answerID +
                ", userID=" + userID +
                ", questionID=" + questionID +
                ", answer='" + answer + '\'' +
                ", mark=" + mark +
                '}';
    }
}
