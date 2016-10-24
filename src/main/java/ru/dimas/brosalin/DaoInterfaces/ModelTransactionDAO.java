package ru.dimas.brosalin.DaoInterfaces;

import com.google.gson.JsonObject;
import ru.dimas.brosalin.Models.Transaction;

import java.sql.Timestamp;

/**
 * Created by DmitriyBrosalin on 12/10/2016.
 */
public interface ModelTransactionDAO {

    void save(Transaction transaction);
    JsonObject getModelById(long id);

}
