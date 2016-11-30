/**
 * Created by DmitriyBrosalin on 11/09/16.
 */

package ru.dimas.brosalin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dimas.brosalin.BusinessLogicBOImpl.UserCreationInSystem;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.ServiceImpl.UserServiceImpl;

import java.math.BigInteger;
import java.util.Random;

import static java.lang.StrictMath.abs;

// justbank

public class Application {

    static long generateNumberWallet(long temp){
        Random random = new Random();
        long cur = abs(random.nextLong());
        while(cur == temp){
            cur = abs(random.nextLong());
        }
        return cur;
    }

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        User user_1 = (User)context.getBean("userModel");
        user_1.setAge(22);
        user_1.setPassword("qwerty");
        user_1.setUserFirstName("Ilya");
        user_1.setUserLastName("Kharchnko");
        user_1.setEmail("dima0294@yandex.ru");
        user_1.setGender("m");
        user_1.setUserPhoneNumber("+79851730921");
        user_1.setUserId(1);

        UserCreationInSystem userCreationInSystem = (UserCreationInSystem)context.getBean("userCreationInSystem");
        userCreationInSystem.setUser(user_1);
        userCreationInSystem.registerUser();

    }

}
