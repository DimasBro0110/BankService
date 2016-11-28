/**
 * Created by DmitriyBrosalin on 11/09/16.
 */

package ru.dimas.brosalin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.coyote.http2.Stream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dimas.brosalin.DAO.*;
import ru.dimas.brosalin.Models.*;
import ru.dimas.brosalin.Notification.SendMessageFromYandexAccount;
import ru.dimas.brosalin.ServiceImpl.AccountServiceImpl;
import ru.dimas.brosalin.ServiceImpl.UserServiceImpl;
import ru.dimas.brosalin.Session.SessionManagment;

import java.sql.Timestamp;

// justbank

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Application {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        User user_1 = (User)context.getBean("userModel");
        user_1.setAge(22);
        user_1.setPassword("qwerty");
        user_1.setUserFirstName("Dmitriy");
        user_1.setUserLastName("Brosalin");
        user_1.setEmail("dima0294@yandex.ru");
        user_1.setGender("m");
        user_1.setUserPhoneNumber("+79851730921");
        user_1.setUserId(1);

        UserServiceImpl userDAOImpl2 = (UserServiceImpl) context.getBean("userService");
//        userDAOImpl2.saveEntity(user_1);
        Account accountTest = userDAOImpl2.getAccountByUserEmail("dima0294@yandex.ru");
        Wallet wallet = userDAOImpl2.getWalletFromUserByPhoneNumber("+79851730921");

        System.out.println(wallet);
        System.out.println(accountTest.toJson());

//        Account account = (Account) context.getBean("accountModel");
//        account.setAccountCreation(new Timestamp(System.currentTimeMillis()));
//        account.setUser(user_1);
//
//        AccountServiceImpl accountService = (AccountServiceImpl) context.getBean("accountService");
//        accountService.saveEntity(account);

    }

}
