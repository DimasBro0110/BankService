package ru.dimas.brosalin.DAO_VER_2_IMPL;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ru.dimas.brosalin.DAO_VER_2.ModelDAOGlobal;
import ru.dimas.brosalin.Models.Account;

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

    @Override
    public void update(Object object) {
        getHibernateTemplate().update(object);
    }

}
