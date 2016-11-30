package ru.dimas.brosalin.DAO_IMPL;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ru.dimas.brosalin.DAO.ModelDAOGlobal;
import ru.dimas.brosalin.Models.Wallet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */
public class WalletDAOImpl_VER_2 extends HibernateDaoSupport implements ModelDAOGlobal {

    @Override
    public void save(Object object) {
        Wallet wallet = (Wallet)object;
        getHibernateTemplate().save(wallet);
    }

    @Override
    public Object getModelById(int id) {
        try {
            List<Wallet> walletList = (ArrayList<Wallet>)getHibernateTemplate()
                    .find("from Wallet wal where wal.id=?", id);
            if(walletList != null) {
                return walletList.get(0);
            }else{
                return null;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Wallet getWalletByPhoneNumber(String phoneNumber){
        try{
            List<Wallet> walletList = (List<Wallet>)getHibernateTemplate()
                    .find("select wal from Wallet wal join " +
                            "wal.account acc join " +
                            "acc.user usr where " +
                            "usr.userPhoneNumber=?", phoneNumber);
            if(walletList != null) {
                return walletList.get(0);
            }else{
                return null;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Wallet getWalletByEmail(String email){
        try{
            List<Wallet> walletList = (List<Wallet>)getHibernateTemplate()
                    .find("select wal from Wallet wal join " +
                            "wal.account acc join " +
                            "acc.user usr where " +
                            "lower(usr.email)=?", email.toLowerCase());
            if(walletList != null) {
                return walletList.get(0);
            }else{
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Wallet getWaleltByFirstNameAndLastName(String firstName, String lastName){
        try{
            List<Wallet> walletList = (List<Wallet>)getHibernateTemplate()
                    .find("select wal from Wallet wal join " +
                            "wal.account acc join " +
                            "acc.user usr where " +
                            "lower(usr.userFirstName)=? " +
                            "and lower(sr.userFirstName)=?",
                            firstName.toLowerCase(), lastName.toLowerCase());
            if(walletList != null) {
                return walletList.get(0);
            }else{
                return null;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public boolean numberWalletExists(long number){
        List result = getHibernateTemplate().find("from Wallet wal where wal.walletNumber=?", number);
        return !result.isEmpty();
    }

    @Override
    public void update(Object object) {
        Wallet wallet = (Wallet)object;
        getHibernateTemplate().update(wallet);
    }

}
