package ru.dimas.brosalin.ServiceImpl;

import org.springframework.transaction.annotation.Transactional;
import ru.dimas.brosalin.DAO_IMPL.AccountDAOImpl_VER_2;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Services.AccountService;


/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */

@Transactional
public class AccountServiceImpl implements AccountService {

    private AccountDAOImpl_VER_2 accountDAOImplVer2;

    @Override
    public void saveEntity(Account account) {
        this.accountDAOImplVer2.save(account);
    }

    @Override
    public void update(Account account) {
        this.accountDAOImplVer2.update(account);
    }


    @Override
    public Account getAccountByUserFirstLastName(String firstName, String lastName) {
        return this.accountDAOImplVer2.getAccountByUserFirstLastName(firstName, lastName);
    }

    @Override
    public Account getAccountByUserEmail(String email) {
        return this.accountDAOImplVer2.getAccountByUserEmail(email);
    }

    @Override
    public Account getAccountByUserPhone(String phone) {
        return this.accountDAOImplVer2.getAccountByUserPhone(phone);
    }

    @Override
    public Account getAccountByUserId(int id) {
        return this.accountDAOImplVer2.getAccountByUserId(id);
    }


    public void setAccountDAOImplVer2(AccountDAOImpl_VER_2 accountDAOImplVer2) {
        this.accountDAOImplVer2 = accountDAOImplVer2;
    }
}
