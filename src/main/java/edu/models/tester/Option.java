package edu.models.tester;

import java.util.UUID;

/**
 * Created by Mike on 02.05.2017.
 */
public class Option {

    private UUID optionID;

    private String option;

    private Boolean answer;

    private Boolean uAnswer;

    private UUID questionID;

    public Option() {
        optionID = UUID.randomUUID();
    }

    public Option(String option, Boolean answer, Boolean uAnswer, UUID questionID) {
        optionID = UUID.randomUUID();
        this.option = option;
        this.answer = answer;
        this.uAnswer = uAnswer;
        this.questionID = questionID;
    }

    public UUID getOptionID() {
        return optionID;
    }

    public void setOptionID(UUID optionID) {
        this.optionID = optionID;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public Boolean getUAnswer() {
        return uAnswer;
    }

    public void setUAnswer(Boolean uAnswer) {
        this.uAnswer = uAnswer;
    }

    public UUID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(UUID questionID) {
        this.questionID = questionID;
    }
}
