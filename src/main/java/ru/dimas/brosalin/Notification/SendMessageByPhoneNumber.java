package ru.dimas.brosalin.Notification;

/**
 * Created by DmitriyBrosalin on 03/12/2016.
 */

import com.twilio.sdk.*;
import com.twilio.sdk.resource.factory.*;
import com.twilio.sdk.resource.instance.*;
import com.twilio.sdk.resource.list.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SendMessageByPhoneNumber {
    private final String accountSID;
    private final String accountApiKey;
    private String fromPhoneNumber;
    private final TwilioRestClient twilioClient;

    public SendMessageByPhoneNumber(String sid, String apiKey, String fromPhoneNumber){
        this.accountSID = sid;
        this.accountApiKey = apiKey;
        this.fromPhoneNumber = fromPhoneNumber;
        this.twilioClient = new TwilioRestClient(accountSID, accountApiKey);
    }

    public int sendMessage(String messageTemplate, String phoneNumber){
        try{
            List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
            valuePairs.add(new BasicNameValuePair("To", phoneNumber));
            valuePairs.add(new BasicNameValuePair("From", fromPhoneNumber));
            valuePairs.add(new BasicNameValuePair("Body", messageTemplate));
            MessageFactory messageFactory = twilioClient.getAccount().getMessageFactory();
            Message message = messageFactory.create(valuePairs);
            return 1;
        }catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }

}
