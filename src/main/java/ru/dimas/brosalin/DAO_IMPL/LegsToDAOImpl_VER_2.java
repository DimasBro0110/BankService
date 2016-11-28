package ru.dimas.brosalin.DAO_IMPL;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ru.dimas.brosalin.DAO.ModelDAOGlobal;
import ru.dimas.brosalin.Models.LegsTo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DmitriyBrosalin on 28/11/2016.
 */
public class LegsToDAOImpl_VER_2 extends HibernateDaoSupport implements ModelDAOGlobal{

    @Override
    public void save(Object object) {
        getHibernateTemplate().save(object);
    }

    @Override
    public Object getModelById(int id) {
        try {
            List<LegsTo> legsToList = (ArrayList<LegsTo>)getHibernateTemplate()
                    .find("from LegsTo lt where lt.id=?", id);
            return legsToList.get(0);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<LegsTo> getLegsToByAccountId(int id){
        try {
            ArrayList<LegsTo> legsToList = (ArrayList<LegsTo>)getHibernateTemplate()
                    .find("select lt from LegsTo lt join " +
                            "lt.wallet wal join " +
                            "wal.account acc " +
                            "where acc.id=?", id);
            return legsToList;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<LegsTo> getLegsToByUserPhoneNumber(String phone){
        try{
            ArrayList<LegsTo> legsToList = (ArrayList<LegsTo>)getHibernateTemplate()
                    .find("select lt from LegsTo lt join " +
                            "lt.wallet wal join " +
                            "wal.account acc join " +
                            "acc.user usr " +
                            "where usr.userPhoneNumber=?", phone);
            return legsToList;
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
