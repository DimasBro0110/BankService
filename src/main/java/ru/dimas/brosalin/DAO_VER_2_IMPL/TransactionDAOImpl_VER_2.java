package ru.dimas.brosalin.DAO_VER_2_IMPL;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ru.dimas.brosalin.DAO_VER_2.ModelDAOGlobal;
import ru.dimas.brosalin.Models.Transaction;

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
        return null;
    }

    @Override
    public void update(Object object) {

    }

}
