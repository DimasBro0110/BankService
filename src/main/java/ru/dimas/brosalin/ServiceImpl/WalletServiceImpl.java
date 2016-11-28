package ru.dimas.brosalin.ServiceImpl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.dimas.brosalin.DAO_IMPL.WalletDAOImpl_VER_2;
import ru.dimas.brosalin.Models.Wallet;
import ru.dimas.brosalin.Services.WalletService;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */

@Transactional
public class WalletServiceImpl implements WalletService {

    private WalletDAOImpl_VER_2 walletDAOImplVer2;

    @Override
    public void saveEntity(Wallet wallet) {
        this.walletDAOImplVer2.save(wallet);
    }

    @Override
    public Wallet getWalletById(int id) {
        Wallet wallet = (Wallet) this.walletDAOImplVer2.getModelById(id);
        return wallet;
    }

    @Override
    public Wallet getWalletByPhoneNumber(String phoneNumber) {
        return this.walletDAOImplVer2.getWalletByPhoneNumber(phoneNumber);
    }

    @Override
    public Wallet getWalletByEmail(String email) {
        return this.walletDAOImplVer2.getWalletByEmail(email);
    }

    @Override
    public Wallet getWaleltByFirstNameAndLastName(String firstName, String lastName) {
        return this.walletDAOImplVer2.getWaleltByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public void update(Wallet wallet) {
        this.walletDAOImplVer2.update(wallet);
    }

    public void setWalletDAOImplVer2(WalletDAOImpl_VER_2 walletDAOImplVer2) {
        this.walletDAOImplVer2 = walletDAOImplVer2;
    }
}
