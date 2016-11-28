package ru.dimas.brosalin.DAO_IMPL;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ru.dimas.brosalin.DAO.ModelDAOGlobal;
import ru.dimas.brosalin.Models.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */
public class TransactionDAOImpl_VER_2 extends HibernateDaoSupport implements ModelDAOGlobal {

    @Override
    public void save(Object object) {
        Transaction transaction = (Transaction)object;
        getHibernateTemplate().save(transaction);
    }

    @Override
    public Object getModelById(int id) {
        try{
            List<Transaction> transactionList = (List<Transaction>)getHibernateTemplate()
                    .find("from Transaction tran where tran.id=?", id);
            return transactionList.get(0);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getListOfTransactonsByAccountToId(int id) {
        try{
            ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select tran from Transaction tran " +
                            "join tran.accountTo accTo where accTo=?", id);
            return transactionsList;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getListOfTransactionsByUserToId(int id){
        try{
            ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select tran from Transaction tran join " +
                            "tran.accountTo accTo join " +
                            "accTo.user usr where " +
                            "usr.id=?", id);
            return transactionsList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getListOfTransactionsByUserToEmail(String email){
        try{
            ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select tran from Transaction tran join " +
                            "tran.accountTo accTo join " +
                            "accTo.user usr " +
                            "where usr.email=?", email);
            return transactionsList;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getListOfTransactionsByUserToFirsLastName(String firstName, String lastName){
        try{
            ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select tran from Transaction tran join " +
                            "tran.accountTo accTo join " +
                            "accTo.user usr where " +
                            "usr.userFirstName=? and usr.userLastName=?", firstName, lastName);
            return transactionsList;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getListOfTransactionsByUserToPhoneNumber(String phone){
        try{
            ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select tran from Transaction tran join " +
                            "tran.accountTo accTo join " +
                            "accTo.user usr where " +
                            "usr.userPhoneNumber=?", phone);
            return transactionsList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getListOfTransactonsByAccountFromId(int id){
        try{
            ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select tran from Transaction tran join " +
                            "tran.accountFrom accFrom where accFrom.id=?", id);
            return transactionsList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getListOfTransactonsByUserFromId(int id){
        try{
            ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select tran from Transaction tran join " +
                            "tran.accountFrom accFrom join " +
                            "accFrom.user usr where " +
                            "usr.id=?", id);
            return transactionsList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getListOfTransactionsByUserFromEmail(String email){
        try{
            ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select tran from Transaction tran join " +
                            "tran.accountFrom accFrom join " +
                            "accFrom.user usr where " +
                            "usr.email=?", email);
            return transactionsList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getListOfTransactionsByUserFromFirsLastName(String firstName, String lastName){
        try{
            ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select tran from Transaction tran join " +
                            "tran.accountFrom accFrom join " +
                            "accFrom.user usr where " +
                            "usr.userFirstName=? and usr.userLastName=?", firstName, lastName);
            return transactionsList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getListOfTransactionsByUserFromPhoneNumber(String phone){
        try{
            ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)getHibernateTemplate()
                    .find("select tran from Transaction tran join " +
                            "tran.accountFrom accFrom join " +
                            "accFrom.user usr where " +
                            "usr.userPhoneNumber=?", phone);
            return transactionsList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Object object) {
        getHibernateTemplate().update(object);
    }

}
