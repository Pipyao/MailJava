package com.ksu;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    private static String mail;
    private  static String first;
    private  static String last;
    private  static String mess;

    public void Send(String Mail, String First, String Last, String Mess) {

        first = First;
        last = Last;
        mail = Mail;
        mess = Mess;
        final String username = "alabudabudaptap@gmail.com";
        final String password = "1Qwerty123";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("alabudabudaptap@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail)
            );
            message.setSubject("Тестовое письмо");
            message.setText("Здравствуйте, "+first+" "+last+", теперь у нас есть ваша почта\n"+mess);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}