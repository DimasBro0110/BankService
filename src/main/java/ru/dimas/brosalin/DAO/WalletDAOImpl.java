package ru.dimas.brosalin.DAO;

import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.dimas.brosalin.DaoInterfaces.ModelWalletDAO;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.Models.Wallet;

/**
 * Created by DmitriyBrosalin on 10/10/2016.
 */
public class WalletDAOImpl implements ModelWalletDAO {

    private SessionFactory sessionFactory;

    public WalletDAOImpl(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;

    }


    @Override
    public void save(Wallet wallet) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(wallet);
        tr.commit();
        session.close();
    }

    @Override
    public JsonObject getModelById(long id) {
        return null;
    }

    @Override
    public void update(Wallet wallet) {

    }

    @Override
    public JsonObject getModels() {
        return null;
    }

    @Override
    public Wallet getModelByNumber(long number) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery("FROM Wallet WHERE walletNumber=:num");
        query.setParameter("num", number);
        Wallet wallet = (Wallet) query.getSingleResult();
        tr.commit();
        session.close();
        return wallet;
    }

    @Override
    public Wallet getWalletByCurrencyAndAccount(String currency, Account account) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery(
                "select w FROM Wallet w join w.account a where w.walletCurrency=:cur and a.id=:aid"
        );
        query.setParameter("cur", currency);
        query.setParameter("aid", account.getAccountID());
        Wallet wallet = (Wallet) query.getSingleResult();
        tr.commit();
        session.close();
        return wallet;
    }

    @Override
    public Wallet getWaletByUserAndNumber(User user, String currency) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Account account = user.getAccount();
        Query query = session.createQuery(
                "from Account a join a.wallet wallet where wallet.walletCurrency=:cur and a.id=:id"
        );
        query.setParameter("id", account.getAccountID());
        query.setParameter("cur", currency);
        Wallet wallet = (Wallet) query.getSingleResult();
        tr.commit();
        session.close();
        return wallet;
    }
}
