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

    public Account getAccountByUserFirstLastName(String firstName, String lastName){
        try{
            List<Account> accountList = (List<Account>)getHibernateTemplate()
                    .find("from Account acc join " +
                            "acc.user usr where " +
                            "usr.userFirstName=? and usr.userLastName=?", firstName, lastName);
            return accountList.get(0);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Account getAccountByUserEmail(String email){
        try{
            List<Account> accountList = (List<Account>)getHibernateTemplate()
                    .find("from Account acc join " +
                            "acc.user usr where " +
                            "usr.email=?", email);
            return accountList.get(0);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Account getAccountByUserPhone(String phone){
        try{
            List<Account> accountList = (List<Account>)getHibernateTemplate()
                    .find("from Account acc join " +
                            "acc.user usr where " +
                            "usr.userPhoneNumber=?", phone);
            return accountList.get(0);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Account getAccountByUserId(int id){
        try{
            List<Account> accountList = (List<Account>)getHibernateTemplate()
                    .find("from Account acc join " +
                            "acc.user usr where " +
                            "usr.id=?", id);
            return accountList.get(0);
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
