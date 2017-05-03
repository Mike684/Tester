package edu.models.tester;

import java.util.UUID;

/**
 * Created by Mike on 03.05.2017.
 */
public class Essay {

    private UUID essayID;

    private String essay;

    private UUID questionID;

    public Essay() {
        essayID = UUID.randomUUID();
    }

    public Essay(String essay, UUID questionID) {
        essayID = UUID.randomUUID();
        this.essay = essay;
        this.questionID = questionID;
    }

    public UUID getEssayID() {
        return essayID;
    }

    public void setEssayID(UUID essayID) {
        this.essayID = essayID;
    }

    public String getEssay() {
        return essay;
    }

    public void setEssay(String essay) {
        this.essay = essay;
    }

    public UUID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(UUID questionID) {
        this.questionID = questionID;
    }
}
