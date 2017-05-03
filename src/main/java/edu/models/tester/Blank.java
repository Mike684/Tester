package edu.models.tester;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Mike on 02.05.2017.
 */
@Entity
@Table(name = "blank_answers")
public class Blank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "blank_id")
    private UUID blankID;

    @Column(name = "answer")
    private String answer;

    @Column(name = "user_answer")
    private String uAnswer;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

    public Blank() {}

    public Blank(String answer, String uAnswer, Question question) {
        this.answer = answer;
        this.uAnswer = uAnswer;
        this.question = question;
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

    public String getuAnswer() {
        return uAnswer;
    }

    public void setuAnswer(String uAnswer) {
        this.uAnswer = uAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
