package ru.dimas.brosalin.ServiceImpl;

import ru.dimas.brosalin.DAO_IMPL.LegsToDAOImpl_VER_2;
import ru.dimas.brosalin.Models.LegsTo;
import ru.dimas.brosalin.Services.LegsToService;

import java.util.ArrayList;

/**
 * Created by DmitriyBrosalin on 28/11/2016.
 */
public class LegsToServiceImpl implements LegsToService {
    private LegsToDAOImpl_VER_2 legsToDAOImplVer2;

    @Override
    public void saveEntity(Object object) {
        this.legsToDAOImplVer2.save(object);
    }

    @Override
    public LegsTo getLegsFromById(int id) {
        LegsTo legsTo = (LegsTo) this.legsToDAOImplVer2.getModelById(id);
        return legsTo;
    }

    @Override
    public void update(LegsTo legsTo) {
        this.legsToDAOImplVer2.update(legsTo);
    }

    @Override
    public ArrayList<LegsTo> getLegsFromByAccountId(int id) {
        return this.legsToDAOImplVer2.getLegsToByAccountId(id);
    }

    @Override
    public ArrayList<LegsTo> getLegsFromByUserPhoneNumber(String phone) {
        return this.legsToDAOImplVer2.getLegsToByUserPhoneNumber(phone);
    }

    public void setLegsToDAOImplVer2(LegsToDAOImpl_VER_2 legsToDAOImplVer2) {
        this.legsToDAOImplVer2 = legsToDAOImplVer2;
    }
}
