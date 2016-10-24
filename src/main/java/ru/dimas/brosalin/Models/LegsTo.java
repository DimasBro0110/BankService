package ru.dimas.brosalin.Models;

import com.google.gson.JsonObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DmitriyBrosalin on 12/10/2016.
 */
@Entity
@Table(name = "LEGSTO")
public class LegsTo implements Serializable {

    @Id
    @Column(name = "LEGSTO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long legsToID = 0L;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "TRANSACTION_ID")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "WALLET")
    private Wallet wallet;

    public long getLegsToID() {
        return legsToID;
    }

    public void setLegsToID(long legsToID) {
        this.legsToID = legsToID;
    }

    public JsonObject toJson(){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("LEGSTO_ID", this.getLegsToID());

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
