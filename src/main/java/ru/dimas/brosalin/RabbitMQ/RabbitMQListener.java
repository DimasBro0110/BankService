package ru.dimas.brosalin.RabbitMQ;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.http.MediaType;
import ru.dimas.brosalin.BusinessLogicBOImpl.TransferMoney;
import ru.dimas.brosalin.BusinessLogicBOImpl.UserCreationInSystem;
import ru.dimas.brosalin.Models.User;
import org.json.simple.parser.JSONParser;
import ru.dimas.brosalin.ServiceImpl.UserServiceImpl;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DmitriyBrosalin on 12/12/2016.
 */
public class RabbitMQListener implements ChannelAwareMessageListener{

    private TransferMoney transferMoney;
    private User user;
    private UserCreationInSystem userCreationInSystem;
    private Logger logger = Logger.getLogger(RabbitMQListener.class.getName());
    private JSONObject jsonObject;
    private JSONParser jsonParser;
    private UserServiceImpl userService;

    public void setTransferMoney(TransferMoney transferMoney) {
        this.transferMoney = transferMoney;
    }

    public void setUserCreationInSystem(UserCreationInSystem userCreationInSystem) {
        this.userCreationInSystem = userCreationInSystem;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        String messageBody = new String(message.getBody());
        String correlationId = new String(message.getMessageProperties().getCorrelationId());
        String replyTo = message.getMessageProperties().getReplyTo();
        logger.log(Level.INFO,
                "Starting processing task:\n"
                        + "Body: " + messageBody + "\n"
                        + "Id:" + correlationId + "\n"
                        + "Reply To" + replyTo);
        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties
                .Builder()
                .correlationId(correlationId)
                .contentType(MediaType.APPLICATION_JSON.getType())
                .build();

        jsonParser = new JSONParser();
        jsonObject = (JSONObject) jsonParser.parse(messageBody);

        String code = (String)jsonObject.get("operation_info");

//        JSONObject response1 = new JSONObject();
//        response1.put("operation_key", "0010");
//        response1.put("status", "bad");
//        channel.basicPublish("", replyTo, basicProperties, response1.toString().getBytes());

        if(code != null){
            if(code.equals("0001")){
                JSONObject userEntity = (JSONObject) jsonObject.get("userinfo");
                String userName = (String)userEntity.get("firstname");
                String userLastName = (String)userEntity.get("lastname");
                String userPassword = (String)userEntity.get("password");
                //int age = (Integer)userEntity.get("user_age");
                String userEmail = (String)userEntity.get("email");
                String userPhone = (String)userEntity.get("phone");
                String userGender = (String)userEntity.get("user_gender");
                user.setUserFirstName(userName);
                user.setUserLastName(userLastName);
                user.setAge(100);
                user.setUserPhoneNumber(userPhone);
                user.setEmail(userEmail);
                user.setPassword(userPassword);
                user.setGender("m");
                userCreationInSystem.setUser(user);
                int resultOfCreation = userCreationInSystem.registerUser();
                logger.log(Level.INFO, "\n\n" + String.valueOf(resultOfCreation));
                if(resultOfCreation == 1){
                    JSONObject response = new JSONObject();
                    response.put("operation_key", "0001");
                    response.put("status", "bad");
                    response.put("description", "User with the same email or phone exists");
                    channel.basicPublish("", replyTo, basicProperties, response.toString().getBytes());
                }else if(resultOfCreation == 0){
                    JSONObject response = new JSONObject();
                    response.put("operation_key", "0001");
                    response.put("status", "ok");
                    response.put("description", "User created successfully");
                    channel.basicPublish("", replyTo, basicProperties, response.toString().getBytes());
                }else{
                    JSONObject response = new JSONObject();
                    response.put("operation_key", "0001");
                    response.put("status", "bad");
                    response.put("description", "User can't be created");
                    channel.basicPublish("", replyTo, basicProperties, response.toString().getBytes());
                }
            }else if(code.equals("0010")){
                JSONObject userEntity = (JSONObject) jsonObject.get("user_info");
                String userName = (String)userEntity.get("user_first_name");
                String userLastName = (String)userEntity.get("user_last_name");
                String userPassword = (String)userEntity.get("user_password");
                int age = (Integer)userEntity.get("user_age");
                String userEmail = (String)userEntity.get("user_email");
                String userPhone = (String)userEntity.get("user_phone");
                String userGender = (String)userEntity.get("user_gender");
                int resultOfDelete = userService.deleteUserByPhone(userPhone);
                if(resultOfDelete == 0){
                    JSONObject response = new JSONObject();
                    response.put("operation_key", "0010");
                    response.put("status", "bad");
                    response.put("description", "User with phone: " + userPhone + " successfully deleted");
                    channel.basicPublish("", replyTo, basicProperties, response.toString().getBytes());
                }else{
                    JSONObject response = new JSONObject();
                    response.put("operation_key", "0010");
                    response.put("status", "bad");
                    response.put("description", "User with phone: " + userPhone + " can't be deleted");
                    channel.basicPublish("", replyTo, basicProperties, response.toString().getBytes());
                }

            }else{
                JSONObject response = new JSONObject();
                response.put("operation_key", "0010");
                response.put("status", "bad");
                channel.basicPublish("", replyTo, basicProperties, response.toString().getBytes());
            }
        }
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}