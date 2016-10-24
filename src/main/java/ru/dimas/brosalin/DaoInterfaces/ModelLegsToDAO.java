package ru.dimas.brosalin.DaoInterfaces;

import com.google.gson.JsonObject;
import ru.dimas.brosalin.Models.LegsTo;
import ru.dimas.brosalin.Models.Wallet;

/**
 * Created by DmitriyBrosalin on 12/10/2016.
 */
public interface ModelLegsToDAO {

    void save(LegsTo legsTo);
    JsonObject getModelById(long id);
    Wallet getModelByNumber(long number);

}
