/**
 * Created by DmitriyBrosalin on 11/09/16.
 */

package ru.dimas.brosalin;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dimas.brosalin.BusinessLogicBOImpl.UserCreationInSystem;
import ru.dimas.brosalin.Models.User;
import ru.dimas.brosalin.Notification.SendMessageByPhoneNumber;

import java.io.IOException;

// justbank
// localhost:15672 usr:DIMAS pass:DIMAS

public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        User user_1 = (User)context.getBean("userModel");
//        user_1.setAge(21);
//        user_1.setPassword("qwerty");
//        user_1.setUserFirstName("Mike");
//        user_1.setUserLastName("Ivanov");
//        user_1.setEmail("airxster@gmail.com");
//        user_1.setGender("m");
//        user_1.setUserPhoneNumber("+79851730934");
//        user_1.setUserId(1);

//        UserCreationInSystem userCreationInSystem = (UserCreationInSystem)context.getBean("userCreationInSystem");
//        userCreationInSystem.setUser(user_1);
//        int result = userCreationInSystem.registerUser();
//        SendMessageByPhoneNumber notificationGun = (SendMessageByPhoneNumber)context.getBean("phoneNotification");
//        int result = notificationGun.sendMessage("Привет, из моего сервиса!!!", "+79851730921");
//        notificationGun.sendMessage("Hello World", "+79099357357");
//        notificationGun.sendMessage("Hello World", "+79154271965");
//        notificationGun.sendMessage("Вы должны денег организации ООО \"Кавказ\", ждите сотрудников, Мага", "+79296076210");
//        System.out.println(result);

        RabbitTemplate template = context.getBean(RabbitTemplate.class);

    }

}
