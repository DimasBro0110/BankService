package ru.dimas.brosalin.Services;

import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.Transaction;
import ru.dimas.brosalin.Models.Wallet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */

public interface AccountService {
    void saveEntity(Account account);
    void update(Account account);
    Account getAccountByUserFirstLastName(String firstName, String lastName);
    Account getAccountByUserEmail(String email);
    Account getAccountByUserPhone(String phone);
    Account getAccountByUserId(int id);
}
