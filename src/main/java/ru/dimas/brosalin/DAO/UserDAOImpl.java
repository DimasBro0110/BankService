package ru.dimas.brosalin.DAO;

import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.dimas.brosalin.DaoInterfaces.ModelUserDAO;
import ru.dimas.brosalin.Models.User;

/**
 * Created by DmitriyBrosalin on 08/10/2016.
 */
public class UserDAOImpl implements ModelUserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;

    }

    public UserDAOImpl(){

    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {

        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(user);
        tr.commit();
        session.close();

    }

    @Override
    public User getModelById(long id) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        User user = session.find(User.class, id);
        tr.commit();
        session.close();
        return user;
    }

    @Override
    public User getModelByName(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery("FROM User where userFirstName=:name");
        User user = (User)query.setParameter("name", name).getSingleResult();
        tr.commit();
        session.close();
        return user;
    }

    @Override
    public User getModelByEmail(String email) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery("FROM User where userFirstName=:email");
        User user = (User)query.setParameter("email", email).getSingleResult();
        tr.commit();
        session.close();
        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public JsonObject getModels() {
        return null;
    }
}
