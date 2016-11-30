package ru.dimas.brosalin.BusinessLogicBO;

import org.springframework.context.ApplicationContext;
import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.ServiceImpl.AccountServiceImpl;
import ru.dimas.brosalin.ServiceImpl.UserServiceImpl;
import ru.dimas.brosalin.ServiceImpl.WalletServiceImpl;

/**
 * Created by DmitriyBrosalin on 30/11/2016.
 */
public interface TransferMoneyP2P {
    int transferMoneyP2PUserToUser(User user_1, User user_2, float amountMoney);
    int transferMoneyP2PAccountToAccount(Account account_1, Account account_2, float amountMoney);
}
