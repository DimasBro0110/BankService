package ru.dimas.brosalin.DaoInterfaces;

import com.google.gson.JsonObject;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.User;

import java.util.List;


/**
 * Created by DmitriyBrosalin on 08/10/2016.
 */
public interface ModelAccountDAO {

    void save(Account account);
    JsonObject getModelById(long id);
    void update(Account account);
    JsonObject getModels();
    User getAccountByUserEmail(String userEmail);
    Account getModelByUserEmailAndName(String email, String name);

}
