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
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quiz_id")
    private UUID quizID;

    @Pattern(regexp = "[A-Z1-9]+.{1,64}")
    @Column(name = "theme")
    private String theme;

    @OneToMany(mappedBy = "quiz")
    private List<Question> questions = new ArrayList<>();

    public Quiz() {}

    public UUID getQuizID() {
        return quizID;
    }

    public void setQuizID(UUID quizID) {
        this.quizID = quizID;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
