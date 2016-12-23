package ru.dimas.brosalin.BusinessLogicBOImpl;

import ru.dimas.brosalin.Models.Account;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.Models.Wallet;
import ru.dimas.brosalin.ServiceImpl.AccountServiceImpl;
import ru.dimas.brosalin.ServiceImpl.UserServiceImpl;
import ru.dimas.brosalin.ServiceImpl.WalletServiceImpl;

import java.sql.Timestamp;
import java.util.Random;

import static java.lang.StrictMath.abs;

/**
 * Created by DmitriyBrosalin on 30/11/2016.
 */
public class UserCreationInSystem {
    private Account account;
    private Wallet wallet;
    private User user;
    private WalletServiceImpl walletService;
    private AccountServiceImpl accountService;
    private UserServiceImpl userService;

    public int registerUser(){
        try{
            boolean emailExists = userService.emailUserExists(user.getEmail());
            boolean phoneExists = userService.phoneUserExists(user.getUserPhoneNumber());
            if(emailExists || phoneExists){
                return 1; //email or phone exists exists
            }else {
                long currentWalletNumber = generateNumberWallet();
                while (walletService.numberWalletExists(currentWalletNumber)) {
                    currentWalletNumber = generateNumberWallet();
                }
                account.setUser(user);
                account.setAccountCreation(new Timestamp(System.currentTimeMillis()));
                account.setAccountID(1);

                wallet.setAccount(account);
                wallet.setWalletBalance(0);
                wallet.setWalletCurrency("RUR");
                wallet.setWalletNumber(currentWalletNumber);

                userService.saveEntity(user);
                accountService.saveEntity(account);
                walletService.saveEntity(wallet);

                return 0;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }

    private long generateNumberWallet(){
        Random random = new Random();
        return abs(random.nextLong());
    }

    private long generateNumberWallet(long temp){
        Random random = new Random();
        long cur = abs(random.nextLong());
        while(cur == temp){
            cur = abs(random.nextLong());
        }
        return cur;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void setWalletService(WalletServiceImpl walletService) {
        this.walletService = walletService;
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
