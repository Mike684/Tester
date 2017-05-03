package edu.models.tester;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mike on 02.05.2017.
 */
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private UUID questionID;

    @Pattern(regexp = "[A-Z1-9]+.{1,255}")
    @Column(name = "question_text")
    private String text;

    @Column(name = "question_type")
    private String type;

    @Column(name = "max_mark")
    private Double maxMark;

    @OneToMany(mappedBy = "question")
    private List<Blank> blanks = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<Option> options = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<Essay> essayList = new ArrayList<>();

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Question() {}

    public Question(Quiz quiz) {
        this.quiz = quiz;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
