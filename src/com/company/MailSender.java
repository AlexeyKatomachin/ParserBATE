package com.company;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender
{
    private MimeMessage message;
    public void MailSender (String mailOfRequest, String mailToSend, String host) throws AddressException {
        Properties properties = System.getProperties();
        properties.setProperty("mail.stmp.host", host);

        Session session = Session.getDefaultInstance(properties);
        message = new MimeMessage(session);

        try
        {
            message.setFrom(new InternetAddress(mailToSend));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailOfRequest));
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }

    public void MessageError (String data)
    {
        try
        {
            message.setText("Error Transporting \n Next Game:  " + data);
            Transport.send(message);
        }catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }

    public  void MessageIsSend (String data)
    {
        try
        {
            message.setText("Next Game:  " + data);
            Transport.send(message);
        }catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }
}
