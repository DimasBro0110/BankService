package ru.dimas.brosalin.BusinessLogicBOImpl;

import ru.dimas.brosalin.BusinessLogicBO.TransferMoneyP2P;
import ru.dimas.brosalin.Models.*;
import ru.dimas.brosalin.ServiceImpl.*;

import java.sql.Timestamp;

/**
 * Created by DmitriyBrosalin on 30/11/2016.
 */
public class TransferMoney implements TransferMoneyP2P {
    private WalletServiceImpl walletService;
    private AccountServiceImpl accountService;
    private LegsToServiceImpl legsToService;
    private LegsFromServiceImpl legsFromService;
    private TransactionServiceImpl transactionService;
    private LegsTo legsTo;
    private LegsFrom legsFrom;
    private Transaction transaction;

    @Override
    public int transferMoneyP2PUserToUser
            (User user_1, User user_2, float amountMoney) {
        try{
            Wallet fromWallet = walletService.getWalletByEmail(user_1.getEmail());
            Wallet toWallet = walletService.getWalletByEmail(user_2.getEmail());
            float currentBalanceWalletFrom = fromWallet.getWalletBalance();
            if((currentBalanceWalletFrom - amountMoney) < 0){
                return 1; // means that user does not have enough money to borrow
            }else{
                float currentBalanceWalletTo = toWallet.getWalletBalance();

                Account accountFrom = accountService.getAccountByUserEmail(user_1.getEmail());
                Account accountTo = accountService.getAccountByUserEmail(user_2.getEmail());

                transaction.setAccountFrom(accountFrom);
                transaction.setAccountTo(accountTo);
                transaction.setTransactionMoney(amountMoney);
                transaction.setTransactionTime(new Timestamp(System.currentTimeMillis()));
                transaction.setTransactionID(1);

                legsTo.setTransaction(transaction);
                legsTo.setWallet(toWallet);
                legsTo.setLegsToID(1);

                legsFrom.setTransaction(transaction);
                legsFrom.setWallet(fromWallet);
                legsFrom.setLegsFromID(1);

                fromWallet.setWalletBalance(currentBalanceWalletFrom - amountMoney);
                toWallet.setWalletBalance(currentBalanceWalletTo + amountMoney);

                transactionService.saveEntity(transaction);
                legsToService.saveEntity(legsTo);
                legsFromService.saveEntity(legsFrom);
                walletService.update(fromWallet);
                walletService.update(toWallet);

                return 0;
            }
        }catch(Exception ex) {
            return -1;
        }
    }

    @Override
    public int transferMoneyP2PAccountToAccount
            (Account account_1, Account account_2, float amountMoney) {
        try{
            User user_1 = account_1.getUser();
            User user_2 = account_2.getUser();
            Wallet fromWallet = walletService.getWalletByEmail(user_1.getEmail());
            Wallet toWallet = walletService.getWalletByEmail(user_2.getEmail());

            float currentBalanceWalletFrom = fromWallet.getWalletBalance();

            if((currentBalanceWalletFrom - amountMoney) < 0){
                return 1; // means that user does not have enough money to borrow
            }else {
                float currentBalanceWalletTo = toWallet.getWalletBalance();

                Account accountFrom = accountService.getAccountByUserEmail(user_1.getEmail());
                Account accountTo = accountService.getAccountByUserEmail(user_2.getEmail());

                transaction.setAccountFrom(accountFrom);
                transaction.setAccountTo(accountTo);
                transaction.setTransactionMoney(amountMoney);
                transaction.setTransactionTime(new Timestamp(System.currentTimeMillis()));
                transaction.setTransactionID(1);

                legsTo.setTransaction(transaction);
                legsTo.setWallet(toWallet);
                legsTo.setLegsToID(1);

                legsFrom.setTransaction(transaction);
                legsFrom.setWallet(fromWallet);
                legsFrom.setLegsFromID(1);

                fromWallet.setWalletBalance(currentBalanceWalletFrom - amountMoney);
                toWallet.setWalletBalance(currentBalanceWalletTo + amountMoney);

                transactionService.saveEntity(transaction);
                legsToService.saveEntity(legsTo);
                legsFromService.saveEntity(legsFrom);
                walletService.update(fromWallet);
                walletService.update(toWallet);

                return 0;
            }

        }catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }

    public void setWalletService(WalletServiceImpl walletService) {
        this.walletService = walletService;
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public void setLegsToService(LegsToServiceImpl legsToService) {
        this.legsToService = legsToService;
    }

    public void setLegsFromService(LegsFromServiceImpl legsFromService) {
        this.legsFromService = legsFromService;
    }

    public void setTransactionService(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    public void setLegsTo(LegsTo legsTo) {
        this.legsTo = legsTo;
    }

    public void setLegsFrom(LegsFrom legsFrom) {
        this.legsFrom = legsFrom;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
