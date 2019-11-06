/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emmerich.HelpdeskApp.util;

import br.com.emmerich.HelpdeskApp.bean.Chamado;
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

    public boolean send(Chamado chamado) {

        if (chamado != null) {

            Properties props = new Properties();
            /*props.put("mail.smtp.host", "smtp.gmail.com");
             props.put("mail.smtp.socketFactory.port", "465");
             props.put("mail.smtp.socketFactory.class",
             "javax.net.ssl.SSLSocketFactory");
             props.put("mail.smtp.auth", "true");
             props.put("mail.smtp.port", "465");*/
            props.put("mail.smtp.host", "127.0.0.1");
            props.put("mail.smtp.port", "25");
            props.put("mail.debug", "true");
            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);

            try {

                Address[] toUser = InternetAddress.parse("dev2@brametec.com.br");

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("admin@test.com"));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress("a@b.com"));
                message.setSubject("Chamado - HelpDesk");
                message.setText(chamado.toString()); // as "text/plain"
                message.setSentDate(new Date());
                Transport.send(message);
                /**
                 * Método para enviar a mensagem criada
                 */
                Transport.send(message);

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
}
