package edu.models.tester;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Mike on 03.05.2017.
 */
@Entity
@Table(name = "essay_table")
public class Essay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "essay_id")
    private UUID essayID;

    @Column(name = "essay")
    private String essay;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

    public Essay() {}

    public Essay(String essay, Question question) {
        this.essay = essay;
        this.question = question;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
