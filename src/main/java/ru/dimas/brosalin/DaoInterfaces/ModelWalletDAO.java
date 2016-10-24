package ru.dimas.brosalin.DaoInterfaces;

import com.google.gson.JsonObject;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.Models.Wallet;

/**
 * Created by DmitriyBrosalin on 10/10/2016.
 */
public interface ModelWalletDAO {

    void save(Wallet wallet);
    JsonObject getModelById(long id);
    void update(Wallet wallet);
    JsonObject getModels();
    Wallet getModelByNumber(long number);
    Wallet getWalletByCurrencyAndAccount(String currency, Account account);
    Wallet getWaletByUserAndNumber(User user, String currency);

}
