package ru.dimas.brosalin.Aspects;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DmitriyBrosalin on 23/11/2016.
 */
public class LoggerInfoAspect {


    public void beforeSave(){

        System.out.println("\nSaving model at: "
                + (new Timestamp(System.currentTimeMillis())).toString()
        );

    }

    public void afterSave(){

        System.out.println("\nModel saved at: "
                + (new Timestamp(System.currentTimeMillis())).toString()
        );

    }

}
