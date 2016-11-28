package ru.dimas.brosalin.ServiceImpl;

import ru.dimas.brosalin.DAO_IMPL.LegsFromDAOImpl_VER_2;
import ru.dimas.brosalin.Models.LegsFrom;
import ru.dimas.brosalin.Services.LegsFromService;

import java.util.ArrayList;

/**
 * Created by DmitriyBrosalin on 28/11/2016.
 */
public class LegsFromServiceImpl implements LegsFromService {
    private LegsFromDAOImpl_VER_2 legsFromDAOImplVer2;

    @Override
    public void saveEntity(Object object) {
        this.legsFromDAOImplVer2.save(object);
    }

    @Override
    public LegsFrom getLegsFromById(int id) {
        LegsFrom legsFrom = (LegsFrom) this.legsFromDAOImplVer2.getModelById(id);
        return legsFrom;
    }

    @Override
    public void update(LegsFrom legsFrom) {
        this.legsFromDAOImplVer2.update(legsFrom);
    }

    @Override
    public ArrayList<LegsFrom> getLegsFromByAccountId(int id) {
        return this.legsFromDAOImplVer2.getLegsFromByAccountId(id);
    }

    @Override
    public ArrayList<LegsFrom> getLegsFromByUserPhoneNumber(String phone) {
        return legsFromDAOImplVer2.getLegsFromByUserPhoneNumber(phone);
    }

    public void setLegsFromDAOImplVer2(LegsFromDAOImpl_VER_2 legsFromDAOImplVer2) {
        this.legsFromDAOImplVer2 = legsFromDAOImplVer2;
    }
}
