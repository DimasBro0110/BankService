package ru.dimas.brosalin.Notification;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by DmitriyBrosalin on 27/11/2016.
 */

public class SendMessageFromYandexAccount {
    private String emailCustomer;
    final String emailServicePassword;
    final String emailService;
    private Session session;

    public SendMessageFromYandexAccount() {
        emailService = "{$EMAIL}";
        emailServicePassword = "{$PASSWORD}";
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailService, emailServicePassword); /*
                        hardcode (( very bad, soon will be checked
                        */
                    }
                });
    }


    public int sendNotifacationToCustomer(String topic, String text){
        try{
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(emailService));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailCustomer));
            mimeMessage.setSubject(topic);
            mimeMessage.setText(text);
            Transport.send(mimeMessage);
            return 0;
        }catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }
}
