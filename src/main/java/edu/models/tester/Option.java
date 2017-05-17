package edu.models.tester;

import java.util.UUID;

/**
 * Option is a simple representation of an test option.
 * Created by Mike on 02.05.2017.
 */
public class Option {

    private UUID optionID;

    private String option;

    private Boolean answer;

    private Boolean uAnswer;

    private UUID questionID;

    /**
     * Default constructor.
     */
    public Option() {
        optionID = UUID.randomUUID();
    }

    /**
     * This is a constructor to initialize entire Option object.
     * @param option is a test option.
     * @param answer is an option answer.
     * @param uAnswer is an user answer.
     * @param questionID is a question id.
     */
    public Option(String option, Boolean answer, Boolean uAnswer, UUID questionID) {
        optionID = UUID.randomUUID();
        this.option = option;
        this.answer = answer;
        this.uAnswer = uAnswer;
        this.questionID = questionID;
    }

    /**
     * Get option id.
     * @return option id.
     */
    public UUID getOptionID() {
        return optionID;
    }

    /**
     * Set option id.
     * @param optionID is a new option id.
     */
    public void setOptionID(UUID optionID) {
        this.optionID = optionID;
    }

    /**
     * Get option text.
     * @return option text.
     */
    public String getOption() {
        return option;
    }

    /**
     * Set option text.
     * @param option is a new option text.
     */
    public void setOption(String option) {
        this.option = option;
    }

    /**
     * Get option answer.
     * @return option answer.
     */
    public Boolean getAnswer() {
        return answer;
    }

    /**
     * Set option answer.
     * @param answer is a new option answer.
     */
    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    /**
     * Get user answer.
     * @return user answer.
     */
    public Boolean getUAnswer() {
        return uAnswer;
    }

    /**
     * Set user answer.
     * @param uAnswer is a new user answer.
     */
    public void setUAnswer(Boolean uAnswer) {
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
     * Set qeustion id.
     * @param questionID is a new question id.
     */
    public void setQuestionID(UUID questionID) {
        this.questionID = questionID;
    }

    /**
     * Get all details about option in one string.
     * @return option details string.
     */
    @Override
    public String toString() {
        return "Option{" +
                "optionID=" + optionID +
                ", option='" + option + '\'' +
                ", answer=" + answer +
                ", uAnswer=" + uAnswer +
                ", questionID=" + questionID +
                '}';
    }
}
