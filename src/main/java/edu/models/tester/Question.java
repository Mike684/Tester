package edu.models.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Question is a simple representation of a question.
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

    /**
     * Default constructor.
     */
    public Question() {
        questionID = UUID.randomUUID();
    }

    /**
     * This is a constructor to initialize entire Question object.
     * @param text is a question text.
     * @param type is a question type.
     * @param maxMark is a question max mark.
     * @param blanks is a list of an open question answer blanks.
     * @param options is a list of test options.
     * @param essayList is an essay list.
     * @param quizID is a quiz id.
     */
    public Question(String text, QuestionType type, Double maxMark, List<Blank> blanks, List<Option> options, List<Essay> essayList, UUID quizID) {
        questionID = UUID.randomUUID();
        this.text = text;
        this.type = type;
        this.maxMark = maxMark;
        this.blanks = blanks;
        this.options = options;
        this.essayList = essayList;
        this.quizID = quizID;
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
     * Get question text.
     * @return question text.
     */
    public String getText() {
        return text;
    }

    /**
     * Set question text.
     * @param text is a new question text.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get question type.
     * @return question type.
     */
    public QuestionType getType() {
        return type;
    }

    /**
     * Set question type.
     * @param type is a new question type.
     */
    public void setType(QuestionType type) {
        this.type = type;
    }

    /**
     * get question max mark.
     * @return question max mark.
     */
    public Double getMaxMark() {
        return maxMark;
    }

    /**
     * Set question max mark.
     * @param maxMark is a new question max mark.
     */
    public void setMaxMark(Double maxMark) {
        this.maxMark = maxMark;
    }

    /**
     * Get all answer blanks.
     * @return answer blanks.
     */
    public List<Blank> getBlanks() {
        return blanks;
    }

    /**
     * Set answer blanks.
     * @param blanks is a new answer blanks.
     */
    public void setBlanks(List<Blank> blanks) {
        this.blanks = blanks;
    }

    /**
     * Add new answer blank to question.
     * @param blank is a new asnwer blank.
     */
    public void addBlank(Blank blank) {
        blanks.add(blank);
    }

    /**
     * Get test option list.
     * @return option list.
     */
    public List<Option> getOptions() {
        return options;
    }

    /**
     * Set test option list.
     * @param options is a new option list.
     */
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    /**
     * Add new test option.
     * @param option is a new test option.
     */
    public void addOption(Option option) {
        options.add(option);
    }

    /**
     * Get quiz id.
     * @return current question quiz id.
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
     * Get all details about question in one string.
     * @return question details string.
     */
    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", text='" + text + '\'' +
                ", type=" + type +
                ", maxMark=" + maxMark +
                ", blanks=" + blanks +
                ", options=" + options +
                ", essayList=" + essayList +
                ", quizID=" + quizID +
                '}';
    }
}
