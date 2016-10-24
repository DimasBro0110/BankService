package ru.dimas.brosalin.DaoInterfaces;

import com.google.gson.JsonObject;
import ru.dimas.brosalin.Models.LegsFrom;

/**
 * Created by DmitriyBrosalin on 12/10/2016.
 */
public interface ModelLegsFromDAO {

    void save(LegsFrom legsFrom);
    JsonObject getModelById(long id);

}
