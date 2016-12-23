package ru.dimas.brosalin.ServiceImpl;

import org.springframework.transaction.annotation.Transactional;
import ru.dimas.brosalin.DAO_IMPL.UserDAOImpl_VER_2;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.Models.Wallet;
import ru.dimas.brosalin.Services.UserService;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */

@Transactional
public class UserServiceImpl implements UserService {

    private UserDAOImpl_VER_2 userDAOImpl2;

    @Override
    public void saveEntity(User user) {
        this.userDAOImpl2.save(user);
    }

    @Override
    public User getUserById(int id){
        User user = (User)this.userDAOImpl2.getModelById(id);
        return user;
    }

    @Override
    public void update(User user){
        this.userDAOImpl2.update(user);
    }

    @Override
    public User getUserByNameAndLastName(String name, String lastName) {
        return this.userDAOImpl2.getModelByNameAndLastName(name, lastName);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userDAOImpl2.getModelByEmail(email);
    }

    @Override
    public User getUserByPhone(String phone) {
        return this.userDAOImpl2.getModelByPhoneNumber(phone);
    }

    @Override
    public boolean phoneUserExists(String phone) {
        return this.userDAOImpl2.phoneUserExists(phone);
    }

    @Override
    public boolean emailUserExists(String email) {
        return this.userDAOImpl2.emailUserExists(email);
    }

    @Override
    public int deleteUserByPhone(String phone) {
        return this.userDAOImpl2.deleteModelByPhone(phone);
    }

    public void setUserDAOImpl2(UserDAOImpl_VER_2 userDAOImpl2) {
        this.userDAOImpl2 = userDAOImpl2;
    }
}
