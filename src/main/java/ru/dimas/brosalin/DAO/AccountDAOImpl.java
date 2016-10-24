package ru.dimas.brosalin.DAO;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.dimas.brosalin.DaoInterfaces.ModelAccountDAO;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.Models.Wallet;

import java.util.List;
import java.util.Set;

/**
 * Created by DmitriyBrosalin on 08/10/2016.
 */
public class AccountDAOImpl implements ModelAccountDAO {

    private SessionFactory sessionFactory;

    public AccountDAOImpl(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;

    }


    @Override
    public void save(Account account) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(account);
        tr.commit();
        session.close();
    }

    @Override
    public JsonObject getModelById(long id) {
        return null;
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public JsonObject getModels() {
        return null;
    }

    @Override
    public User getAccountByUserEmail(String userEmail) {
        return null;
    }

    @Override
    public Account getModelByUserEmailAndName(String email, String name) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery(
                "select a from Account a join a.user u where u.email=:mail and u.userFirstName=:name"
        );
        query.setParameter("mail", email);
        query.setParameter("name", name);
        Account account = (Account)query.getSingleResult();

        tr.commit();
        session.close();
        return account;
    }
}