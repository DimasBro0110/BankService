package ru.dimas.brosalin.Models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.hibernate.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import org.aspectj.lang.annotation.Aspect;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountID = 0L;

    @Column(name = "CREATION")
    private Timestamp accountCreation;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "account"
    )
    private Set<Wallet> wallet;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "accountTo"
    )
    private Set<Transaction> accountTransactionsTo;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "accountFrom"
    )
    private Set<Transaction> accountTransactionsFrom;

    public Account(){

    }

    public Account(long id, Timestamp creation, float balance, User user){
        this.accountID = id;
        this.accountCreation = creation;
        this.user = user;
    }

    public long getAccountID(){
        return this.accountID;
    }

    public void setAccountID(long id){
        this.accountID = id;
    }

    public Timestamp getAccountCreation() {
        return accountCreation;
    }

    public void setAccountCreation(Timestamp accountCreation) {
        this.accountCreation = accountCreation;
    }


    @Override
    public String toString(){

        return toJson().toString();

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Wallet> getWallet() {
        return wallet;
    }

    public void setWallet(Set<Wallet> wallet) {
        this.wallet = wallet;
    }

    public JsonObject toJson(){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ACCOUNT_ID", this.getAccountID());
        jsonObject.addProperty("CREATION", this.getAccountCreation().toString());
        JsonArray walletArray = new JsonArray();
        for(Wallet wall: wallet){
            walletArray.add(wall.toJson());
        }
        JsonArray accTransactionsTo = new JsonArray();
        for(Transaction transaction: accountTransactionsTo){
            accTransactionsTo.add(transaction.toJson());
        }
        jsonObject.add("WALLET", walletArray);
        return jsonObject;

    }

    public Set<Transaction> getAccountTransactionsFrom() {
        return accountTransactionsFrom;
    }

    public void setAccountTransactionsFrom(Set<Transaction> accountTransactionsFrom) {
        this.accountTransactionsFrom = accountTransactionsFrom;
    }

    public Set<Transaction> getAccountTransactionsTo() {
        return accountTransactionsTo;
    }

    public void setAccountTransactionsTo(Set<Transaction> accountTransactionsTo) {
        this.accountTransactionsTo = accountTransactionsTo;
    }
}