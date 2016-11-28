package ru.dimas.brosalin.Services;

import ru.dimas.brosalin.Models.Account;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */

public interface AccountService {
    void saveEntity(Account account);
    void update(Account account);
}
