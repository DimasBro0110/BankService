package ru.dimas.brosalin.ServiceImpl;

import org.springframework.transaction.annotation.Transactional;
import ru.dimas.brosalin.DAO_IMPL.TransactionDAOImpl_VER_2;
import ru.dimas.brosalin.Models.Transaction;
import ru.dimas.brosalin.Services.TransactionService;

import java.util.ArrayList;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */

@Transactional
public class TransactionServiceImpl implements TransactionService {

    private TransactionDAOImpl_VER_2 transactionDAOImplVer2;

    @Override
    public void saveEntity(Transaction transaction) {
        this.transactionDAOImplVer2.save(transaction);
    }

    @Override
    public ArrayList<Transaction> getListOfTransactonsByAccountToId(int id) {
        return this.transactionDAOImplVer2.getListOfTransactonsByAccountToId(id);
    }

    @Override
    public ArrayList<Transaction> getListOfTransactionsByUserToId(int id) {
        return this.transactionDAOImplVer2.getListOfTransactionsByUserToId(id);
    }

    @Override
    public ArrayList<Transaction> getListOfTransactionsByUserToEmail(String email) {
        return this.transactionDAOImplVer2.getListOfTransactionsByUserToEmail(email);
    }

    @Override
    public ArrayList<Transaction> getListOfTransactionsByUserToFirsLastName(String firstName, String lastName) {
        return this.transactionDAOImplVer2.getListOfTransactionsByUserToFirsLastName(firstName, lastName);
    }

    @Override
    public ArrayList<Transaction> getListOfTransactionsByUserToPhoneNumber(String phone) {
        return this.transactionDAOImplVer2.getListOfTransactionsByUserToPhoneNumber(phone);
    }

    @Override
    public ArrayList<Transaction> getListOfTransactonsByAccountFromId(int id) {
        return this.getListOfTransactonsByAccountFromId(id);
    }

    @Override
    public ArrayList<Transaction> getListOfTransactionsByUserFromId(int id) {
        return this.getListOfTransactionsByUserFromId(id);
    }

    @Override
    public ArrayList<Transaction> getListOfTransactionsByUserFromEmail(String email) {
        return this.getListOfTransactionsByUserFromEmail(email);
    }

    @Override
    public ArrayList<Transaction> getListOfTransactionsByUserFromFirsLastName(String firstName, String lastName) {
        return this.getListOfTransactionsByUserFromFirsLastName(firstName, lastName);
    }

    @Override
    public ArrayList<Transaction> getListOfTransactionsByUserFromPhoneNumber(String phone) {
        return this.getListOfTransactionsByUserFromPhoneNumber(phone);
    }

    @Override
    public void update(Transaction transaction) {
        this.transactionDAOImplVer2.update(transaction);
    }

    public void setTransactionDAOImplVer2(TransactionDAOImpl_VER_2 transactionDAOImplVer2) {
        this.transactionDAOImplVer2 = transactionDAOImplVer2;
    }
}
