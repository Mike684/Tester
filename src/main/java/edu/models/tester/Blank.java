package edu.models.tester;

import java.util.UUID;

/**
 * Created by Mike on 02.05.2017.
 */
public class Blank {

    private UUID blankID;

    private String answer;

    private String uAnswer;

    private UUID questionID;

    public Blank() {
        blankID = UUID.randomUUID();
    }

    public Blank(String answer, String uAnswer, UUID questionID) {
        blankID = UUID.randomUUID();
        this.answer = answer;
        this.uAnswer = uAnswer;
        this.questionID = questionID;
    }

    public UUID getBlankID() {
        return blankID;
    }

    public void setBlankID(UUID blankID) {
        this.blankID = blankID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUAnswer() {
        return uAnswer;
    }

    public void setUAnswer(String uAnswer) {
        this.uAnswer = uAnswer;
    }

    public UUID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(UUID questionID) {
        this.questionID = questionID;
    }
}
