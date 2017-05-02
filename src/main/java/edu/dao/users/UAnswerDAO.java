package edu.dao.users;

import edu.models.users.UAnswer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Mike on 02.05.2017.
 */
public class UAnswerDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createUAnswer(UAnswer uAnswer){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(uAnswer);
    }

    public void updateUAnswer(UAnswer uAnswer){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(uAnswer);
    }

    public void deleteUAnswer(String id){
        Session session = this.sessionFactory.getCurrentSession();
        UAnswer uAnswer = (UAnswer) session.load(UAnswer.class, id);

        if (uAnswer!=null){
            session.delete(uAnswer);
        }
    }

    public UAnswer getUAnswerById(String id){
        Session session = this.sessionFactory.getCurrentSession();
        return (UAnswer) session.load(UAnswer.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<UAnswer> getAllUAnswers() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<UAnswer>) session.createQuery("FROM UAnswer ").list();
    }

}
