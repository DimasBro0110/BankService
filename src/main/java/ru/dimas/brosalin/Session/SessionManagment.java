package ru.dimas.brosalin.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by DmitriyBrosalin on 08/10/2016.
 */

public class SessionManagment {

    private SessionFactory sessionFactory = null;

    public SessionManagment(){

        try {

            this.sessionFactory = new Configuration().configure().buildSessionFactory();

        }catch(Exception ex){

            ex.printStackTrace();
            this.sessionFactory = null;

        }

    }

    public SessionFactory getSessionFactory(){

        return this.sessionFactory;

    }

    public void closeSessionFactory(){

        this.sessionFactory.close();

    }

}
