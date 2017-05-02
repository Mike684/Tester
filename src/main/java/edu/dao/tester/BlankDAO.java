package edu.dao.tester;

import edu.models.tester.Blank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Mike on 02.05.2017.
 */
public class BlankDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createBlank(Blank blank){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(blank);
    }

    public void updateBlank(Blank blank){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(blank);
    }

    public void deleteBook(String id){
        Session session = this.sessionFactory.getCurrentSession();
        Blank blank = (Blank) session.load(Blank.class, id);

        if (blank!=null){
            session.delete(blank);
        }
    }

    public Blank getBlankById(String id){
        Session session = this.sessionFactory.getCurrentSession();
        return (Blank) session.load(Blank.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Blank> getAllBlanks() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Blank>) session.createQuery("FROM Blank").list();
    }
}
