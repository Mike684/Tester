package edu.dao.tester;

import edu.models.tester.Option;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Mike on 02.05.2017.
 */
public class OptionDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createOption(Option option){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(option);
    }

    public void updateOption(Option option){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(option);
    }

    public void deleteOption(String id){
        Session session = this.sessionFactory.getCurrentSession();
        Option option = (Option) session.load(Option.class, id);

        if (option!=null){
            session.delete(option);
        }
    }

    public Option getOptionById(String id){
        Session session = this.sessionFactory.getCurrentSession();
        return (Option) session.load(Option.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Option> getAllOptions() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Option>) session.createQuery("FROM Option").list();
    }

}
