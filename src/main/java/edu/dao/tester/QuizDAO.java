package edu.dao.tester;

import edu.models.tester.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Mike on 02.05.2017.
 */
public class QuizDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createQuiz(Quiz quiz){
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(quiz);
            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void updateQuiz(Quiz quiz){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(quiz);
    }

    public void deleteQuiz(String id){
        Session session = this.sessionFactory.getCurrentSession();
        Quiz quiz = (Quiz) session.load(Quiz.class, id);

        if (quiz!=null){
            session.delete(quiz);
        }
    }

    public Quiz getQuizById(String id){
        Session session = this.sessionFactory.getCurrentSession();
        return (Quiz) session.load(Quiz.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Quiz> getAllQuizzes() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Quiz>) session.createQuery("FROM Quiz ").list();
    }

}
