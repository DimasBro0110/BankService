package ru.dimas.brosalin.ServiceImpl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.dimas.brosalin.DAO_VER_2_IMPL.TransactionDAOImpl_VER_2;
import ru.dimas.brosalin.Models.Transaction;
import ru.dimas.brosalin.Services.TransactionService;

/**
 * Created by DmitriyBrosalin on 24/11/2016.
 */

@Transactional
public class TransactionServiceImpl implements TransactionService {

    private TransactionDAOImpl_VER_2 transactionDAOImplVer2;

    @Override
    public void saveEntity(Transaction transaction) {
        this.transactionDAOImplVer2.save(transaction);
    }

    public void setTransactionDAOImplVer2(TransactionDAOImpl_VER_2 transactionDAOImplVer2) {
        this.transactionDAOImplVer2 = transactionDAOImplVer2;
    }
}
