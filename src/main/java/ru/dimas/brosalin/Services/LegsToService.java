package ru.dimas.brosalin.Services;

import ru.dimas.brosalin.Models.LegsTo;

import java.util.ArrayList;

/**
 * Created by DmitriyBrosalin on 28/11/2016.
 */
public interface LegsToService {
    void saveEntity(Object object);
    LegsTo getLegsFromById(int id);
    void update(LegsTo legsTo);
    ArrayList<LegsTo> getLegsFromByAccountId(int id);
    ArrayList<LegsTo> getLegsFromByUserPhoneNumber(String phone);
}
