package edu.models.tester;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Mike on 02.05.2017.
 */
@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "option_id")
    private UUID optionID;

    @Column(name = "option")
    private String option;

    @Column(name = "answer")
    private Boolean answer;

    @Column(name = "user_answer")
    private Boolean uAnswer;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

    public Option() {}

    public Option(String option, Boolean answer, Boolean uAnswer, Question question) {
        this.option = option;
        this.answer = answer;
        this.uAnswer = uAnswer;
        this.question = question;
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

    public Boolean getuAnswer() {
        return uAnswer;
    }

    public void setuAnswer(Boolean uAnswer) {
        this.uAnswer = uAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
