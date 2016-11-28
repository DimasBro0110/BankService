package ru.dimas.brosalin.Services;

import ru.dimas.brosalin.Models.LegsFrom;

import java.util.ArrayList;

/**
 * Created by DmitriyBrosalin on 28/11/2016.
 */
public interface LegsFromService {
    void saveEntity(Object object);
    LegsFrom getLegsFromById(int id);
    void update(LegsFrom legsFrom);
    ArrayList<LegsFrom> getLegsFromByAccountId(int id);
    ArrayList<LegsFrom> getLegsFromByUserPhoneNumber(String phone);
}
