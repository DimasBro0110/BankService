package ru.dimas.brosalin.Services;

import ru.dimas.brosalin.Models.Transaction;

import java.util.ArrayList;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */
public interface TransactionService {

    void saveEntity(Transaction transaction);
    ArrayList<Transaction> getListOfTransactonsByAccountToId(int id);
    ArrayList<Transaction> getListOfTransactionsByUserToId(int id);
    ArrayList<Transaction> getListOfTransactionsByUserToEmail(String email);
    ArrayList<Transaction> getListOfTransactionsByUserToFirsLastName(String firstName, String lastName);
    ArrayList<Transaction> getListOfTransactionsByUserToPhoneNumber(String phone);

    ArrayList<Transaction> getListOfTransactonsByAccountFromId(int id);
    ArrayList<Transaction> getListOfTransactionsByUserFromId(int id);
    ArrayList<Transaction> getListOfTransactionsByUserFromEmail(String email);
    ArrayList<Transaction> getListOfTransactionsByUserFromFirsLastName(String firstName, String lastName);
    ArrayList<Transaction> getListOfTransactionsByUserFromPhoneNumber(String phone);
    void update(Transaction transaction);

}
