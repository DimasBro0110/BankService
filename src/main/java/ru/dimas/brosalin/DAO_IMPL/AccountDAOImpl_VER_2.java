package ru.dimas.brosalin.DAO_IMPL;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ru.dimas.brosalin.DAO.ModelDAOGlobal;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.Transaction;
import ru.dimas.brosalin.Models.Wallet;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */

public class AccountDAOImpl_VER_2 extends HibernateDaoSupport implements ModelDAOGlobal {

    @Override
    public void save(Object object) {
        Account account = (Account)object;
        getHibernateTemplate().save(account);
    }

    @Override
    public Object getModelById(int id) {
        try{
            List<Account> accountListByID = (ArrayList<Account>)getHibernateTemplate()
                    .find("from Account where accountID=?", id);
            return accountListByID.get(0);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Transaction> getAccountTransactionsToById(int id){
        try{
            List<Transaction> transactionList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select ac.accountTransactionsTo from Account ac where ac.accountID=?", id);
            return transactionList;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Transaction> getAccountTransactionsFromById(int id){
        try{
            List<Transaction> transactionList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select ac.accountTransactionsFrom from Account ac where ac.accountID=?", id);
            return transactionList;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Wallet getWalletFromAccountById(int id){
        try{
            List<Wallet> walletListById = (ArrayList<Wallet>)getHibernateTemplate()
                    .find("select acc.wallet from Account acc where acc.accountID=?", id);
            return walletListById.get(0);
        }catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Object[]> getDetailedTransactionsFromByID(int id){
        try {
            List<Object[]> detailedTransactionFromList = (ArrayList<Object[]>)getHibernateTemplate()
                    .find(
                            "select ac.accountTransactionsFrom, lf from Account ac " +
                            "inner join fetch LegsFrom as lf where ac.accountID=?", id);
            return detailedTransactionFromList;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Object object) {
        getHibernateTemplate().update(object);
    }

}
