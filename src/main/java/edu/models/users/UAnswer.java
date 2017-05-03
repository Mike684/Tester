package edu.models.users;

import java.util.UUID;

/**
 * Created by Mike on 02.05.2017.
 */

public class UAnswer {

    private UUID answerID;

    private UUID userID;

    private UUID questionID;

    private String answer;

    private String mark;

    public UAnswer() {
        answerID = UUID.randomUUID();
    }

    public UAnswer(UUID userID, UUID questionID, String answer, String mark) {
        answerID = UUID.randomUUID();
        this.userID = userID;
        this.questionID = questionID;
        this.answer = answer;
        this.mark = mark;
    }

    public UUID getAnswerID() {
        return answerID;
    }

    public void setAnswerID(UUID answerID) {
        this.answerID = answerID;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public UUID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(UUID questionID) {
        this.questionID = questionID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
