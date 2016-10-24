package ru.dimas.brosalin.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import ru.dimas.brosalin.DaoInterfaces.ModelCurrencyDAO;
import ru.dimas.brosalin.Models.Currency;

/**
 * Created by DmitriyBrosalin on 13/10/2016.
 */
public class CurrencyDAOImpl implements ModelCurrencyDAO {

    private SessionFactory sessionFactory;

    public CurrencyDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Currency currency) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(currency);
        tr.commit();
        session.close();
    }

    @Override
    public Currency getModelBuId(long id) {
        return null;
    }

    @Override
    public Currency getModelByFromTo(String from, String to) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery("from Currency where currencyFromName=:fro and currencyToName=:to");
        query.setParameter("fro", from);
        query.setParameter("to", to);
        Currency currency = (Currency) query.list().get(0);
        tr.commit();
        session.close();
        return currency;
    }
}
