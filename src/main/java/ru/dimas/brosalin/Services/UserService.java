package ru.dimas.brosalin.Services;

import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.Models.Wallet;

import java.util.ArrayList;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */
public interface UserService {
    void saveEntity(User user);
    User getUserById(int id);
    void update(User user);
    User getUserByNameAndLastName(String name, String lastName);
    User getUserByEmail(String email);
    User getUserByPhone(String phone);
    boolean phoneUserExists(String phone);
    boolean emailUserExists(String email);
    int deleteUserByPhone(String phone);
}
