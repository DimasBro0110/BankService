package ru.dimas.brosalin.ServiceImpl;

import org.springframework.transaction.annotation.Transactional;
import ru.dimas.brosalin.DAO_VER_2_IMPL.AccountDAOImpl_VER_2;
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

    public void setAccountDAOImplVer2(AccountDAOImpl_VER_2 accountDAOImplVer2) {
        this.accountDAOImplVer2 = accountDAOImplVer2;
    }
}
