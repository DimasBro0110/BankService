package ru.dimas.brosalin.DAO;

import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.dimas.brosalin.DaoInterfaces.ModelLegsToDAO;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.LegsTo;
import ru.dimas.brosalin.Models.Wallet;

import java.util.Set;

/**
 * Created by DmitriyBrosalin on 12/10/2016.
 */
public class LegsToDAOImpl implements ModelLegsToDAO {

    private SessionFactory sessionFactory;

    public LegsToDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(LegsTo legsTo) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        ru.dimas.brosalin.Models.Transaction transaction = legsTo.getTransaction();
        Wallet wallet = legsTo.getWallet();
        Wallet toUpdate = updatedWallet(transaction, wallet);
//        Query query = session.createQuery("UPDATE Wallet w set w.walletBalance=:val where w.id=:wid");
//        query.setParameter("val", toUpdate.getWalletBalance());
//        query.setParameter("wid", toUpdate.getWalletID());
//        query.executeUpdate();
        session.update(toUpdate);
        session.save(legsTo);
        tr.commit();
        session.close();
    }

    private Wallet updatedWallet(
            ru.dimas.brosalin.Models.Transaction transaction,
            Wallet wallet
    ){
        float howMuch = transaction.getTransactionMoney();
        float koeff = transaction.getCurrency().getKoeff();
        float result = howMuch * koeff;
        float howMuchWas = wallet.getWalletBalance();
        float newVal = howMuchWas + result;
        wallet.setWalletBalance(newVal);
        return wallet;
    }

    @Override
    public JsonObject getModelById(long id) {
        return null;
    }

    @Override
    public Wallet getModelByNumber(long number) {
        return null;
    }
}
