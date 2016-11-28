package ru.dimas.brosalin.ServiceImpl;

import org.springframework.transaction.annotation.Transactional;
import ru.dimas.brosalin.DAO_IMPL.AccountDAOImpl_VER_2;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.Transaction;
import ru.dimas.brosalin.Models.Wallet;
import ru.dimas.brosalin.Services.AccountService;

import java.util.ArrayList;

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
    public Account getAccountById(int id) {
        Account account = (Account) this.accountDAOImplVer2.getModelById(id);
        return account;
    }

    @Override
    public ArrayList<Transaction> getAccountTransactionsTo(int id) {
        ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)
                this.accountDAOImplVer2.getAccountTransactionsToById(id);
        return transactionsList;
    }

    @Override
    public ArrayList<Transaction> getAccountTransactionsFrom(int id) {
        ArrayList<Transaction> transactionsList = (ArrayList<Transaction>)
                this.accountDAOImplVer2.getAccountTransactionsFromById(id);
        return transactionsList;
    }

    @Override
    public Wallet getWalletFromAccountById(int id) {
        Wallet wallet = this.accountDAOImplVer2.getWalletFromAccountById(id);
        return wallet;
    }

    public void setAccountDAOImplVer2(AccountDAOImpl_VER_2 accountDAOImplVer2) {
        this.accountDAOImplVer2 = accountDAOImplVer2;
    }
}
