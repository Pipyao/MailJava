package com.ksu;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    private static String mail;
    private  static String first;
    private  static String last;
    private  static String messtext;



    public void Send(String Mail, String First, String Last, String MessText,String Dom) {

        first = First;
        last = Last;
        messtext = MessText;
        mail = Mail + Dom;
        final String username = "hovopro99@gmail.com";
        final String password = "d6w299dr7h";

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
            message.setFrom(new InternetAddress("hovopro99@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(SendEmail.mail)
            );
            message.setSubject("Welcome to the club buddy");
            message.setText("Samurai, "+first+" "+last+" "+messtext+"");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}