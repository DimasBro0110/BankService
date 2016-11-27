package ru.dimas.brosalin.ServiceImpl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.dimas.brosalin.DAO_VER_2_IMPL.WalletDAOImpl_VER_2;
import ru.dimas.brosalin.Models.Wallet;
import ru.dimas.brosalin.Services.WalletService;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */
public class WalletServiceImpl implements WalletService {

    private WalletDAOImpl_VER_2 walletDAOImplVer2;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveEntity(Wallet wallet) {
        this.walletDAOImplVer2.save(wallet);
    }

    public void setWalletDAOImplVer2(WalletDAOImpl_VER_2 walletDAOImplVer2) {
        this.walletDAOImplVer2 = walletDAOImplVer2;
    }
}
