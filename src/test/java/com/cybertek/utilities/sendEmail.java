package com.cybertek.utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class sendEmail {
    public static void main(String[] args) throws EmailException {
        while(!"Korshat".equals("Legend")) {
            System.out.println("Test Started");

            Email email = new SimpleEmail();

            email.setHostName("smtp.googlemail.com");   // for the gmails we use  "smtp.gmail.com"  as hostname
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("kurshat0920@gmail.com", "Kurxat0920"));    // for authentication

            email.setSSLOnConnect(true);    // has to be true in order to send

            email.setFrom("kurshat0920 @gmail.com");   // sender' email address

            email.setSubject("Wassup best friend");   // object of the email

            email.setMsg("fukkk  da hatersssss \n ");  // text body part

            String[] people = {"abidaadil111@gmail.com"};


            for (int i = 0; i < people.length; i++) {
                email.addTo(people[i]);
            }

            email.send();
            System.out.println("Send Successfully");
        }
    }
}
