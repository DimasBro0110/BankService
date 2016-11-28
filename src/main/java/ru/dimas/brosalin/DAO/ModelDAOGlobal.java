package ru.dimas.brosalin.DAO;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */

import java.lang.Object;

public interface ModelDAOGlobal {

    public void save(Object object);
    public Object getModelById(int id);
    public void update(Object object);

}
