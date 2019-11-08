/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emmerich.HelpdeskApp.util;

import br.com.emmerich.HelpdeskApp.bean.Chamado;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author estagiodev
 */
public class SendEmail {

    private final String emailUser = "xxx@email.com";
    private final String emailPasswd = "passwd";

    public boolean send(Chamado chamado) throws UnsupportedEncodingException {

        if (chamado != null) {

            /*Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
             props.put("mail.smtp.socketFactory.port", "465");
             props.put("mail.smtp.socketFactory.class",
             "javax.net.ssl.SSLSocketFactory");
             props.put("mail.smtp.auth", "true");
             props.put("mail.smtp.port", "465");*/
            
            String smtpHostServer = "smtp.example.com";
            String emailID = "email_me@example.com";
            Properties props = System.getProperties();

            props.put("mail.smtp.host", smtpHostServer);

            Session session = Session.getInstance(props, null);
            session.setDebug(true);

            try {

                Address[] toUser = InternetAddress.parse("dev2@brametec.com.br");

                MimeMessage msg = new MimeMessage(session);
                //set message headers
                msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
                msg.addHeader("format", "flowed");
                msg.addHeader("Content-Transfer-Encoding", "8bit");

                msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));
                msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
                msg.setSubject("Chamado - HelpDesk", "UTF-8");
                msg.setText(chamado.toString(), "UTF-8");
                msg.setSentDate(new Date());
                msg.setRecipients(Message.RecipientType.TO, toUser);
                System.out.println("Message is ready");
                Transport.send(msg);

                /*Message message = new MimeMessage(session);
                 message.setFrom(new InternetAddress("admin@test.com"));
                 message.setRecipient(Message.RecipientType.TO, new InternetAddress("a@b.com"));
                 message.setSubject("Chamado - HelpDesk");
                 message.setText(chamado.toString()); // as "text/plain"
                 message.setSentDate(new Date());
                 Transport.send(message);*/
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
}
