package ru.dimas.brosalin.DaoInterfaces;

import ru.dimas.brosalin.Models.Currency;

/**
 * Created by DmitriyBrosalin on 13/10/2016.
 */
public interface ModelCurrencyDAO {
    void save(Currency currency);
    Currency getModelBuId(long id);
    Currency getModelByFromTo(String from, String to);
}
