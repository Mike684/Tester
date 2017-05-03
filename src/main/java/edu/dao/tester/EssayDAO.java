package edu.dao.tester;

import edu.models.tester.Blank;
import edu.models.tester.Essay;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Mike on 03.05.2017.
 */
public class EssayDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createEssay(Essay essay){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(essay);
    }

    public void updateEssay(Essay essay){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(essay);
    }

    public void deleteEssay(String id){
        Session session = this.sessionFactory.getCurrentSession();
        Essay essay = (Essay) session.load(Essay.class, id);

        if (essay!=null){
            session.delete(essay);
        }
    }

    public Essay getEssayById(String id){
        Session session = this.sessionFactory.getCurrentSession();
        return (Essay) session.load(Essay.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Essay> getAllBlanks() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Essay>) session.createQuery("FROM Essay").list();
    }

}
