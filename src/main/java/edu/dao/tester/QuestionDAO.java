package edu.dao.tester;

import edu.models.tester.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Mike on 02.05.2017.
 */
public class QuestionDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createQuestion(Question question){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(question);
    }

    public void updateQuestion(Question question){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(question);
    }

    public void deleteQuestion(String id){
        Session session = this.sessionFactory.getCurrentSession();
        Question question = (Question) session.load(Question.class, id);

        if (question!=null){
            session.delete(question);
        }
    }

    public Question getQuestionById(String id){
        Session session = this.sessionFactory.getCurrentSession();
        return (Question) session.load(Question.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Question> getAllQuestions() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Question>) session.createQuery("FROM Question").list();
    }

}
