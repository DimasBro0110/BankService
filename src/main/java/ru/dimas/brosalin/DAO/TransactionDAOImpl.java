package ru.dimas.brosalin.DAO;

import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dimas.brosalin.DaoInterfaces.ModelTransactionDAO;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.LegsFrom;
import ru.dimas.brosalin.Models.LegsTo;
import ru.dimas.brosalin.Models.Transaction;

import java.sql.Timestamp;

/**
 * Created by DmitriyBrosalin on 12/10/2016.
 */
public class TransactionDAOImpl implements ModelTransactionDAO {

    private SessionFactory sessionFactory;

    public TransactionDAOImpl(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;

    }

    @Override
    public void save(Transaction transaction) {
        Session session = this.sessionFactory.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        session.save(transaction);
        tr.commit();
        session.close();
    }

    @Override
    public JsonObject getModelById(long id) {
        return null;
    }
}