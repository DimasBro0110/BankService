/**
 * Created by DmitriyBrosalin on 11/09/16.
 */

package ru.dimas.brosalin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.ServiceImpl.UserServiceImpl;

// justbank

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
        User user_test = userDAOImpl2.getUserByEmail("dima0294@yandex.ru");

        System.out.println(user_test.toJson());


    }

}
