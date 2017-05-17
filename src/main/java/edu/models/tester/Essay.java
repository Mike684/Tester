package edu.models.tester;

import java.util.UUID;

/**
 * Is a simple representation of an essay.
 * Created by Mike on 03.05.2017.
 */
public class Essay {

    private UUID essayID;

    private String essay;

    private UUID questionID;

    /**
     * Default constructor.
     */
    public Essay() {
        essayID = UUID.randomUUID();
    }

    /**
     * This is a constructor to initialize entire Essay object.
     * @param essay is an essay text.
     * @param questionID is a question id.
     */
    public Essay(String essay, UUID questionID) {
        essayID = UUID.randomUUID();
        this.essay = essay;
        this.questionID = questionID;
    }

    /**
     * Get essay id.
     * @return essay d.
     */
    public UUID getEssayID() {
        return essayID;
    }

    /**
     * Set essay id.
     * @param essayID is a new essay id.
     */
    public void setEssayID(UUID essayID) {
        this.essayID = essayID;
    }

    /**
     * Get essay text.
     * @return essay text.
     */
    public String getEssay() {
        return essay;
    }

    /**
     * Set essay text.
     * @param essay is a new essay text.
     */
    public void setEssay(String essay) {
        this.essay = essay;
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
     * Get all details about essay in one string.
     * @return essay details string.
     */
    @Override
    public String toString() {
        return "Essay{" +
                "essayID=" + essayID +
                ", essay='" + essay + '\'' +
                ", questionID=" + questionID +
                '}';
    }
}
