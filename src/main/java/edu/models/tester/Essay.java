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


}
