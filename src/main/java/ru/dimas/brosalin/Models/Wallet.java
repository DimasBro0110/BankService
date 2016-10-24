package ru.dimas.brosalin.Models;

import com.google.gson.JsonObject;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by DmitriyBrosalin on 10/10/2016.
 */

@Entity
@Table(name = "WALLET")
public class Wallet implements Serializable {

    @Id
    @Column(name = "WALLET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long walletID = 0L;

    @Column(name = "NUMBER")
    private long walletNumber;

    @Column(name = "CURRENCY")
    private String walletCurrency;

    @Column(name = "BALANCE")
    private float walletBalance = 0.0f;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wallet")
    private Set<LegsFrom> legsFrom;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wallet")
    private Set<LegsTo> legsTo;

    public Wallet() {}

    public Wallet(String currency, Account account) {

        this.account = account;
        this.walletCurrency = currency;

    }

    public long getWalletID() {
        return walletID;
    }

    public void setWalletID(long walletID) {
        this.walletID = walletID;
    }

    public String getWalletCurrency() {
        return walletCurrency;
    }

    public void setWalletCurrency(String walletCurrency) {
        this.walletCurrency = walletCurrency;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public float getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(float walletBalance) {
        this.walletBalance = walletBalance;
    }

    public JsonObject toJson(){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("WALLET_ID", this.getWalletID());
        jsonObject.addProperty("Currency", this.getWalletCurrency());
        jsonObject.addProperty("Number", this.getWalletNumber());
        jsonObject.addProperty("Balance", this.getWalletBalance());
        return jsonObject;

    }

    public long getWalletNumber() {
        return walletNumber;
    }

    public void setWalletNumber(long walletNumber) {
        this.walletNumber = walletNumber;
    }

    public Set<LegsFrom> getLegsFrom() {
        return legsFrom;
    }

    public void setLegsFrom(Set<LegsFrom> legsFrom) {
        this.legsFrom = legsFrom;
    }

    public Set<LegsTo> getLegsTo() {
        return legsTo;
    }

    public void setLegsTo(Set<LegsTo> legsTo) {
        this.legsTo = legsTo;
    }
}
