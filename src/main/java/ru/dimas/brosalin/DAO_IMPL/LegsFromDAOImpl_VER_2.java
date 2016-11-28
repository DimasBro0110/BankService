package ru.dimas.brosalin.DAO_IMPL;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ru.dimas.brosalin.DAO.ModelDAOGlobal;
import ru.dimas.brosalin.Models.LegsFrom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DmitriyBrosalin on 28/11/2016.
 */
public class LegsFromDAOImpl_VER_2 extends HibernateDaoSupport implements ModelDAOGlobal {
    @Override
    public void save(Object object) {
        getHibernateTemplate().save(object);
    }

    @Override
    public Object getModelById(int id) {
        try {
            List<LegsFrom> legsFromList = (ArrayList<LegsFrom>)getHibernateTemplate()
                    .find("from LegsFrom lf where lf.id=?", id);
            return legsFromList.get(0);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<LegsFrom> getLegsFromByAccountId(int id){
        try {
            ArrayList<LegsFrom> legsFromList = (ArrayList<LegsFrom>)getHibernateTemplate()
                    .find("select lf from LegsFrom lf join " +
                            "lf.wallet wal join " +
                            "wal.account acc " +
                            "where acc.id=?", id);
            return legsFromList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<LegsFrom> getLegsFromByUserPhoneNumber(String phone){
        try {
            ArrayList<LegsFrom> legsFromList = (ArrayList<LegsFrom>)getHibernateTemplate()
                    .find("select lf from LegsFrom lf join " +
                            "lf.wallet wal join " +
                            "wal.account acc join " +
                            "acc.user usr where usr.userPhoneNumber=?", phone);
            return legsFromList;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Object object) {
        getHibernateTemplate().save(object);
    }
}
