package ru.dimas.brosalin.DAO_IMPL;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ru.dimas.brosalin.DAO.ModelDAOGlobal;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.Models.Wallet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */

public class UserDAOImpl_VER_2 extends HibernateDaoSupport implements ModelDAOGlobal {

    @Override
    public void save(Object object) {
        User user = (User) object;
        getHibernateTemplate().save(user);
    }

    @Override
    public Object getModelById(int id) {
        try {
            List<User> userListByID = (List<User>) getHibernateTemplate()
                    .find("from User where userId=?", id);
            return userListByID.get(0);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public User getModelByNameAndLastName(String name, String lastName){
        try {
            List<User> userListByNameAndLastName = (List<User>) getHibernateTemplate()
                    .find("from User where userFirstName=? and userLastName=?",
                            name, lastName);
            return userListByNameAndLastName.get(0);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public User getModelByEmail(String email){
        try {
            List<User> userListByEmail = (List<User>) getHibernateTemplate()
                    .find("from User u where u.email=?", email);
            return userListByEmail.get(0);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public User getModelByPhoneNumber(String phoneNumber){
        try {
            List<User> userListByPhone = (List<User>)getHibernateTemplate()
                    .find("from User u where u.userPhoneNumber=?", phoneNumber);
            return userListByPhone.get(0);
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
