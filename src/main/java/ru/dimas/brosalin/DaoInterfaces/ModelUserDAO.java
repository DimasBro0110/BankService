package ru.dimas.brosalin.DaoInterfaces;

import com.google.gson.JsonArray;
import ru.dimas.brosalin.Models.User;
import com.google.gson.JsonObject;

/**
 * Created by DmitriyBrosalin on 08/10/2016.
 */
public interface ModelUserDAO {

    void save(User user);
    User getModelById(long id);
    User getModelByName(String name);
    User getModelByEmail(String email);
    void update(User user);
    JsonObject getModels();

}
