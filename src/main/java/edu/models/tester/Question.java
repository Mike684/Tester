package edu.models.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mike on 02.05.2017.
 */
public class Question {

    private UUID questionID;

    private String text;

    private QuestionType type;

    private Double maxMark;

    private List<Blank> blanks = new ArrayList<>();

    private List<Option> options = new ArrayList<>();

    private List<Essay> essayList = new ArrayList<>();

    private UUID quizID;

    public Question() {
        questionID = UUID.randomUUID();
    }

    public Question(UUID questionID, String text, QuestionType type, Double maxMark, List<Blank> blanks, List<Option> options, List<Essay> essayList, UUID quizID) {
        questionID = UUID.randomUUID();
        this.text = text;
        this.type = type;
        this.maxMark = maxMark;
        this.blanks = blanks;
        this.options = options;
        this.essayList = essayList;
        this.quizID = quizID;
    }

    public UUID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(UUID questionID) {
        this.questionID = questionID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public Double getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(Double maxMark) {
        this.maxMark = maxMark;
    }

    public List<Blank> getBlanks() {
        return blanks;
    }

    public void setBlanks(List<Blank> blanks) {
        this.blanks = blanks;
    }

    public void addBlank(Blank blank) {
        blanks.add(blank);
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public UUID getQuizID() {
        return quizID;
    }

    public void setQuizID(UUID quizID) {
        this.quizID = quizID;
    }
}
