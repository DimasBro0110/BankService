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
    public User getModelByNameAndLastName(String name, String lastName) {
        User user = (User)this.userDAOImpl2.getModelByNameAndLastName(name, lastName);
        return user;
    }

    @Override
    public User getModelByEmail(String email) {
        User user = (User) this.userDAOImpl2.getModelByEmail(email);
        return user;
    }

    @Override
    public Account getAccountByUserEmail(String email) {
        Account account = (Account) this.userDAOImpl2.getAccountFromUserByEmail(email);
        return account;
    }

    @Override
    public Wallet getWalletFromUserByPhoneNumber(String phone) {
        Wallet wallet = (Wallet) this.userDAOImpl2.getWalletByPhoneNumber(phone);
        return wallet;
    }


    public void setUserDAOImpl2(UserDAOImpl_VER_2 userDAOImpl2) {
        this.userDAOImpl2 = userDAOImpl2;
    }
}
