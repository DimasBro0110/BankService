package ru.dimas.brosalin.DAO;

import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.dimas.brosalin.DaoInterfaces.ModelLegsFromDAO;
import ru.dimas.brosalin.Models.LegsFrom;
import ru.dimas.brosalin.Models.Wallet;

/**
 * Created by DmitriyBrosalin on 13/10/2016.
 */
public class LegsFromDAOImpl implements ModelLegsFromDAO {

    private SessionFactory sessionFactory;

    public LegsFromDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(LegsFrom legsFrom) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        ru.dimas.brosalin.Models.Transaction transaction = legsFrom.getTransaction();
        Wallet wallet = legsFrom.getWallet();
        wallet = updatedWallet(transaction, wallet);
//        Query query = session.createQuery("UPDATE Wallet w set w.walletBalance=:val where w.id=:wid");
//        query.setParameter("val", wallet.getWalletBalance());
//        query.setParameter("wid", wallet.getWalletID());
//        query.executeUpdate();
        session.update(wallet);
        session.save(legsFrom);
        tr.commit();
        session.close();
    }

    private Wallet updatedWallet(
            ru.dimas.brosalin.Models.Transaction transaction,
            Wallet wallet)
    {
        float oldValue = wallet.getWalletBalance();
        float howMuch = transaction.getTransactionMoney();
        float newValue = oldValue - howMuch;
        wallet.setWalletBalance(newValue);
        return wallet;
    }

    @Override
    public JsonObject getModelById(long id) {
        return null;
    }
}
