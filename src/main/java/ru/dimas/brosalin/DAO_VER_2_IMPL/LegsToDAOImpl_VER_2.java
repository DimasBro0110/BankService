package ru.dimas.brosalin.DAO_VER_2_IMPL;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ru.dimas.brosalin.DAO_VER_2.ModelDAOGlobal;

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
        return null;
    }

    @Override
    public void update(Object object) {

    }
}
