/**
 * Created by DmitriyBrosalin on 11/09/16.
 */

package ru.dimas.brosalin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.dimas.brosalin.DAO.*;
import ru.dimas.brosalin.Models.*;
import ru.dimas.brosalin.Session.SessionManagment;

import java.sql.Timestamp;

public class Application {

    public static void main(String[] args){

//        User user = new User();
//        user.setAge(21);
//        user.setEmail("vavilXYZslovil@mail.ru");
//        user.setGender("m");
//        user.setPassword("Vavilos");
//        user.setUserFirstName("Alex");
//        user.setUserLastName("Vavilov");
//
//        User user1 = new User();
//        user1.setAge(21);
//        user1.setEmail("dima0294@yandex.ru");
//        user1.setGender("m");
//        user1.setPassword("dima111");
//        user1.setUserFirstName("Dima");
//        user1.setUserLastName("Brosalin");
//
//        User user2 = new User();
//        user2.setAge(21);
//        user2.setAge(21);
//        user2.setEmail("kolyan@gmail.com");
//        user2.setGender("m");
//        user2.setPassword("kolya111");
//        user2.setUserFirstName("Nikolay");
//        user2.setUserLastName("Matkheev");
//
//        Account account = new Account();
//        account.setAccountCreation(new Timestamp(System.currentTimeMillis()));
//        account.setUser(user);
//
//        Account account1 = new Account();
//        account1.setAccountCreation(new Timestamp(System.currentTimeMillis()));
//        account1.setUser(user1);
//
//        Account account2 = new Account();
//        account2.setAccountCreation(new Timestamp(System.currentTimeMillis()));
//        account2.setUser(user2);
//
//        Wallet wallet = new Wallet();
//        wallet.setAccount(account);
//        wallet.setWalletCurrency("RUR");
//        wallet.setWalletBalance(90.4f);
//        wallet.setWalletNumber(111001);
//
//        Wallet wallet2 = new Wallet();
//        wallet2.setAccount(account);
//        wallet2.setWalletCurrency("USD");
//        wallet2.setWalletBalance(10.3f);
//        wallet2.setWalletNumber(222001);
//
//        Wallet wallet3 = new Wallet();
//        wallet3.setAccount(account1);
//        wallet3.setWalletCurrency("RUR");
//        wallet3.setWalletBalance(500.50f);
//        wallet3.setWalletNumber(111002);
//
//        Wallet wallet4 = new Wallet();
//        wallet4.setAccount(account2);
//        wallet4.setWalletCurrency("RUR");
//        wallet4.setWalletBalance(400.50f);
//        wallet4.setWalletNumber(111003);

        SessionManagment sessionManagment = new SessionManagment();

        UserDAOImpl userDAO = new UserDAOImpl(sessionManagment.getSessionFactory());
//        userDAO.save(user);
//        userDAO.save(user1);
//        userDAO.save(user2);

        AccountDAOImpl accountDAO = new AccountDAOImpl(sessionManagment.getSessionFactory());
//        accountDAO.save(account);
//        accountDAO.save(account1);
//        accountDAO.save(account2);

        WalletDAOImpl walletDAO = new WalletDAOImpl(sessionManagment.getSessionFactory());
//        walletDAO.save(wallet);
//        walletDAO.save(wallet2);
//        walletDAO.save(wallet3);
//        walletDAO.save(wallet4);

//        Currency currency1 = new Currency();
//        currency1.setCurrencyFromName("RUR");
//        currency1.setCurrencyToName("RUR");
//        currency1.setKoeff(1);

//        Currency currency2 = new Currency();
//        currency2.setCurrencyFromName("USD");
//        currency2.setCurrencyToName("USD");
//        currency2.setKoeff(1);

//        Currency currency3 = new Currency();
//        currency3.setCurrencyFromName("RUR");
//        currency3.setCurrencyToName("USD");
//        currency3.setKoeff(0.016F);

//        Currency currency4 = new Currency();
//        currency4.setCurrencyFromName("RUR");
//        currency4.setCurrencyToName("USD");
//        currency4.setKoeff(0.016F);

        CurrencyDAOImpl currencyDAO = new CurrencyDAOImpl(sessionManagment.getSessionFactory());
//        currencyDAO.save(currency1);
//        currencyDAO.save(currency2);
//        currencyDAO.save(currency3);
//        currencyDAO.save(currency4);
//
        Transaction transaction = new Transaction();
        Currency cur_currency = currencyDAO.getModelByFromTo("RUR", "USD");
        Account acc_1 = accountDAO.getModelByUserEmailAndName("dima0294@yandex.ru", "Dima");
        Account acc_2 = accountDAO.getModelByUserEmailAndName("vavilXYZslovil@mail.ru", "Alex");
        transaction.setAccountFrom(acc_1);
        transaction.setAccountTo(acc_2);
        transaction.setCurrency(cur_currency);
        transaction.setTransactionMoney(200);
        transaction.setTransactionTime(new Timestamp(System.currentTimeMillis()));

        LegsTo legsTo = new LegsTo();
        LegsFrom legsFrom = new LegsFrom();
        legsTo.setTransaction(transaction);
        legsFrom.setTransaction(transaction);
        Wallet from = walletDAO.getWalletByCurrencyAndAccount("RUR", acc_1);
        Wallet to = walletDAO.getWalletByCurrencyAndAccount("USD", acc_2);
        legsTo.setWallet(to);
        legsFrom.setWallet(from);

        TransactionDAOImpl transactionDAO = new TransactionDAOImpl(sessionManagment.getSessionFactory());
        LegsToDAOImpl legsToDAO = new LegsToDAOImpl(sessionManagment.getSessionFactory());
        LegsFromDAOImpl legsFromDAO = new LegsFromDAOImpl(sessionManagment.getSessionFactory());

        transactionDAO.save(transaction);
        legsFromDAO.save(legsFrom);
        legsToDAO.save(legsTo);

//        User cur_user = userDAO.getModelByEmail("dima0294@yandex.ru");
//        Account cur_account = cur_user.getAccount();
//        Wallet fromWallet = walletDAO.getWaletByUserAndNumber(cur_user, "RUR");
//        Wallet toWallet = walletDAO.getWaletByUserAndNumber(user, "USD");
//
//        transaction.setAccount(cur_account);
//        transaction.setUser(cur_user);
//        transaction.setCurrency(cur_currency);
//        transaction.setTransactionMoney(200.78f);

//
//        JsonObject user_test_get_id = userDAO.getModelById(1);
//        System.out.println(user_test_get_id);

        sessionManagment.closeSessionFactory();

    }

}
