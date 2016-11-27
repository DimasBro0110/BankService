package ru.dimas.brosalin.Models;

import com.google.gson.JsonObject;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by DmitriyBrosalin on 12/10/2016.
 */

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

    @Id
    @Column(name = "TRANSACTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionID = 0L;

    @Column(name = "TRANSACTION_TIME")
    private Timestamp transactionTime;

    @Column(name = "TRANSACTION_MONEY")
    private float transactionMoney;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID_TO")
    private Account accountTo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID_FROM")
    private Account accountFrom;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "transaction")
    private LegsFrom legsFrom;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "transaction")
    private LegsTo legsTo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CURRENCY")
    private Currency currency;

    public Transaction() {}

    public Transaction(long id, Timestamp time){

        this.transactionID = id;
        this.transactionTime = time;

    }

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }

    public JsonObject toJson(){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("TRANSACTION_ID", this.getTransactionID());
        jsonObject.addProperty("MONEY", this.getTransactionMoney());
        jsonObject.addProperty("TRANSACTION_TIME", this.getTransactionTime().toString());
        jsonObject.add("ACCOUNT_TO_INFO", this.getAccountTo().toJson());
        jsonObject.add("ACCOUNT_FROM_INFO", this.getAccountFrom().toJson());
        jsonObject.add("LEGS_FROM_INFO", this.getLegsFrom().toJson());
        jsonObject.add("LEGS_FROM_TO", this.getLegsTo().toJson());
        jsonObject.add("CURRENCY_INFO", this.getCurrency().toJson());
        return jsonObject;

    }

    public float getTransactionMoney() {
        return transactionMoney;
    }

    public void setTransactionMoney(float transactionMoney) {
        this.transactionMoney = transactionMoney;
    }

    public LegsFrom getLegsFrom() {
        return legsFrom;
    }

    public LegsTo getLegsTo() {
        return legsTo;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }
}
