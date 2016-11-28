package ru.dimas.brosalin.Services;

import ru.dimas.brosalin.Models.Wallet;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */
public interface WalletService {
    void saveEntity(Wallet wallet);
    Wallet getWalletById(int id);
    Wallet getWalletByPhoneNumber(String phoneNumber);
    Wallet getWalletByEmail(String email);
    Wallet getWaleltByFirstNameAndLastName(String firstName, String lastName);
    void update(Wallet wallet);
}
