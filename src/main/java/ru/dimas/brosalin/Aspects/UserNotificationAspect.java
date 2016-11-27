package ru.dimas.brosalin.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import ru.dimas.brosalin.Notification.SendMessageFromYandexAccount;

import java.sql.Timestamp;

/**
 * Created by DmitriyBrosalin on 27/11/2016.
 */

public class UserNotificationAspect {

    private SendMessageFromYandexAccount messageFromYandexAccount = new SendMessageFromYandexAccount();
    private String textToSend = "Here is <<template>> for message"
                + "\nDelivered at: "
                + (new Timestamp(System.currentTimeMillis())).toString();

    public void InformUser(ProceedingJoinPoint pjp) throws Throwable {
        Object[] argumentsPassed = pjp.getArgs();
        if(argumentsPassed.length > 0){
            pjp.proceed();
            System.out.println("Argument passed: ");
            String stringRepresentation = argumentsPassed[0].toString();
            for(String value: stringRepresentation.split("\n")){
                if(value.contains("Email")){
                    String email = value.split(":")[1];
                    System.out.println(value.split(":")[1]);
                    messageFromYandexAccount.setEmailCustomer(email);
                    messageFromYandexAccount.sendNotifacationToCustomer("Welcome !!!", textToSend);
                }
            }
        }else{
            //pjp.proceed();
            System.out.println("No arguments passed");
        }
    }

}
