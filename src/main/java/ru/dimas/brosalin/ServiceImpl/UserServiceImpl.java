package ru.dimas.brosalin.ServiceImpl;

import org.springframework.transaction.annotation.Transactional;
import ru.dimas.brosalin.DAO_VER_2_IMPL.UserDAOImpl_VER_2;
import ru.dimas.brosalin.Models.User;
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

    public void setUserDAOImpl2(UserDAOImpl_VER_2 userDAOImpl2) {
        this.userDAOImpl2 = userDAOImpl2;
    }
}
