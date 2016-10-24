package ru.dimas.brosalin.Models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DmitriyBrosalin on 13/10/2016.
 */

/*
*
* RUR/RUR
* RUR/USD
* USD/RUR
* USD/USD
*
* */

@Entity
@Table(name = "CURRENCY")
public class Currency implements Serializable {

    @Id
    @Column(name = "CURRENCY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long currencyID;

    @Column(name = "CURRENCY_FROM_NAME")
    private String currencyFromName;

    @Column(name = "CURRENCY_TO_NAME")
    private String currencyToName;

    @Column(name = "CURRENCY_KOEF")
    private float koeff;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "currency")
    private Transaction transaction;

    public float getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(long currencyID) {
        this.currencyID = currencyID;
    }

    public String getCurrencyFromName() {
        return currencyFromName;
    }

    public void setCurrencyFromName(String currencyFromName) {
        this.currencyFromName = currencyFromName;
    }

    public String getCurrencyToName() {
        return currencyToName;
    }

    public void setCurrencyToName(String currencyToName) {
        this.currencyToName = currencyToName;
    }

    public float getKoeff() {
        return koeff;
    }

    public void setKoeff(float koeff) {
        this.koeff = koeff;
    }
}
