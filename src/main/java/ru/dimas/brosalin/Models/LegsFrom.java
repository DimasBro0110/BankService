package ru.dimas.brosalin.Models;

import com.google.gson.JsonObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DmitriyBrosalin on 12/10/2016.
 */

@Entity
@Table(name = "LEGSFROM")
public class LegsFrom implements Serializable {

    @Id
    @Column(name = "LEGSFROM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long legsFromID = 0L;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "TRANSACTION_ID")
    private Transaction transaction;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "WALLET")
    private Wallet wallet;

    public long getLegsFromID() {
        return legsFromID;
    }

    public void setLegsFromID(long legsFromID) {
        this.legsFromID = legsFromID;
    }

    public JsonObject toJson(){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("LEGSFROM_ID", this.getLegsFromID());
        return jsonObject;

    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
